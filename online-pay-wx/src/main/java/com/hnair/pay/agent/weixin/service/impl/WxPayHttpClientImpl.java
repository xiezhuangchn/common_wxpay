package com.hnair.pay.agent.weixin.service.impl;

import com.hnair.pay.agent.weixin.config.WxBaseConfig;

/**
 * 普通支付相关
 */
public class WxPayHttpClientImpl extends WxHttpClientAbstract{

    public WxPayHttpClientImpl(WxBaseConfig wxBaseConfig) throws Exception{
        super(wxBaseConfig);
    }


}
