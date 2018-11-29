package com.hnair.pay.service;

import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.response.pay.BasePreCreateOrderResponse;

/**
 * 所有支付渠道都拥有的功能解耦
 */
public interface IPayChannel {

    /**
     * 预下单
     * @param request
     * @return
     * @throws Exception
     */
    public BasePreCreateOrderResponse preCreateOrder(PayPlatformBaseRequest request) throws Exception;



}
