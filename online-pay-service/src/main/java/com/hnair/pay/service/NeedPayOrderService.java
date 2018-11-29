package com.hnair.pay.service;


import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.PayCommonService;
import com.hnair.pay.common.enums.pay.PayStatusEnum;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.wx.NoNeedPayOrderCreatePayOrderRequest;
import com.hnair.pay.common.models.dto.response.wx.NoNeedPayOrderCreatePayOrderResponse;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.PayOrderExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 不需要支付的订单单独处理
 */
@Service
public class NeedPayOrderService {

    private final Logger logger = LoggerFactory.getLogger(NeedPayOrderService.class);

    @Autowired
    public PayCommonService payCommonService;

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private ChannelCommonService channelCommonService;

    /**
     * 创建0元支付订单
     */
    public NoNeedPayOrderCreatePayOrderResponse createNoNeedPayOrder(
            NoNeedPayOrderCreatePayOrderRequest req, PayPlatformBaseRequest baseDto) {
        NoNeedPayOrderCreatePayOrderResponse resp = new NoNeedPayOrderCreatePayOrderResponse();
        // 先查询如果有 直接返回 如果没有 插入
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andBusOrderNoEqualTo(req.getOrderId());
        List<PayOrder> payOrders = payOrderMapper.selectByExample(example);

        Date curTime = new Date();
        PayOrder payOrder = new PayOrder();
        if (null != payOrders && payOrders.size() > 0) {
            payOrder = payOrders.get(0);
        } else {
            savePayOrder(payOrder, req, baseDto, curTime);
        }
        createNoNeedPayOrderResponse(req, payOrder, baseDto, resp);
        return resp;
    }

    private void savePayOrder(PayOrder payOrder, NoNeedPayOrderCreatePayOrderRequest req, PayPlatformBaseRequest baseDto, Date curTime) {
        payOrder.setSubMchId(req.getSubMchId());
        payOrder.setBusOrderNo(req.getOrderId());
        payOrder.setPayChannelType(baseDto.getPayChannelType());
        payOrder.setBusChannel(baseDto.getBusChannel());
        payOrder.setBusPayNo(payCommonService.getOrderNo());
        payOrder.setTotalFee(req.getPayAmount());
        payOrder.setPaySuccessTime(curTime);
        payOrder.setPayStatus(PayStatusEnum.PAY_SUCCESS.getCode().byteValue());
        payOrder.setBusType(req.getOrderType());
        payOrder.setUserId(req.getUserId());
        payOrder.setWxOpenId(req.getOpenId());
        payOrder.setCreateTime(curTime);
        payOrder.setUpdateTime(curTime);
        payOrder.setHotelId(req.getHotelId());
        payOrderMapper.insertSelective(payOrder);
    }

    private void createNoNeedPayOrderResponse(NoNeedPayOrderCreatePayOrderRequest req, PayOrder payOrder,
                                              PayPlatformBaseRequest baseDto, NoNeedPayOrderCreatePayOrderResponse resp){
        resp.setPayStatus(payOrder.getPayStatus().intValue());
        resp.setOrderId(req.getOrderId());
        resp.setOrderType(payOrder.getBusType());
        resp.setPayOrderId(payOrder.getBusPayNo());
        channelCommonService.createPayPlatformCommonResponse(resp, baseDto);
    }


}
