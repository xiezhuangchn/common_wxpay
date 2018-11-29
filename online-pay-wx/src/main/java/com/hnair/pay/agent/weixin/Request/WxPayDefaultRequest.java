package com.hnair.pay.agent.weixin.Request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *  支付请求默认对象类
 */
@XStreamAlias("xml")
public class WxPayDefaultRequest extends BaseWxPayRequest {
  @Override
  protected void checkConstraints() {
    //do nothing
  }
}
