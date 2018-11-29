package com.hnair.pay.agent.weixin.Request.entpay;

import com.hnair.pay.agent.weixin.Request.BaseWxPayRequest;
import com.hnair.pay.agent.weixin.utils.ToStringUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业付款请求对象.
 *
 */
public class EntPayQueryRequest extends BaseWxPayRequest {
  private static final long serialVersionUID = 1972288742207813985L;

  /**
   * <pre>
   * 字段名：商户订单号.
   * 变量名：partner_trade_no
   * 是否必填：是
   * 示例值：10000098201411111234567890
   * 类型：String
   * 描述商户订单号
   * </pre>
   */
  @XStreamAlias("partner_trade_no")
  private String partnerTradeNo;

  @Override
  protected void checkConstraints() {
    //do nothing
  }

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }

  @Override
  protected boolean ignoreSignType() {
    return true;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getPartnerTradeNo() {
    return partnerTradeNo;
  }

  public void setPartnerTradeNo(String partnerTradeNo) {
    this.partnerTradeNo = partnerTradeNo;
  }
}
