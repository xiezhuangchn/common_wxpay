package com.hnair.pay.agent.weixin.service.impl;

import com.hnair.pay.agent.weixin.config.WxBaseConfig;

/**
 * 企业付款
 */
public class WxEnPayHttpClientImpl extends WxHttpClientAbstract{

    public WxEnPayHttpClientImpl(WxBaseConfig wxBaseConfig) throws Exception{
        super(wxBaseConfig);
    }

}
