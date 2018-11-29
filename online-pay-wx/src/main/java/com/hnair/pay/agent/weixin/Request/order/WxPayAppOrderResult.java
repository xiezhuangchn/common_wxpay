package com.hnair.pay.agent.weixin.Request.order;

/**
 * <pre>
 * APP支付调用统一下单接口后的组装所需参数的实现类
 * </pre>
 *
 */
public class WxPayAppOrderResult {
  private String sign;
  private String prepayId;
  private String partnerId;
  private String appId;
  private String packageValue;
  private String timeStamp;
  private String nonceStr;

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getPrepayId() {
    return prepayId;
  }

  public void setPrepayId(String prepayId) {
    this.prepayId = prepayId;
  }

  public String getPartnerId() {
    return partnerId;
  }

  public void setPartnerId(String partnerId) {
    this.partnerId = partnerId;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getPackageValue() {
    return packageValue;
  }

  public void setPackageValue(String packageValue) {
    this.packageValue = packageValue;
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
}
