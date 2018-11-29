package com.hnair.pay.agent.weixin.Response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <pre>
 * </pre>
 *
 */
@XStreamAlias("xml")
public class WxPaySandboxSignKeyResult extends BaseWxPayResult {

  /**
   * <pre>
   * 沙箱密钥
   * sandbox_signkey
   * 否
   * 013467007045764
   * String(32)
   * 返回的沙箱密钥
   * </pre>
   */
  @XStreamAlias("sandbox_signkey")
  private String sandboxSignKey;

  public String getSandboxSignKey() {
    return sandboxSignKey;
  }

  public void setSandboxSignKey(String sandboxSignKey) {
    this.sandboxSignKey = sandboxSignKey;
  }
}
