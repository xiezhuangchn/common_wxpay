package com.hnair.pay.agent.weixin.Response.notify;

import com.hnair.pay.agent.weixin.Response.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <pre>
 * 扫码支付通知回调类.
 * 具体定义，请查看文档：https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=6_4
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@XStreamAlias("xml")
public class WxScanPayNotifyResult extends BaseWxPayResult {
  private static final long serialVersionUID = 3381324564266118986L;

  /**
   * 用户标识.
   */
  @XStreamAlias("openid")
  private String openid;

  /**
   * <pre>
   * 是否关注公众账号.
   * 仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注
   * </pre>
   */
  @XStreamAlias("is_subscribe")
  private String isSubscribe;

  /**
   * <pre>
   * 商品ID.
   * 商户定义的商品id 或者订单号
   * </pre>
   */
  @XStreamAlias("product_id")
  private String productId;

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getIsSubscribe() {
    return isSubscribe;
  }

  public void setIsSubscribe(String isSubscribe) {
    this.isSubscribe = isSubscribe;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }
}
