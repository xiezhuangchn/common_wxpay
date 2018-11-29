package com.hnair.pay.service;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.agent.weixin.Response.notify.WxPayOrderNotifyResult;
import com.hnair.pay.agent.weixin.constant.WxPayConstants;
import com.hnair.pay.agent.weixin.service.impl.WxParsePayResultImpl;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.enums.CallOrderStatusEnum;
import com.hnair.pay.common.enums.pay.PayStatusEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.hnair.pay.common.utils.TimeUtil;
import com.hnair.pay.db.dao.mapext.PayOrderExtMapper;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.PayOrderExample;
import com.hnair.pay.rpc.pay.PayRpcService;
import com.hnair.pay.rpc.pay.dto.PayNotifyRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class WxNotifyService {

    private final Logger logger = LoggerFactory.getLogger(WxNotifyService.class);

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private ChannelCommonService channelCommonService;

    @Autowired
    private PayRpcService payRpcService;

    @Autowired
    private PayOrderExtMapper payOrderExtMapper;

    @Autowired
    WxParsePayResultImpl wxParsePayResultImpl;

    /**
     * 通知订单系统，支付状态信息
     * @param busPayNo
     */
    public void notifyOrderPayStatus(String busPayNo) {
        try {
            PayNotifyRequest payNotifyRequest = buildNotifyPayRequest(busPayNo);
            ApiResponse<Boolean> result = payRpcService.callOrderNotifyPayStatus(payNotifyRequest, channelCommonService.getPayNotifyUrlByChannel(payNotifyRequest.getBusChannel()));
            logger.info("微信回调，同步通知订单系统,订单系统返回值：{}", JSON.toJSONString(result));
            if (result.getData()) {
                //同步成功 更新状态
                PayOrder record = new PayOrder();
                record.setSendStatus(CallOrderStatusEnum.SUCCESS.getCode().byteValue());
                PayOrderExample example = new PayOrderExample();
                example.createCriteria().andTradePayNoEqualTo(payNotifyRequest.getTradePayNo());
                payOrderMapper.updateByExampleSelective(record, example);
            }
        } catch (Exception e) {
            logger.info("notifyOrderPayStatus error, busPayNo{}", busPayNo);
        }
    }

    public PayNotifyRequest buildNotifyPayRequest(String busPayNo) {
        PayOrderExample example = new PayOrderExample();
        example.createCriteria().andBusPayNoEqualTo(busPayNo);
        List<PayOrder> list = payOrderMapper.selectByExample(example);
        PayOrder payOrder = list.get(0);
        PayNotifyRequest payNotifyRequest = new PayNotifyRequest();
        payNotifyRequest.setOrderId(payOrder.getBusOrderNo());
        payNotifyRequest.setOrderType(payOrder.getBusType());
        payNotifyRequest.setPayAmount(payOrder.getTotalFee());
        payNotifyRequest.setPayTime(payOrder.getPaySuccessTime());
        payNotifyRequest.setTradePayNo(payOrder.getTradePayNo());
        payNotifyRequest.setBusChannel(payOrder.getBusChannel());
        return payNotifyRequest;
    }

    /**
     *  微信支付回调通知信息 1:开启事务 2.行锁，锁定订单状态记录 3.判断状态是否更新 4.如果已经更新 4.1：判断微信订单号，是否一致，如果不一致，发起退款？
     * @param resultxml
     * @return
     */
    @Transactional
    public String notifyUpdatePayStatus(String resultxml) throws Exception{
        WxPayOrderNotifyResult wxPayOrderNotifyResult = wxParsePayResultImpl.parseOrderNotifyResult(resultxml);
        logger.info("微信支付异步通知请求解析后的对象, wxPayOrderNotifyResult{}", JSON.toJSONString(wxPayOrderNotifyResult));
        //判断微信支付回调结果
        if (wxPayOrderNotifyResult.getResultCode().equalsIgnoreCase(WxPayConstants.ResultCode.SUCCESS)) {
            //商户订单号获取支付订单信息
            PayOrder payOrder = payOrderExtMapper.selectByPayOrderNoForUpdate(wxPayOrderNotifyResult.getOutTradeNo());
            if (payOrder == null) { //不存在的订单号 不做处理 属于异常情况
                logger.warn("维信诺回调，支付单号，未找到 payOrdeNo=" + wxPayOrderNotifyResult.getOutTradeNo());
                return null;
            }

            //校验返回的订单金额是否与商户侧的订单金额一致，防止数据泄漏导致出现“假通知”，造成资金损失。
            if (payOrder.getTotalFee().intValue() - wxPayOrderNotifyResult.getTotalFee() != 0) {
                logger.error("支付回调结果，支付金额不一致,报文信息{}", resultxml);
                throw new PayException("支付金额，信息不一致");
            }

            if (payOrder.getPayStatus() == PayStatusEnum.PAY_SUCCESS.getCode().byteValue()) {
                logger.info("微信重复通知, 支付状态已经支付成功，无须再次修改,状态信息{}", JSON.toJSON(payOrder));
                return null;
            }

            //更新数据库
            PayOrder record = new PayOrder();
            record.setPayStatus(PayStatusEnum.PAY_SUCCESS.getCode().byteValue());
            Date successTime = TimeUtil.parse(TimeUtil.yyyyMMddHHmmss, wxPayOrderNotifyResult.getTimeEnd());
            record.setTradePayNo(wxPayOrderNotifyResult.getTransactionId());
            record.setPaySuccessTime(successTime);
            record.setUpdateTime(new Date());
            PayOrderExample example = new PayOrderExample();
            example.createCriteria().andBusPayNoEqualTo(payOrder.getBusPayNo());
            payOrderMapper.updateByExampleSelective(record, example);

            return payOrder.getBusPayNo();
        } else {
            throw new PayException("支付成功，微信回调，业务处理异常,reqxml：" + resultxml);
        }
    }

}
