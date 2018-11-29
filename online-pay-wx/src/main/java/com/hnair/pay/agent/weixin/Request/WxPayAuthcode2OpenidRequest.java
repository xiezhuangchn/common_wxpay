package com.hnair.pay.agent.weixin.Request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 授权码查询openid接口请求对象类
 */
@XStreamAlias("xml")
public class WxPayAuthcode2OpenidRequest extends BaseWxPayRequest {
  /**
   * <pre>
   *     授权码
   *     auth_code
   *     是
   *     String(128)
   *     扫码支付授权码，设备读取用户微信中的条码或者二维码信息
   * </pre>
   */
  @XStreamAlias("auth_code")
  private String authCode;

  public WxPayAuthcode2OpenidRequest(String authCode) {
    super();
    this.authCode = authCode;
  }

  @Override
  protected void checkConstraints() {
    // nothing to do
  }

  public String getAuthCode() {
    return authCode;
  }

  public void setAuthCode(String authCode) {
    this.authCode = authCode;
  }
}
