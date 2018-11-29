package com.hnair.pay.agent.weixin.Request;

import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 分账请求
 */

//向微信请求分账的参数
@XStreamAlias("xml")
public class WxSharingRequest extends BaseWxPayRequest {

  @Override
  protected void checkConstraints() throws WxPayException {
  }

  /**
   * "微信订单号"
   */
  @XStreamAlias("transaction_id")
  private String transactionId;


  /**
   * "商户分账单号" 商户系统内部的分账单号，商户系统内部唯 一，只能是数字、大小写字母_-|*@ ，同一 分账单号多次请求等同一次。
   */
  @XStreamAlias("out_order_no")
  private String outOrderNo;

  /**
   * 分账接收方列表 分账接收方列表 不超过 50 个 json 对象
   */
  @XStreamAlias("receivers")
  private String receivers;

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

  public String getReceivers() {
    return receivers;
  }

  public void setReceivers(String receivers) {
    this.receivers = receivers;
  }


}
