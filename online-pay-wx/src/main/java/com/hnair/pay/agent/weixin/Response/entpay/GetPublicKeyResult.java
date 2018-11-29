package com.hnair.pay.agent.weixin.Response.entpay;

import com.hnair.pay.agent.weixin.Response.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业付款获取RSA加密公钥接口返回结果类
 */

@XStreamAlias("xml")
public class GetPublicKeyResult extends BaseWxPayResult {
  /**
   * 商户号.
   */
  @XStreamAlias("mch_id")
  private String mchId;

  /**
   * 密钥
   */
  @XStreamAlias("pub_key")
  private String pubKey;

  @Override
  public String getMchId() {
    return mchId;
  }

  @Override
  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public String getPubKey() {
    return pubKey;
  }

  public void setPubKey(String pubKey) {
    this.pubKey = pubKey;
  }
}
