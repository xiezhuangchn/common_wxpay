package com.hnair.pay.agent.weixin.Request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *  关闭订单请求对象类
 */
@XStreamAlias("xml")
public class WxPayOrderCloseRequest extends BaseWxPayRequest {

  /**
   * <pre>
   * 商户订单号
   * out_trade_no
   * 二选一
   * String(32)
   * 20150806125346
   * 商户系统内部的订单号，当没提供transaction_id时需要传这个。
   * </pre>
   */
  @XStreamAlias("out_trade_no")
  private String outTradeNo;

  @Override
  protected void checkConstraints() {

  }

  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }
}
