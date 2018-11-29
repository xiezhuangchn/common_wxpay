package com.hnair.pay.wx;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.agent.weixin.Request.WxPayRefundQueryRequest;
import com.hnair.pay.agent.weixin.Response.WxPayRefundQueryResult;
import com.hnair.pay.agent.weixin.Response.notify.WxPayRefundNotifyResult;
import com.hnair.pay.agent.weixin.constant.WxPayConstants.ResultCode;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.impl.WxParsePayResultImpl;
import com.hnair.pay.agent.weixin.service.impl.WxPayServiceImpl;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.PayCommonService;
import com.hnair.pay.common.enums.CallOrderStatusEnum;
import com.hnair.pay.common.enums.NoPreNoEnum;
import com.hnair.pay.common.enums.pay.PayStatusEnum;
import com.hnair.pay.common.enums.refund.OrderRefundStatusEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.refund.OrderRefundRequest;
import com.hnair.pay.common.models.dto.request.wx.RefundQueryRequest;
import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import com.hnair.pay.common.models.dto.response.refund.OrderRefundResponse;
import com.hnair.pay.common.models.dto.response.wx.WxRefundOrderStatusResponse;
import com.hnair.pay.common.utils.TimeUtil;
import com.hnair.pay.db.dao.mapext.RefundOrderMapperExt;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.dao.mapper.RefundOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.PayOrderExample;
import com.hnair.pay.db.entity.RefundOrder;
import com.hnair.pay.db.entity.RefundOrderExample;
import com.hnair.pay.rpc.refund.RefundRpcService;
import com.hnair.pay.rpc.refund.dto.RefundNotifyRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


/**
 * bing.cheng 改造
 * 退款servie
 */
@Service
public class WxRefundService {

    private final Logger logger = LoggerFactory.getLogger("WxRefundService");

    @Autowired
    private PayOrderMapper payOrderMapper;
    @Autowired
    private RefundOrderMapper refundOrderMapper;
    @Autowired
    private RefundOrderMapperExt refundOrderMapperExt;

    @Autowired
    private WxPayServiceImpl wxPayServiceImpl;
    @Autowired
    private WxParsePayResultImpl wxParsePayResultImpl;
    @Autowired
    private RefundRpcService refundRpcService;
    @Autowired
    private ChannelCommonService channelCommonService;
    @Autowired
    private PayCommonService payCommonService;

    /**
     * 校验存储退款信息
     *
     * @param orderRefundRequest
     * @return
     */
    @Transactional
    public PayPlatformBaseResponse orderRefundInfoSave(OrderRefundRequest orderRefundRequest, PayPlatformBaseRequest baseDto) {
        OrderRefundResponse orderRefundResponse = new OrderRefundResponse();

        RefundOrderExample example = new RefundOrderExample();
        example.createCriteria().andBusOrderNoEqualTo(orderRefundRequest.getOrderNo());
        List<RefundOrder> list = refundOrderMapper.selectByExample(example);

        //退款信息已经存在 一个订单一笔退款
        if (null != list && list.size() > 0) {
            RefundOrder refundOrder = list.get(0);
            //重复直接返回成功
            if (OrderRefundStatusEnum.REFUND_SUCCES.getCode() == refundOrder.getRefundStatus()) {
                //已经退款成功了 直接返回退款成功
                orderRefundResponse.setRefundStatus(OrderRefundStatusEnum.REFUND_SUCCES.getCode());
            }
            orderRefundResponse.setRefundOrderNo(refundOrder.getRefundOrderNo());
            return channelCommonService.createPayPlatformCommonResponse(orderRefundResponse, baseDto);
        }

        //查询支付订单是否存在
        PayOrderExample payOrderExample = new PayOrderExample();
        payOrderExample.createCriteria().andBusOrderNoEqualTo(orderRefundRequest.getOrderNo());
        List<PayOrder> payOrderlist = payOrderMapper.selectByExample(payOrderExample);
        if (payOrderlist == null || payOrderlist.size() <= 0) {
            throw new PayException("发起款异常，无对应的支付信息，业务订单号" + orderRefundRequest.getOrderNo());
        }

        //验证支付订单是否支付成功
        PayOrder payOrder = payOrderlist.get(0);
        if (payOrder.getPayStatus() != PayStatusEnum.PAY_SUCCESS.getCode().byteValue()) {
            throw new PayException("存储退款信息异常，订单未支付成功,不允许发生退款操作，业务订单号:" + orderRefundRequest.getOrderNo());
        }

        //验证支付金额和退款金额
        if (payOrder.getTotalFee().longValue() != orderRefundRequest.getTotalFee().longValue()) {
            throw new PayException("退款异常,退款金额不对，不允许发生非法退款操作，业务订单号:" + orderRefundRequest.getOrderNo());
        }

        //插入退款信息
        RefundOrder insetRefundOrder = insertRefundInfo(orderRefundRequest, payOrder);

        logger.info("用户发起退款操作，插入退款操作记录成功,业务订单号:{}", orderRefundRequest.getOrderNo());
        orderRefundResponse.setRefundOrderNo(insetRefundOrder.getRefundOrderNo());
        return channelCommonService.createPayPlatformCommonResponse(orderRefundResponse, baseDto);
    }

    /**
     * 微信退款成功回调处理
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    @Transactional
    public String wxNotifyRefundResult(HttpServletRequest httpServletRequest) throws Exception {
        String xml = payCommonService.getStringFromHttpServletRequest(httpServletRequest, "wxNotifyRefundResult");
        logger.info("微信退款回调 date:{}，原始报文:{}", LocalDateTime.now(), xml);
        WxPayRefundNotifyResult refundNotifyResult = wxParsePayResultImpl.parseRefundNotifyResult(xml);
        logger.info("微信回调，解密请求报文信息json{}", JSON.toJSONString(refundNotifyResult));

        if (refundNotifyResult.getReturnCode().equalsIgnoreCase(ResultCode.SUCCESS)) {
            //支付系统退款单号
            String busRefundOrderNo = refundNotifyResult.getReqInfo().getOutRefundNo();
            RefundOrder refundOrder = refundOrderMapperExt.selectByRefundOrderNoForUpdate(busRefundOrderNo);
            if (null == refundOrder) {
                throw new WxPayException("退款单号未找到，请求参数" + xml);
            }

            if (refundOrder.getTotalFee() - refundNotifyResult.getReqInfo().getRefundFee() != 0) {
                throw new WxPayException("退款回调结果，退款金额不一致,报文信息，请求参数" + xml);
            }
            if (refundOrder.getRefundStatus().intValue() == OrderRefundStatusEnum.REFUND_SUCCES.getCode().intValue()) {
                logger.info("退款单号，订单状态已经发生改变，无须再次修改,状态信息{}", JSON.toJSON(refundOrder));
                return null;
            }

            //微信退款成功更新状态 插入微信退款单号
            updateRefundInfoForRefundSuccess(refundNotifyResult);

            return busRefundOrderNo;
        }
        throw new WxPayException("微信回调状态失败，返回code不是success,请求报文: " + xml);
    }

    private void updateRefundInfoForRefundSuccess(WxPayRefundNotifyResult refundNotifyResult) throws Exception{
        //更新退款状态
        RefundOrder record = new RefundOrder();
        record.setRefundTradeNo(refundNotifyResult.getReqInfo().getRefundId()); //微信退款单号保存
        record.setRefundTime(TimeUtil.parse_yyyy_MM_dd_HH_mm_ss(refundNotifyResult.getReqInfo().getSuccessTime()));
        record.setRefundStatus(OrderRefundStatusEnum.REFUND_SUCCES.getCode());
        record.setUpdateTime(new Date());

        RefundOrderExample updateExample = new RefundOrderExample();
        updateExample.createCriteria().andRefundOrderNoEqualTo(refundNotifyResult.getReqInfo().getOutRefundNo()).
                andTradePayNoEqualTo(refundNotifyResult.getReqInfo().getTransactionId());
        int i = refundOrderMapper.updateByExampleSelective(record, updateExample);
        if (i <= 0) {
            throw new WxPayException("退款回调结果，更新数据库退款状态失败，更新入参：" + JSON.toJSONString(record));
        }
    }


    /**
     * 通知订单系统 退款成功
     * @param busRefundOrderNo
     */
    public void notifyRefundOrderStatus(String busRefundOrderNo) {
        try {
            RefundNotifyRequest refundNotifyRequest = buildNotifyOrderRequest(busRefundOrderNo);
            ApiResponse<Boolean> result = refundRpcService.callOrderNotifyRefundStatus(refundNotifyRequest, channelCommonService.getRefundNotifyUrlByChannel(refundNotifyRequest.getBusChannel()));
            if (result.getData()) { //更新通知订单系统状态
                RefundOrder record = new RefundOrder();
                record.setCallOrderStatus(CallOrderStatusEnum.SUCCESS.getCode().byteValue());
                RefundOrderExample example = new RefundOrderExample();
                example.createCriteria().andRefundOrderNoEqualTo(refundNotifyRequest.getRefundOrderNo());
                refundOrderMapper.updateByExampleSelective(record,example);
            } else {
                //通知订单状态失败，后面批处理接着通知
                logger.error("通知订单系统退款成功，请求失败，请求报文{}", JSON.toJSONString(refundNotifyRequest));
            }
        } catch (Exception e) {
            logger.error("通知订单系统退款成功，请求失败，请求报文busRefundOrderNo:" + busRefundOrderNo, e);
        }
    }

    /**
     * 调用微信接口 查询退款信息
     * @param refundQueryRequest
     * @return
     * @throws Exception
     */
    public PayPlatformBaseResponse refundQuery(RefundQueryRequest refundQueryRequest, PayPlatformBaseRequest baseDto) throws Exception{
        WxRefundOrderStatusResponse response = new WxRefundOrderStatusResponse();

        RefundOrderExample refundOrderExample = new RefundOrderExample();
        refundOrderExample.createCriteria().andBusPayNoEqualTo(refundQueryRequest.getBusPayOrderNo());
        List<RefundOrder> refundOrders = refundOrderMapper.selectByExample(refundOrderExample);
        if (null == refundOrders || refundOrders.size() <= 0) {
            throw new PayException(ErrorCode.REFUND_ORDER_IS_NOT_EXST);
        }

        //调用微信查询
        WxPayRefundQueryResult result = callWxRefundQuery(refundOrders.get(0));

        String resultStr = JSON.toJSONString(result);
        response.setXml(result.getXmlString());
        response.setResultJson(resultStr);
        return channelCommonService.createPayPlatformCommonResponse(response, baseDto);
    }

    /**
     * 调用微信接口查询退款信息
     * @param refundOrder
     * @return
     */
    public WxPayRefundQueryResult callWxRefundQuery(RefundOrder refundOrder) throws Exception{
        WxPayRefundQueryRequest wxPayRefundQueryRequest = new WxPayRefundQueryRequest();
        wxPayRefundQueryRequest.setSubMchId(refundOrder.getSubMchId());
        wxPayRefundQueryRequest.setOutRefundNo(refundOrder.getRefundOrderNo());
        WxPayRefundQueryResult result = wxPayServiceImpl.refundQuery(wxPayRefundQueryRequest);
        return result;
    }

    /**
     * 构造退款成功 通知订单系统请求
     * @param busRefundOrderNo
     * @return
     */
    private RefundNotifyRequest buildNotifyOrderRequest(String busRefundOrderNo) {
        RefundOrderExample example = new RefundOrderExample();
        example.createCriteria().andRefundOrderNoEqualTo(busRefundOrderNo);
        List<RefundOrder> list = refundOrderMapper.selectByExample(example);
        RefundOrder refundOrder = list.get(0);
        RefundNotifyRequest req = new RefundNotifyRequest();
        req.setRefundOrderNo(refundOrder.getRefundOrderNo());
        req.setOrderId(refundOrder.getBusOrderNo());
        req.setOrderType(refundOrder.getBusType());
        req.setRefundAmount(refundOrder.getRefundFee());
        if (OrderRefundStatusEnum.REFUND_SUCCES.getCode() == refundOrder.getRefundStatus()) {
            req.setRefundStatus(OrderRefundStatusEnum.REFUND_SUCCES.getCode());
        } else {
            throw new RuntimeException("退款未成功，通知订单失败,busRefundOrderNo=" + busRefundOrderNo);
        }

        req.setRefundTime(refundOrder.getRefundTime());
        req.setRefundTradeNo(refundOrder.getRefundTradeNo());
        req.setRefunFailReason("退款成功");
        req.setBusChannel(refundOrder.getBusChannel());
        return req;
    }

    /**
     * 退款信息存储
     *
     * @param orderRefundRequest
     * @param payOrder
     */
    private RefundOrder insertRefundInfo(OrderRefundRequest orderRefundRequest, PayOrder payOrder) {
        RefundOrder refundOrder = new RefundOrder();
        refundOrder.setRefundOrderNo(payCommonService.getNoByPayOrderInfo(payOrder, NoPreNoEnum.REFUND_NO_PREX.getCode()));
        refundOrder.setBusPayNo(orderRefundRequest.getPayOrderNo());
        refundOrder.setBusOrderNo(orderRefundRequest.getOrderNo());
        refundOrder.setTotalFee(orderRefundRequest.getTotalFee());
        refundOrder.setRefundFee(orderRefundRequest.getRefundFee());
        refundOrder.setOpUserId(orderRefundRequest.getMchId());
        refundOrder.setRefundReason(orderRefundRequest.getReason());
        refundOrder.setRefundStatus(OrderRefundStatusEnum.PENDING.getCode());
        refundOrder.setTradePayNo(orderRefundRequest.getTradePayNo());
        refundOrder.setRefundFeeType("CNY");
        refundOrder.setRefundReason(orderRefundRequest.getReason());
        refundOrder.setNum(0);
        refundOrder.setSubMchId(payOrder.getSubMchId());
        refundOrder.setBusType(payOrder.getBusType());
        refundOrder.setBusChannel(orderRefundRequest.getBusChannel());
        refundOrder.setCallOrderStatus(CallOrderStatusEnum.INIT.getCode().byteValue());
        Date time = new Date();
        refundOrder.setCreateTime(time);
        refundOrder.setUpdateTime(time);
        int affectedCount = refundOrderMapper.insertSelective(refundOrder);
        if (affectedCount <= 0) {
            throw new PayException("退款异常，退款操作插入入库失败，操作记录信息{}" + orderRefundRequest.getOrderNo());
        }
        return refundOrder;
    }

}
