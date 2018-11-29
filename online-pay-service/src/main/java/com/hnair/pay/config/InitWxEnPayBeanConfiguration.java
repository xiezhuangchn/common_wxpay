package com.hnair.pay.config;

import com.hnair.pay.agent.weixin.config.WxBaseConfig;
import com.hnair.pay.agent.weixin.config.WxEnPayConfig;
import com.hnair.pay.agent.weixin.constant.WxPayConstants;
import com.hnair.pay.agent.weixin.service.IWxHttpClient;
import com.hnair.pay.agent.weixin.service.impl.EntPayServiceImpl;
import com.hnair.pay.agent.weixin.service.impl.WxEnPayHttpClientImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 企业支付微信处理bean初始化
 */
@Configuration
public class InitWxEnPayBeanConfiguration {

    @Value("${wx.ent.pay.app.id}")
    private String appId; //平台公众号appid.

    @Value("${wx.ent.pay.mch.id}")
    private String mchId; //平台商户号.

    @Value("${wx.ent.pay.mch.key}")
    private String mchKey; //平台商户密钥.

    @Value("${apiclient.cert.ent.pay.url}")
    private String keyPath;

    @Bean("wxEnPayConfig")
    public WxEnPayConfig getWxEnPayConfig () {
        WxEnPayConfig wxEnPayConfig = new WxEnPayConfig();
        wxEnPayConfig.setAppId(appId);
        wxEnPayConfig.setMchId(mchId);
        wxEnPayConfig.setMchKey(mchKey);
        wxEnPayConfig.setKeyPath(keyPath);
        wxEnPayConfig.setSignType(WxPayConstants.SignType.MD5);
        return wxEnPayConfig;
    }


    @Bean("wxEnPayHttpClientImpl")
    public WxEnPayHttpClientImpl getWxWxEnPayHttpClientImpl (WxEnPayConfig wxEnPayConfig) throws Exception{
        return new WxEnPayHttpClientImpl(wxEnPayConfig);
    }


    @Bean
    public EntPayServiceImpl getEntPayServiceImpl(WxBaseConfig wxEnPayConfig, IWxHttpClient wxEnPayHttpClientImpl) {
        return new EntPayServiceImpl(wxEnPayConfig, wxEnPayHttpClientImpl);
    }


}
