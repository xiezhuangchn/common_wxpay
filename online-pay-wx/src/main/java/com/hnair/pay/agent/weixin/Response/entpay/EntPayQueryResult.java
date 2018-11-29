package com.hnair.pay.agent.weixin.Response.entpay;

import com.hnair.pay.agent.weixin.Response.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业付款查询返回结果.
 *
 */
@XStreamAlias("xml")
public class EntPayQueryResult extends BaseWxPayResult {
  private static final long serialVersionUID = 3948485732447456947L;

  /**
   * 商户订单号
   */
  @XStreamAlias("partner_trade_no")
  private String partnerTradeNo;

  /**
   * 付款单号
   */
  @XStreamAlias("detail_id")
  private String detailId;

  /**
   * 转账状态
   */
  @XStreamAlias("status")
  private String status;

  /**
   * 失败原因
   */
  @XStreamAlias("reason")
  private String reason;

  /**
   * 收款用户openid
   */
  @XStreamAlias("openid")
  private String openid;

  /**
   * 收款用户姓名
   */
  @XStreamAlias("transfer_name")
  private String transferName;

  /**
   * 付款金额
   */
  @XStreamAlias("payment_amount")
  private Integer paymentAmount;

  /**
   * 转账时间
   */
  @XStreamAlias("transfer_time")
  private String transferTime;

  /**
   * 付款描述
   */
  @XStreamAlias("desc")
  private String desc;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getPartnerTradeNo() {
    return partnerTradeNo;
  }

  public void setPartnerTradeNo(String partnerTradeNo) {
    this.partnerTradeNo = partnerTradeNo;
  }

  public String getDetailId() {
    return detailId;
  }

  public void setDetailId(String detailId) {
    this.detailId = detailId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getTransferName() {
    return transferName;
  }

  public void setTransferName(String transferName) {
    this.transferName = transferName;
  }

  public Integer getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(Integer paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public String getTransferTime() {
    return transferTime;
  }

  public void setTransferTime(String transferTime) {
    this.transferTime = transferTime;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
