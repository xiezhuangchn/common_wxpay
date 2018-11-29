package com.hnair.pay.agent.weixin.Response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * <pre>
 * 微信支付-申请退款返回结果.
 * </pre>
 *
 */
@XStreamAlias("xml")
public class WxPayRefundResult extends BaseWxPayResult implements Serializable {
  private static final long serialVersionUID = -3392333879907788033L;
  /**
   * 微信订单号.
   */
  @XStreamAlias("transaction_id")
  private String transactionId;

  /**
   * 商户订单号.
   */
  @XStreamAlias("out_trade_no")
  private String outTradeNo;

  /**
   * 商户退款单号.
   */
  @XStreamAlias("out_refund_no")
  private String outRefundNo;

  /**
   * 微信退款单号.
   */
  @XStreamAlias("refund_id")
  private String refundId;

  /**
   * 退款金额.
   */
  @XStreamAlias("refund_fee")
  private Integer refundFee;

  /**
   * 应结退款金额.
   */
  @XStreamAlias("settlement_refund_fee")
  private Integer settlementRefundFee;

  /**
   * 标价金额.
   */
  @XStreamAlias("total_fee")
  private Integer totalFee;

  /**
   * 应结订单金额.
   */
  @XStreamAlias("settlement_total_fee")
  private Integer settlementTotalFee;

  /**
   * 标价币种.
   */
  @XStreamAlias("fee_type")
  private String feeType;

  /**
   * 现金支付金额.
   */
  @XStreamAlias("cash_fee")
  private Integer cashFee;

  /**
   * 现金支付币种.
   */
  @XStreamAlias("cash_fee_type")
  private String cashFeeType;

  /**
   * 现金退款金额.
   */
  @XStreamAlias("cash_refund_fee")
  private String cashRefundFee;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  public String getOutRefundNo() {
    return outRefundNo;
  }

  public void setOutRefundNo(String outRefundNo) {
    this.outRefundNo = outRefundNo;
  }

  public String getRefundId() {
    return refundId;
  }

  public void setRefundId(String refundId) {
    this.refundId = refundId;
  }

  public Integer getRefundFee() {
    return refundFee;
  }

  public void setRefundFee(Integer refundFee) {
    this.refundFee = refundFee;
  }

  public Integer getSettlementRefundFee() {
    return settlementRefundFee;
  }

  public void setSettlementRefundFee(Integer settlementRefundFee) {
    this.settlementRefundFee = settlementRefundFee;
  }

  public Integer getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(Integer totalFee) {
    this.totalFee = totalFee;
  }

  public Integer getSettlementTotalFee() {
    return settlementTotalFee;
  }

  public void setSettlementTotalFee(Integer settlementTotalFee) {
    this.settlementTotalFee = settlementTotalFee;
  }

  public String getFeeType() {
    return feeType;
  }

  public void setFeeType(String feeType) {
    this.feeType = feeType;
  }

  public Integer getCashFee() {
    return cashFee;
  }

  public void setCashFee(Integer cashFee) {
    this.cashFee = cashFee;
  }

  public String getCashFeeType() {
    return cashFeeType;
  }

  public void setCashFeeType(String cashFeeType) {
    this.cashFeeType = cashFeeType;
  }

  public String getCashRefundFee() {
    return cashRefundFee;
  }

  public void setCashRefundFee(String cashRefundFee) {
    this.cashRefundFee = cashRefundFee;
  }

}
