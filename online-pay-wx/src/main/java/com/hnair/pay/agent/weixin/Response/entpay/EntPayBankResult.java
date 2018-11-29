package com.hnair.pay.agent.weixin.Response.entpay;

import com.hnair.pay.agent.weixin.Response.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业付款到银行卡的响应结果.
 *
 */
@XStreamAlias("xml")
public class EntPayBankResult extends BaseWxPayResult {
  private static final long serialVersionUID = 3449707749935227689L;

  /**
   * 代付金额.
   */
  @XStreamAlias("amount")
  private Integer amount;

  /**
   * 商户企业付款单号.
   */
  @XStreamAlias("partner_trade_no")
  private String partnerTradeNo;

  //############以下字段在return_code 和result_code都为SUCCESS的时候有返回##############
  /**
   * 微信企业付款单号.
   * 代付成功后，返回的内部业务单号
   */
  @XStreamAlias("payment_no")
  private String paymentNo;

  /**
   * 手续费金额.
   * RMB：分
   */
  @XStreamAlias("cmms_amt")
  private Integer cmmsAmount;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
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

  public Integer getCmmsAmount() {
    return cmmsAmount;
  }

  public void setCmmsAmount(Integer cmmsAmount) {
    this.cmmsAmount = cmmsAmount;
  }
}
