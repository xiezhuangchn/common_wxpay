package com.hnair.pay.agent.weixin.Request.order;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <pre>
 * 微信H5支付统一下单后发起支付拼接所需参数实现类.
 * </pre>
 *
 */
public class WxPayMwebOrderResult {

  @XStreamAlias("mwebUrl")
  private String mwebUrl;

    public WxPayMwebOrderResult(String mwebUrl) {
      this.mwebUrl = mwebUrl;
    }

    public String getMwebUrl() {
    return mwebUrl;
  }

  public void setMwebUrl(String mwebUrl) {
    this.mwebUrl = mwebUrl;
  }
}
