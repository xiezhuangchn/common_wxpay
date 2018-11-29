package com.hnair.pay.agent.weixin.Response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <pre>
 * 撤销订单响应结果类
 * </pre>
 *
 */
@XStreamAlias("xml")
public class WxPayOrderReverseResult extends BaseWxPayResult {

  /**
   * <pre>
   * 是否重调
   * recall
   * 是
   * String(1)
   * Y
   * 是否需要继续调用撤销，Y-需要，N-不需要
   * </pre>
   **/
  @XStreamAlias("recall")
  private String isRecall;

  public String getIsRecall() {
    return isRecall;
  }

  public void setIsRecall(String isRecall) {
    this.isRecall = isRecall;
  }
}
