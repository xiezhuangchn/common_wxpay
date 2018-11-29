package com.hnair.pay.service.wx;

import com.hnair.pay.service.IWxPayBus;
import com.hnair.pay.common.enums.OrderChannelEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.pay.BasePreCreateOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信支付门面
 */
@Service
public class WxPayBusFacade implements IWxPayBus {

    @Autowired
    private WechartPayFacade wechartPayFacade;

    @Override
    public BasePreCreateOrderResponse preCreateOrder(PayPlatformBaseRequest dto) throws Exception{
        //不同的业务接入
        if (OrderChannelEnum.ORDER_FROM_WECHART.getCode().equals(dto.getBusChannel())) {
            return wechartPayFacade.createWechartWxPayOrder(dto);
        } else {
            throw new PayException(ErrorCode.PAY_CHANNEL_NOT_SUPPORT);
        }
    }
}
