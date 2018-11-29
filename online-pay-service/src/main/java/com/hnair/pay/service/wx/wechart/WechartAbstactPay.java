package com.hnair.pay.service.wx.wechart;

import org.springframework.beans.factory.annotation.Value;

/**
 * 微官网支付基类
 */
public abstract class WechartAbstactPay {

    @Value("${wx.pay.notify.url}")
    String payNotifyUrl;

    @Value("${WX_APPID}")
    String appid;

    @Value("${WX_mchId}")
    String mchid;



}
