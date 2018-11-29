package com.hnair.pay.service.wx.wechart;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.agent.weixin.Request.WxPayUnifiedOrderRequest;
import com.hnair.pay.agent.weixin.Request.order.WxPayMpOrderResult;
import com.hnair.pay.agent.weixin.config.WxPayConfig;
import com.hnair.pay.agent.weixin.constant.WxPayConstants;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.impl.WxPayServiceImpl;
import com.hnair.pay.agent.weixin.utils.SignUtils;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.PayCommonService;
import com.hnair.pay.common.enums.pay.PayStatusEnum;
import com.hnair.pay.common.enums.pay.wx.WxPayTypeEnum;
import com.hnair.pay.common.enums.sharing.SharingValueEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.pay.wx.CreateWechartWxJSAPIPayOrderRequest;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.pay.BasePreCreateOrderResponse;
import com.hnair.pay.common.models.dto.response.pay.wx.CreateWechartWxJSAPIPayOrderResponse;
import com.hnair.pay.db.dao.mapper.PayOrderLogMapper;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.PayOrderExample;
import com.hnair.pay.db.entity.PayOrderLog;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微官网H5支付
 */
@Service
public class WeChartH5PayImpl extends WechartAbstactPay {

  private final Logger logger = LoggerFactory.getLogger("WxPayService");

  @Autowired
  private WxPayServiceImpl wxPayServiceImpl;

  @Autowired
  private PayOrderMapper payOrderMapper;

  @Autowired
  private PayOrderLogMapper payOrderLogMapper;

  @Autowired
  protected WxPayConfig config;

  @Autowired
  private ChannelCommonService channelCommonService;

  @Autowired
  public PayCommonService payCommonService;

  /**
   * 创建微官网的预下单信息
   * @param dto
   * @param baseDto
   * @return
   * @throws Exception
   */
  @Transactional
  public BasePreCreateOrderResponse createWechartWxPayOrder(
          CreateWechartWxJSAPIPayOrderRequest dto, PayPlatformBaseRequest baseDto) throws Exception {
    CreateWechartWxJSAPIPayOrderResponse resp = new CreateWechartWxJSAPIPayOrderResponse();
    if (StringUtils.isEmpty(dto.getSubAppId()) || StringUtils.isEmpty(dto.getSubMchId())) {
      String error = "subAppid和subMchId不允许为null,req=" + JSON.toJSONString(dto);
      logger.error(error);
      throw new PayException(error);
    }
    //1 查询是否已存在当前订单号的下单信息
    PayOrderExample payExample = new PayOrderExample();
    payExample.createCriteria().andBusOrderNoEqualTo(dto.getOrderId());
    List<PayOrder> payOrders = payOrderMapper.selectByExample(payExample);
    if (null != payOrders && payOrders.size() > 1) {
      throw new PayException(ErrorCode.ORDER_IS_MUTIL);
    }
    if (null != payOrders && payOrders.size() > 0) {
      //直接返回数据
      return wechartOrderWxPayOrder(payOrders.get(0), resp, baseDto);
    }

    String busPayNo = payCommonService.getOrderNo();

    //调用微信接口预下单
    WxPayMpOrderResult payInfo = createWxUnifiedOrder(dto, busPayNo, resp);

    String prepayId = payInfo.getPackageValue()
            .substring(payInfo.getPackageValue().indexOf("=") + 1);

    Date curTime = new Date();
    //更改本地下单转态
    PayOrder payOrder = new PayOrder();
    savePayOrderInfo(payOrder, dto, prepayId, curTime, busPayNo, baseDto);

    //5 保存支付日志
    savePayOrderLog(payOrder, curTime);

    //6 返回预支付回话标识给
    return wechartOrderWxPayOrder(payOrder, resp, baseDto);
  }

  private CreateWechartWxJSAPIPayOrderResponse wechartOrderWxPayOrder(PayOrder payOrder, CreateWechartWxJSAPIPayOrderResponse resp,
                                                                      PayPlatformBaseRequest baseDto) {
    String timeStamp = String.valueOf(System.currentTimeMillis());
    String nonceStr = timeStamp;
    String appId = payOrder.getSubAppId();
    if (StringUtils.isEmpty(appId)) {
      appId = config.getAppId();
    }
    resp.setAppId(appId);
    resp.setNonceStr(nonceStr);
    resp.setTimeStamp(timeStamp);
    resp.setSignType(WxPayConstants.SignType.MD5);
    resp.setPackageValue("prepay_id=" + payOrder.getPrepayId());
    resp.setOrderId(payOrder.getBusOrderNo());
    resp.setOrderType(payOrder.getBusType());
    resp.setPayOrderId(payOrder.getBusPayNo());
    resp.setPrePayId(payOrder.getPrepayId());
    Map<String, String> params = new HashMap<>();

    params.put("appId", appId);
    params.put("timeStamp", timeStamp);
    params.put("nonceStr", nonceStr);
    params.put("package", "prepay_id=" + payOrder.getPrepayId());
    params.put("signType", WxPayConstants.SignType.MD5);
    resp.setPaySign(SignUtils.createSign(params, WxPayConstants.SignType.MD5, config.getMchKey(), false));

    channelCommonService.createPayPlatformCommonResponse(resp, baseDto);
    return resp;

  }

  private void savePayOrderLog(PayOrder payOrder, Date curTime) throws Exception {
    PayOrderLog payOrderLog = new PayOrderLog();
    payOrderLog.setCreateTime(curTime);
    payOrderLog.setPayOrderNo(payOrder.getId());
    payOrderLog.setBusType("1");
    payOrderLog.setBusOrderNo(payOrder.getBusOrderNo());
    payOrderLog.setContext("创建微信预下单订单");
    payOrderLogMapper.insertSelective(payOrderLog);
  }


  private WxPayMpOrderResult createWxUnifiedOrder(
          CreateWechartWxJSAPIPayOrderRequest dto, String busPayNo, CreateWechartWxJSAPIPayOrderResponse resp) throws Exception {
    WxPayUnifiedOrderRequest prepayInfo = new WxPayUnifiedOrderRequest();

    prepayInfo.setSubMchId(dto.getSubMchId());
    prepayInfo.setSubAppId(dto.getSubAppId());
    prepayInfo.setSubOpenid(dto.getOpenId());

    prepayInfo.setOutTradeNo(busPayNo);
    prepayInfo.setTotalFee(dto.getPayAmount());
    prepayInfo.setBody(dto.getGoodsName());
    prepayInfo.setTradeType(WxPayConstants.TradeType.JSAPI);
    prepayInfo.setSpbillCreateIp(dto.getSpbillCreateIp());
    prepayInfo.setNotifyUrl(payNotifyUrl);
    prepayInfo.setDetail(dto.getGoodsDes());
    prepayInfo.setProfitSharing(SharingValueEnum.TRUE.getCode());

    WxPayMpOrderResult payInfo = null;
    try {
      payInfo = this.wxPayServiceImpl.createOrder(prepayInfo);
    } catch (WxPayException e) {
      logger.info("createWxUnifiedOrder error: ", JSON.toJSONString(payInfo));
      throw new PayException(ErrorCode.PRE_ORDER_FAIL.getCode(),e.getMessage());
    }
    return payInfo;
  }

  private void savePayOrderInfo(
          PayOrder payOrder, CreateWechartWxJSAPIPayOrderRequest req, String prepayId, Date curTime, String busPayNo, PayPlatformBaseRequest basedto) {
    // 支付宝或者微信订单号
    payOrder.setSubMchId(req.getSubMchId());
    payOrder.setSubAppId(req.getSubAppId());
    payOrder.setBusOrderNo(req.getOrderId());
    payOrder.setBusType(req.getOrderType());
    payOrder.setBusPayNo(busPayNo);
    payOrder.setTotalFee(req.getPayAmount());
    payOrder.setPayStatus(PayStatusEnum.NO_PAY.getCode().byteValue());
    payOrder.setBusChannel(basedto.getBusChannel());
    payOrder.setUserId(req.getUserId());
    payOrder.setHotelId(req.getHotelId());
    payOrder.setWxOpenId(req.getOpenId());
    payOrder.setCreateTime(curTime);
    payOrder.setUpdateTime(curTime);
    payOrder.setPayChannelType(basedto.getPayChannelType());
    payOrder.setTradeType(WxPayTypeEnum.JSAPI.getCode().byteValue());
    payOrder.setIsSharingOrder(SharingValueEnum.TRUE.getCode());
    payOrder.setPrepayId(prepayId);
    payOrderMapper.insertSelective(payOrder);
  }

}
