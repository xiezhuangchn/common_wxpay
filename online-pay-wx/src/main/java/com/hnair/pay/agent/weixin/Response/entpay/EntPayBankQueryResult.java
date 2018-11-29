package com.hnair.pay.agent.weixin.Response.entpay;

import com.hnair.pay.agent.weixin.Response.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业付款到银行卡查询返回结果.
 *
 */
@XStreamAlias("xml")
public class EntPayBankQueryResult extends BaseWxPayResult {
  private static final long serialVersionUID = -8336631015989500746L;

  /**
   * 商户企业付款单号
   */
  @XStreamAlias("partner_trade_no")
  private String partnerTradeNo;

  /**
   * 微信企业付款单号.
   * 即为微信内部业务单号
   */
  @XStreamAlias("payment_no")
  private String paymentNo;

  /**
   * 银行卡号.
   * 收款用户银行卡号(MD5加密)
   */
  @XStreamAlias("bank_no_md5")
  private String bankNoMd5;

  /**
   * 用户真实姓名.
   * 收款人真实姓名（MD5加密）
   */
  @XStreamAlias("true_name_md5")
  private String trueNameMd5;

  /**
   * 付款金额.
   */
  @XStreamAlias("amount")
  private Integer amount;

  /**
   * 代付单状态.
   * <pre>
   * PROCESSING（处理中，如有明确失败，则返回额外失败原因；否则没有错误原因）
   * SUCCESS（付款成功）
   * FAILED（付款失败）
   * BANK_FAIL（银行退票，订单状态由付款成功流转至退票,退票时付款金额和手续费会自动退还）
   * </pre>
   */
  @XStreamAlias("status")
  private String status;

  /**
   * 手续费金额
   */
  @XStreamAlias("cmms_amt")
  private Integer cmmsAmount;

  /**
   * 商户下单时间.
   * 微信侧订单创建时间
   */
  @XStreamAlias("create_time")
  private String createTime;

  /**
   * 成功付款时间.
   * 微信侧付款成功时间（但无法保证银行不会退票）
   */
  @XStreamAlias("pay_succ_time")
  private String paySuccessTime;

  /**
   * 失败原因.
   * 订单失败原因（如：余额不足）
   */
  @XStreamAlias("reason")
  private String failReason;

  public static long getSerialVersionUID() {
    return serialVersionUID;
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

  public String getBankNoMd5() {
    return bankNoMd5;
  }

  public void setBankNoMd5(String bankNoMd5) {
    this.bankNoMd5 = bankNoMd5;
  }

  public String getTrueNameMd5() {
    return trueNameMd5;
  }

  public void setTrueNameMd5(String trueNameMd5) {
    this.trueNameMd5 = trueNameMd5;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getCmmsAmount() {
    return cmmsAmount;
  }

  public void setCmmsAmount(Integer cmmsAmount) {
    this.cmmsAmount = cmmsAmount;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getPaySuccessTime() {
    return paySuccessTime;
  }

  public void setPaySuccessTime(String paySuccessTime) {
    this.paySuccessTime = paySuccessTime;
  }

  public String getFailReason() {
    return failReason;
  }

  public void setFailReason(String failReason) {
    this.failReason = failReason;
  }
}
