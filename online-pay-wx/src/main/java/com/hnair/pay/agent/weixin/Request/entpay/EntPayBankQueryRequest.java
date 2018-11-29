package com.hnair.pay.agent.weixin.Request.entpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业付款到银行卡的请求对象
 *
 */
@XStreamAlias("xml")
public class EntPayBankQueryRequest extends EntPayQueryRequest {
  private static final long serialVersionUID = -479088843124447119L;

  @Override
  protected boolean ignoreAppid() {
    return true;
  }
}
