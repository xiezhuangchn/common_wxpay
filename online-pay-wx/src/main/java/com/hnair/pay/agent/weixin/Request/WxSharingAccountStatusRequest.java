package com.hnair.pay.agent.weixin.Request;

import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 下午2:47 2018/7/29
 */

//分账查询请求信息
@XStreamAlias("xml")
public class WxSharingAccountStatusRequest extends BaseWxPayRequest {

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


  /**
   * 不需要传递appid
   * @return
   */
  @Override
  protected boolean ignoreAppid() {
    return true;
  }
}
