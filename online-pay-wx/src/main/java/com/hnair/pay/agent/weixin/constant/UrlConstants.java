package com.hnair.pay.agent.weixin.constant;

/**
 * 微信支付相关接口 https://pay.weixin.qq.com/wiki/doc/api/H5_sl.php?chapter=9_2&index=2
 */
public class UrlConstants {

  public static final String PAY_BASE_URL = "https://api.mch.weixin.qq.com";

  //查询微信企业付款-银行
  public static final String WX_QUERY_ENT_PAY_BANK = "/mmpaysptrans/query_bank";

  //微信企业付款-银行
  public static final String WX_ENT_PAY_BANK = "/mmpaysptrans/pay_bank";

  //微信企业付款-零钱
  public static final String WX_ENT_PAY = "/mmpaymkttransfers/promotion/transfers";

  //查询微信企业付款-零钱
  public static final String WX_QUERY_ENT_PAY = "/mmpaymkttransfers/gettransferinfo";

  //微信分账
  public static final String WX_SHARING = "/secapi/pay/profitsharing";

  //查询微信分账状态
  public static final String WX_QUERY_SHARING = "/pay/profitsharingquery";

  //綁定分账关系
  public static final String WX_PROFITSHARINGADDRECEIVER  = "/pay/profitsharingaddreceiver";

  //H5支付是指商户在微信客户端外的移动端网页展示商品或服务，用户在前述页面确认使用微信支付时，
  // 商户发起本服务呼起微信客户端进行支付。 主要用于触屏版的手机浏览器请求微信支付的场景。
  // 可以方便的从外部浏览器唤起微信支付。
  public static final String WX_UNIFIEDORDER = "/pay/unifiedorder";

  //    该接口提供所有微信支付订单的查询，商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑。
//    需要调用查询接口的情况：
//            ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
//            ◆ 调用支付接口后，返回系统错误或未知交易状态情况；
//            ◆ 调用被扫支付API，返回USERPAYING的状态；
//            ◆ 调用关单或撤销接口API之前，需确认支付状态；
  public static final String WX_ORDERQUERY = "/pay/orderquery";

  //    以下情况需要调用关单接口：
//    商户订单支付失败需要生成新单号重新发起支付，
//    要对原订单号调用关单，避免重复支付；
//    系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
  public static final String WX_CLOSEORDER = "/pay/closeorder";

  //申请退款
  public static final String WX_REFUND = "/secapi/pay/refund";

  //查询退款
  public static final String WX_REFUNDQUERY = "/pay/refundquery";

  //下载对账单
  public static final String WX_DOWNLOADBILL = "/pay/downloadbill";

  //交易保障
  public static final String WX_REPORT = "/payitil/report";


}
