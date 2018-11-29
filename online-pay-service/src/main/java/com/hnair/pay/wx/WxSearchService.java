package com.hnair.pay.wx;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.agent.weixin.Request.WxPayOrderQueryRequest;
import com.hnair.pay.agent.weixin.Response.WxPayOrderQueryResult;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.IWxPay;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.enums.pay.PayStatusEnum;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.wx.OrderPayStatusSearchRequest;
import com.hnair.pay.common.models.dto.response.wx.OrderPayStatusSearchResponse;
import com.hnair.pay.common.utils.TimeUtil;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.PayOrderExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class WxSearchService {

  private final Logger logger = LoggerFactory.getLogger("WxSearchService");

  @Autowired
  private PayOrderMapper payOrderMapper;

  @Autowired
  private IWxPay wxPayService;
  @Autowired
  private ChannelCommonService channelCommonService;

  /**
   * order查询订单支付状态接口
   */
  public OrderPayStatusSearchResponse queryOrderPayStatus(OrderPayStatusSearchRequest req, PayPlatformBaseRequest baseDto)
          throws WxPayException, ParseException {
    logger.info("queryOrderPayStatus" + JSON.toJSONString(req));
    OrderPayStatusSearchResponse res = new OrderPayStatusSearchResponse();
    PayOrderExample payOrderExample = new PayOrderExample();
    payOrderExample.createCriteria().andBusOrderNoEqualTo(req.getBusOrderNo());
    List<PayOrder> payOrders = payOrderMapper.selectByExample(payOrderExample);
    if (null == payOrders || payOrders.size() <= 0) {
      logger.warn("queryOrderPayStatus 订单不存在 orderId：{}", req.getBusOrderNo());
      res.setPayStatus(PayStatusEnum.NO_PAY.getCode());
      return res;
    }
    PayOrder payOrder = payOrders.get(0);

    Integer payStatus = payOrder.getPayStatus().intValue();

    //支付成功直接返回
    if (payStatus == PayStatusEnum.PAY_SUCCESS.getCode()) {
      createSuccessResponse(payOrder, res, baseDto);
      return res;
    }

    //查询微信端
    WxPayOrderQueryRequest wxPayOrderQueryRequest = new WxPayOrderQueryRequest();
    wxPayOrderQueryRequest.setSubMchId(payOrder.getSubMchId());
    wxPayOrderQueryRequest.setOutTradeNo(payOrder.getBusPayNo());
    WxPayOrderQueryResult wxPayOrderQueryResult = wxPayService.queryOrder(wxPayOrderQueryRequest);
    //* SUCCESS—支付成功,REFUND—转入退款,NOTPAY—未支付,CLOSED—已关闭,REVOKED—已撤销（刷卡支付）,USERPAYING--用户支付中,PAYERROR--支付失败(其他原因，如银行返回失败)
    if ("SUCCESS".equals(wxPayOrderQueryResult.getTradeState())
        && "支付成功".equals(wxPayOrderQueryResult.getTradeStateDesc())) {
      PayOrderExample example = new PayOrderExample();
      example.createCriteria().andBusOrderNoEqualTo(payOrder.getBusOrderNo());
      PayOrder order = new PayOrder();
      order.setPayStatus(PayStatusEnum.PAY_SUCCESS.getCode().byteValue());
      Date successTime = TimeUtil.parse(TimeUtil.yyyyMMddHHmmss, wxPayOrderQueryResult.getTimeEnd());
      order.setPaySuccessTime(successTime);
      order.setTradePayNo(wxPayOrderQueryResult.getTransactionId());
      payOrderMapper.updateByExampleSelective(order, example);

      createSuccessResponse(payOrder, res, baseDto);
    } else {
      res.setPayStatus(PayStatusEnum.PAYMENT_FAILED.getCode());
    }
    return res;
  }

  private void createSuccessResponse(PayOrder payOrder, OrderPayStatusSearchResponse res, PayPlatformBaseRequest baseDto){

    res.setPayStatus(PayStatusEnum.PAY_SUCCESS.getCode());
    res.setOrderId(payOrder.getBusOrderNo());
    res.setOrderType(payOrder.getBusType());
    res.setPayTime(payOrder.getPaySuccessTime());
    res.setPayAmount(payOrder.getTotalFee());
    res.setTradePayNo(payOrder.getTradePayNo());

    channelCommonService.createPayPlatformCommonResponse(res, baseDto);

  }


}
