package com.hnair.pay.agent.weixin.Response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 下午2:52 2018/7/29
 */

@XStreamAlias("xml")
public class WxSharingAccountStatusResponse extends BaseWxPayResult {


  /**
   * 微信订单号 微信支付订单号
   */
  @XStreamAlias("transaction_id")
  private String transactionId;

  /**
   * 商户分账单号 调用接口提供的商户系统内部的分账单号
   */
  @XStreamAlias("out_order_no")
  private String outOrderNo;

  /**
   * 微信分账单号 微信分账单号，微信系统返回的唯一标识
   */
  @XStreamAlias("order_id")
  private String orderId;


  /**
   * 微信分账单号 微信分账单号，微信系统返回的唯一标识 分账单状态: ACCEPTED—受理成功 PROCESSING—处理中 FINISHED—处理完成 CLOSED—处理失败，已关单
   */
  @XStreamAlias("status")
  private String status;


  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getOutOrderNo() {
    return outOrderNo;
  }

  public void setOutOrderNo(String outOrderNo) {
    this.outOrderNo = outOrderNo;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
