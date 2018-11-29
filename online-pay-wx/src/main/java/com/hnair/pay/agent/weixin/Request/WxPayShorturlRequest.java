package com.hnair.pay.agent.weixin.Request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <pre>
 * 转换短链接请求对象类
 * </pre>
 */
@XStreamAlias("xml")
public class WxPayShorturlRequest extends BaseWxPayRequest {
  /**
   * <pre>
   * URL链接
   * long_url
   * 是
   * String(512)
   * weixin：//wxpay/bizpayurl?sign=XXXXX&appid=XXXXX&mch_id=XXXXX&product_id=XXXXXX&time_stamp=XXXXXX&nonce_str=XXXXX
   * 需要转换的URL，签名用原串，传输需URLencode
   * </pre>
   */
  @XStreamAlias("long_url")
  private String longUrl;

    public WxPayShorturlRequest(String longUrl) {
        super();
        this.longUrl = longUrl;
    }

    @Override
  protected void checkConstraints() {
    //do nothing
  }

  public String getLongUrl() {
    return longUrl;
  }

  public void setLongUrl(String longUrl) {
    this.longUrl = longUrl;
  }
}
