package com.hnair.pay.agent.weixin.Response.notify;

import com.hnair.pay.agent.weixin.Response.BaseWxPayResult;
import com.hnair.pay.agent.weixin.utils.ToStringUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * 支付结果通用通知 ，文档见：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_7
 */
@XStreamAlias("xml")
public class WxPayOrderNotifyResult extends BaseWxPayResult {
  private static final long serialVersionUID = 5389718115223345496L;
  /**
   * <pre>
   * 字段名：营销详情.
   * 变量名：promotion_detail
   * 是否必填：否，单品优惠才有
   * 类型：String(6000)
   * 示例值：[{"promotion_detail":[{"promotion_id":"109519","name":"单品惠-6","scope":"SINGLE","type":"DISCOUNT","amount":5,"activity_id":"931386","wxpay_contribute":0,"merchant_contribute":0,"other_contribute":5,"goods_detail":[{"goods_id":"a_goods1","goods_remark":"商品备注","quantity":7,"price":1,"discount_amount":4},{"goods_id":"a_goods2","goods_remark":"商品备注","quantity":1,"price":2,"discount_amount":1}]}]}
   * 描述：单品优惠专用参数，详见https://pay.weixin.qq.com/wiki/doc/api/danpin.php?chapter=9_203&index=4
   * </pre>
   */
  @XStreamAlias("promotion_detail")
  private String promotionDetail;

  /**
   * <pre>
   * 字段名：设备号.
   * 变量名：device_info
   * 是否必填：否
   * 类型：String(32)
   * 示例值：013467007045764
   * 描述：微信支付分配的终端设备号，
   * </pre>
   */
  @XStreamAlias("device_info")
  private String deviceInfo;

  /**
   * <pre>
   * 字段名：用户标识.
   * 变量名：openid
   * 是否必填：是
   * 类型：String(128)
   * 示例值：wxd930ea5d5a258f4f
   * 描述：用户在商户appid下的唯一标识
   * </pre>
   */
  @XStreamAlias("openid")
  private String openid;

  /**
   * <pre>
   * 字段名：是否关注公众账号.
   * 变量名：is_subscribe
   * 是否必填：否
   * 类型：String(1)
   * 示例值：Y
   * 描述：用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
   * </pre>
   */
  @XStreamAlias("is_subscribe")
  private String isSubscribe;

  /**
   * <pre>
   * 字段名：用户子标识.
   * 变量名：sub_openid
   * 是否必填：是
   * 类型：String(128)
   * 示例值：wxd930ea5d5a258f4f
   * 描述：用户在子商户appid下的唯一标识
   * </pre>
   */
  @XStreamAlias("sub_openid")
  private String subOpenid;

  /**
   * <pre>
   * 字段名：是否关注子公众账号.
   * 变量名：sub_is_subscribe
   * 是否必填：否
   * 类型：String(1)
   * 示例值：Y
   * 描述：用户是否关注子公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
   * </pre>
   */
  @XStreamAlias("sub_is_subscribe")
  private String subIsSubscribe;


  /**
   * <pre>
   * 字段名：交易类型.
   * 变量名：trade_type
   * 是否必填：是
   * 类型：String(16)
   * 示例值：JSAPI
   * JSA描述：PI、NATIVE、APP
   * </pre>
   */
  @XStreamAlias("trade_type")
  private String tradeType;

  /**
   * <pre>
   * 字段名：付款银行.
   * 变量名：bank_type
   * 是否必填：是
   * 类型：String(16)
   * 示例值：CMC
   * 描述：银行类型，采用字符串类型的银行标识，银行类型见银行列表
   * </pre>
   */
  @XStreamAlias("bank_type")
  private String bankType;

  /**
   * <pre>
   * 字段名：订单金额.
   * 变量名：total_fee
   * 是否必填：是
   * 类型：Int
   * 示例值：100
   * 描述：订单总金额，单位为分
   * </pre>
   */
  @XStreamAlias("total_fee")
  private Integer totalFee;
  /**
   * <pre>
   * 字段名：应结订单金额.
   * 变量名：settlement_total_fee
   * 是否必填：否
   * 类型：Int
   * 示例值：100
   * 描述：应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
   * </pre>
   */
  @XStreamAlias("settlement_total_fee")
  private Integer settlementTotalFee;
  /**
   * <pre>
   * 字段名：货币种类.
   * 变量名：fee_type
   * 是否必填：否
   * 类型：String(8)
   * 示例值：CNY
   * 描述：货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
   * </pre>
   */
  @XStreamAlias("fee_type")
  private String feeType;
  /**
   * <pre>
   * 字段名：现金支付金额.
   * 变量名：cash_fee
   * 是否必填：是
   * 类型：Int
   * 示例值：100
   * 描述：现金支付金额订单现金支付金额，详见支付金额
   * </pre>
   */
  @XStreamAlias("cash_fee")
  private Integer cashFee;
  /**
   * <pre>
   * 字段名：现金支付货币类型.
   * 变量名：cash_fee_type
   * 是否必填：否
   * 类型：String(16)
   * 示例值：CNY
   * 描述：货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
   * </pre>
   */
  @XStreamAlias("cash_fee_type")
  private String cashFeeType;
  /**
   * <pre>
   * 字段名：总代金券金额.
   * 变量名：coupon_fee
   * 是否必填：否
   * 类型：Int
   * 示例值：10
   * 描述：代金券金额<=订单金额，订单金额-代金券金额=现金支付金额，详见支付金额
   * </pre>
   */
  @XStreamAlias("coupon_fee")
  private Integer couponFee;

  /**
   * <pre>
   * 字段名：代金券使用数量.
   * 变量名：coupon_count
   * 是否必填：否
   * 类型：Int
   * 示例值：1
   * 描述：代金券使用数量
   * </pre>
   */
  @XStreamAlias("coupon_count")
  private Integer couponCount;

  private List<WxPayOrderNotifyCoupon> couponList;

  /**
   * <pre>
   * 字段名：微信支付订单号.
   * 变量名：transaction_id
   * 是否必填：是
   * 类型：String(32)
   * 示例值：1217752501201407033233368018
   * 描述：微信支付订单号
   * </pre>
   */
  @XStreamAlias("transaction_id")
  private String transactionId;

  /**
   * <pre>
   * 字段名：商户订单号.
   * 变量名：out_trade_no
   * 是否必填：是
   * 类型：String(32)
   * 示例值：1212321211201407033568112322
   * 描述：商户系统的订单号，与请求一致。
   * </pre>
   */
  @XStreamAlias("out_trade_no")
  private String outTradeNo;
  /**
   * <pre>
   * 字段名：商家数据包.
   * 变量名：attach
   * 是否必填：否
   * 类型：String(128)
   * 示例值：123456
   * 描述：商家数据包，原样返回
   * </pre>
   */
  @XStreamAlias("attach")
  private String attach;

  /**
   * <pre>
   * 字段名：支付完成时间.
   * 变量名：time_end
   * 是否必填：是
   * 类型：String(14)
   * 示例值：20141030133525
   * 描述：支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
   * </pre>
   */
  @XStreamAlias("time_end")
  private String timeEnd;

  /**
   * <pre>
   * 字段名：接口版本号.
   * 变量名：version
   * 类型：String(32)
   * 示例值：1.0
   * 更多信息，详见文档：https://pay.weixin.qq.com/wiki/doc/api/danpin.php?chapter=9_101&index=1
   * </pre>
   */
  @XStreamAlias("version")
  private String version;


  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getPromotionDetail() {
    return promotionDetail;
  }

  public void setPromotionDetail(String promotionDetail) {
    this.promotionDetail = promotionDetail;
  }

  public String getDeviceInfo() {
    return deviceInfo;
  }

  public void setDeviceInfo(String deviceInfo) {
    this.deviceInfo = deviceInfo;
  }

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

  public String getSubOpenid() {
    return subOpenid;
  }

  public void setSubOpenid(String subOpenid) {
    this.subOpenid = subOpenid;
  }

  public String getSubIsSubscribe() {
    return subIsSubscribe;
  }

  public void setSubIsSubscribe(String subIsSubscribe) {
    this.subIsSubscribe = subIsSubscribe;
  }

  public String getTradeType() {
    return tradeType;
  }

  public void setTradeType(String tradeType) {
    this.tradeType = tradeType;
  }

  public String getBankType() {
    return bankType;
  }

  public void setBankType(String bankType) {
    this.bankType = bankType;
  }

  public Integer getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(Integer totalFee) {
    this.totalFee = totalFee;
  }

  public Integer getSettlementTotalFee() {
    return settlementTotalFee;
  }

  public void setSettlementTotalFee(Integer settlementTotalFee) {
    this.settlementTotalFee = settlementTotalFee;
  }

  public String getFeeType() {
    return feeType;
  }

  public void setFeeType(String feeType) {
    this.feeType = feeType;
  }

  public Integer getCashFee() {
    return cashFee;
  }

  public void setCashFee(Integer cashFee) {
    this.cashFee = cashFee;
  }

  public String getCashFeeType() {
    return cashFeeType;
  }

  public void setCashFeeType(String cashFeeType) {
    this.cashFeeType = cashFeeType;
  }

  public Integer getCouponFee() {
    return couponFee;
  }

  public void setCouponFee(Integer couponFee) {
    this.couponFee = couponFee;
  }

  public Integer getCouponCount() {
    return couponCount;
  }

  public void setCouponCount(Integer couponCount) {
    this.couponCount = couponCount;
  }

  public List<WxPayOrderNotifyCoupon> getCouponList() {
    return couponList;
  }

  public void setCouponList(List<WxPayOrderNotifyCoupon> couponList) {
    this.couponList = couponList;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  public String getAttach() {
    return attach;
  }

  public void setAttach(String attach) {
    this.attach = attach;
  }

  public String getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(String timeEnd) {
    this.timeEnd = timeEnd;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }
}
