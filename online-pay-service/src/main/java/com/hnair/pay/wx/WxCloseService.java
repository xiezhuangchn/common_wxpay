package com.hnair.pay.wx;

import com.hnair.pay.agent.weixin.Request.WxPayOrderCloseRequest;
import com.hnair.pay.agent.weixin.Response.WxPayOrderCloseResult;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.impl.WxPayServiceImpl;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.wx.OrderCloseRequest;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import com.hnair.pay.common.models.dto.response.wx.OrderCloseResponse;
import com.hnair.pay.db.dao.mapext.PayOrderExtMapper;
import com.hnair.pay.db.entity.PayOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxCloseService {

    private final Logger logger = LoggerFactory.getLogger("WxCloseService");

    @Autowired
    private PayOrderExtMapper payOrderExtMapper;

    @Autowired
    private WxPayServiceImpl wxPayServiceImpl;
    @Autowired
    private ChannelCommonService channelCommonService;

    /**
     * order关闭订单
     */
    public PayPlatformBaseResponse closeWxPayOrder(OrderCloseRequest req, PayPlatformBaseRequest baseDto) throws WxPayException {

        PayOrder payOrder = payOrderExtMapper.selectByBusOrderNoForUpdate(req.getBusOrderNo());
        if(payOrder==null){
            throw new PayException(ErrorCode.ORDER_IS_NOT_EXST);
        }
        WxPayOrderCloseRequest wxPayOrderCloseRequest = new WxPayOrderCloseRequest();
        wxPayOrderCloseRequest.setOutTradeNo(payOrder.getTradePayNo());
        WxPayOrderCloseResult wxPayOrderCloseResult = wxPayServiceImpl.closeOrder(wxPayOrderCloseRequest);


        OrderCloseResponse res = new OrderCloseResponse();
        res.setBusPayOrderNo(payOrder.getBusPayNo());
        res.setMsg(wxPayOrderCloseResult.getResultMsg());
        return channelCommonService.createPayPlatformCommonResponse(res, baseDto);
    }

}
