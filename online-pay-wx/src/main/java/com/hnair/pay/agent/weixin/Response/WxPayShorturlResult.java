package com.hnair.pay.agent.weixin.Response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <pre>
 * 转换短链接结果对象类
 * </pre>
 */
@XStreamAlias("xml")
public class WxPayShorturlResult extends BaseWxPayResult {
  /**
   * <pre>
   * URL链接
   * short_url
   * 是
   * String(64)
   * weixin：//wxpay/s/XXXXXX
   * 转换后的URL
   * </pre>
   */
  @XStreamAlias("short_url")
  private String shortUrl;

  public String getShortUrl() {
    return shortUrl;
  }

  public void setShortUrl(String shortUrl) {
    this.shortUrl = shortUrl;
  }
}
