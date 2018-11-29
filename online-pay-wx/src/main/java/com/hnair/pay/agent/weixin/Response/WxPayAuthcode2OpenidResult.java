package com.hnair.pay.agent.weixin.Response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <pre>
 *  授权码查询openid接口请求结果类
 * </pre>
 *
 */
@XStreamAlias("xml")
public class WxPayAuthcode2OpenidResult extends BaseWxPayResult {
  /**
   * <pre>
   *   用户标识.
   *   openid
   *   是
   *   String(128)
   *   用户在商户appid下的唯一标识
   * </pre>
   */
  @XStreamAlias("openid")
  private String openid;

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }
}
