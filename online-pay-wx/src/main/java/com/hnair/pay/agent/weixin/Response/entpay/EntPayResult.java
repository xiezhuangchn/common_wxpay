package com.hnair.pay.agent.weixin.Response.entpay;

import com.hnair.pay.agent.weixin.Response.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业付款返回结果
 *
 */
@XStreamAlias("xml")
public class EntPayResult extends BaseWxPayResult {

  /**
   * 商户appid
   */
  @XStreamAlias("mch_appid")
  private String mchAppid;

  /**
   * 设备号
   */
  @XStreamAlias("device_info")
  private String deviceInfo;

  //############以下字段在return_code 和result_code都为SUCCESS的时候有返回##############
  /**
   * 商户订单号
   */
  @XStreamAlias("partner_trade_no")
  private String partnerTradeNo;

  /**
   * 微信订单号
   */
  @XStreamAlias("payment_no")
  private String paymentNo;

  /**
   * 微信支付成功时间
   */
  @XStreamAlias("payment_time")
  private String paymentTime;

  public String getMchAppid() {
    return mchAppid;
  }

  public void setMchAppid(String mchAppid) {
    this.mchAppid = mchAppid;
  }

  public String getDeviceInfo() {
    return deviceInfo;
  }

  public void setDeviceInfo(String deviceInfo) {
    this.deviceInfo = deviceInfo;
  }

  public String getPartnerTradeNo() {
    return partnerTradeNo;
  }

  public void setPartnerTradeNo(String partnerTradeNo) {
    this.partnerTradeNo = partnerTradeNo;
  }

  public String getPaymentNo() {
    return paymentNo;
  }

  public void setPaymentNo(String paymentNo) {
    this.paymentNo = paymentNo;
  }

  public String getPaymentTime() {
    return paymentTime;
  }

  public void setPaymentTime(String paymentTime) {
    this.paymentTime = paymentTime;
  }
}
