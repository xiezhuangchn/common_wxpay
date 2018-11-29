package com.hnair.pay.agent.weixin.config;

import javax.net.ssl.SSLContext;

/**
 * 微信基本配置
 */
public abstract class WxBaseConfig {

    public String payBaseUrl = "https://api.mch.weixin.qq.com"; //微信默认请求地址

    private String appId; //公众号appid.

    private String mchId; //商户号.

    private String mchKey; //商户密钥.

    private String subAppId; //服务商模式下的子商户公众账号ID.

    private String subMchId; //服务商模式下的子商户号.

    private String notifyUrl; //微信支付异步回掉地址，通知url必须为直接可访问的url，不能携带参数.

    private String tradeType; //交易类型:JSAPI--公众号支付  NATIVE--原生扫码支付 APP--app支付

    private String signType; //签名方式. 有两种HMAC_SHA256 和MD5

    private SSLContext sslContext;

    private String keyPath; //p12证书文件的绝对路径或者以classpath:开头的类路径.

    /**
     * 微信支付是否使用仿真测试环境. 默认不使用
     */
    private String httpProxyHost;
    private boolean useSandboxEnv = false; //微信支付是否使用仿真测试环境. 默认不使用
    private Integer httpProxyPort;
    private String httpProxyUsername;
    private String httpProxyPassword;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public SSLContext getSslContext() {
        return sslContext;
    }

    public void setSslContext(SSLContext sslContext) {
        this.sslContext = sslContext;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    public boolean isUseSandboxEnv() {
        return useSandboxEnv;
    }

    public void setUseSandboxEnv(boolean useSandboxEnv) {
        this.useSandboxEnv = useSandboxEnv;
    }

    public String getPayBaseUrl() {
        return payBaseUrl;
    }

    public void setPayBaseUrl(String payBaseUrl) {
        this.payBaseUrl = payBaseUrl;
    }

    public String getHttpProxyHost() {
        return httpProxyHost;
    }

    public void setHttpProxyHost(String httpProxyHost) {
        this.httpProxyHost = httpProxyHost;
    }

    public Integer getHttpProxyPort() {
        return httpProxyPort;
    }

    public void setHttpProxyPort(Integer httpProxyPort) {
        this.httpProxyPort = httpProxyPort;
    }

    public String getHttpProxyUsername() {
        return httpProxyUsername;
    }

    public void setHttpProxyUsername(String httpProxyUsername) {
        this.httpProxyUsername = httpProxyUsername;
    }

    public String getHttpProxyPassword() {
        return httpProxyPassword;
    }

    public void setHttpProxyPassword(String httpProxyPassword) {
        this.httpProxyPassword = httpProxyPassword;
    }
}
