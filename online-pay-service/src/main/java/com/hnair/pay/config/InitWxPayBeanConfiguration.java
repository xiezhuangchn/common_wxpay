package com.hnair.pay.config;

import com.hnair.pay.agent.weixin.config.WxBaseConfig;
import com.hnair.pay.agent.weixin.config.WxPayConfig;
import com.hnair.pay.agent.weixin.constant.WxPayConstants;
import com.hnair.pay.agent.weixin.service.IWxHttpClient;
import com.hnair.pay.agent.weixin.service.impl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信普通支付处理bean初始化
 */
@Configuration
public class InitWxPayBeanConfiguration {

    @Value("${WX_APPID}")
    private String appId; //平台公众号appid.

    @Value("${WX_mchId}")
    private String mchId; //平台商户号.

    @Value("${WX_mchKey}")
    private String mchKey; //平台商户密钥.

    @Value("${apiclient.cert.url}")
    private String keyPath;

    @Bean("wxPayConfig")
    public WxPayConfig getWxPayConfig () {
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId(appId);
        wxPayConfig.setMchId(mchId);
        wxPayConfig.setMchKey(mchKey);
        wxPayConfig.setSignType(WxPayConstants.SignType.MD5); //默认MD5
        wxPayConfig.setKeyPath(keyPath);
        return wxPayConfig;
    }

    @Bean("wxPayHttpClientImpl")
    public WxPayHttpClientImpl getWxPayHttpClientImpl (WxPayConfig wxPayConfig) throws Exception{
        return new WxPayHttpClientImpl(wxPayConfig);
    }


    @Bean
    public WxPayServiceImpl getWxPayServiceImpl(WxBaseConfig wxPayConfig, IWxHttpClient wxPayHttpClientImpl){
        return new WxPayServiceImpl(wxPayConfig, wxPayHttpClientImpl);
    }

    @Bean
    public WxSharingImpl getWxSharingImpl(WxBaseConfig wxPayConfig, IWxHttpClient wxPayHttpClientImpl) {
        return new WxSharingImpl(wxPayConfig, wxPayHttpClientImpl);
    }

    @Bean
    public WxParsePayResultImpl getWxParsePayResultImpl(WxBaseConfig wxPayConfig) {
        return new WxParsePayResultImpl(wxPayConfig);
    }



    @Bean
    public WxBillServiceImpl getWxBillServiceImpl(WxBaseConfig wxPayConfig, IWxHttpClient wxPayHttpClientImpl) {
        return new WxBillServiceImpl(wxPayConfig, wxPayHttpClientImpl);
    }

}
