package com.hnair.pay.agent.weixin.Request.order;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <pre>
 * 微信公众号支付进行统一下单后组装所需参数的类
 * </pre>
 */
public class WxPayMpOrderResult {
    private String appId;
    private String subAppId;
    private String timeStamp;
    private String nonceStr;
    /**
     * 由于package为java保留关键字，因此改为packageValue.
     */
    @XStreamAlias("package")
    private String packageValue;
    private String signType;
    private String paySign;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }
}
