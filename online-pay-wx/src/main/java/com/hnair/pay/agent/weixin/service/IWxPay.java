package com.hnair.pay.agent.weixin.service;

import com.hnair.pay.agent.weixin.Request.*;
import com.hnair.pay.agent.weixin.Response.*;
import com.hnair.pay.agent.weixin.exception.WxPayException;

/**
 * 微信支付相关接口.
 */
public interface IWxPay {

  /**
   * <pre>
   * 查询订单（适合于需要自定义子商户号和子商户appid的情形）.
   * 详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_2
   * 该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
   * 需要调用查询接口的情况：
   * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
   * ◆ 调用支付接口后，返回系统错误或未知交易状态情况；
   * ◆ 调用被扫支付API，返回USERPAYING的状态；
   * ◆ 调用关单或撤销接口API之前，需确认支付状态；
   * 接口地址：https://api.mch.weixin.qq.com/pay/orderquery
   * </pre>
   *
   * @param request 查询订单请求对象
   */
  WxPayOrderQueryResult queryOrder(WxPayOrderQueryRequest request) throws WxPayException;

  /**
   * <pre>
   * 关闭订单（适合于需要自定义子商户号和子商户appid的情形）.
   * 应用场景
   * 以下情况需要调用关单接口：
   * 1. 商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；
   * 2. 系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
   * 注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
   * 接口地址：https://api.mch.weixin.qq.com/pay/closeorder
   * 是否需要证书：   不需要。
   * </pre>
   *
   * @param request 关闭订单请求对象
   */
  WxPayOrderCloseResult closeOrder(WxPayOrderCloseRequest request) throws WxPayException;

  /**
   * 调用统一下单接口，并组装生成支付所需参数对象.
   *
   * @param request 统一下单请求参数
   */
  <T> T createOrder(WxPayUnifiedOrderRequest request) throws WxPayException;

  /**
   * 统一下单(详见https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_1)
   * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识" 接口地址：https://api.mch.weixin.qq.com/pay/unifiedorder
   *
   * @param request 请求对象，注意一些参数如appid、mchid等不用设置，方法内会自动从配置对象中获取到（前提是对应配置中已经设置）
   */
  WxPayUnifiedOrderResult unifiedOrder(WxPayUnifiedOrderRequest request) throws WxPayException;

  /**
   * <pre>
   * 微信支付-申请退款.
   * 详见 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_4
   * 接口链接：https://api.mch.weixin.qq.com/secapi/pay/refund
   * </pre>
   *
   * @param request 请求对象
   * @return 退款操作结果
   */
  WxPayRefundResult refund(WxPayRefundRequest request) throws WxPayException;

  /**
   * <pre>
   * 微信支付-查询退款.
   * 应用场景：
   *  提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，
   *  银行卡支付的退款3个工作日后重新查询退款状态。
   * 详见 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_5
   * 接口链接：https://api.mch.weixin.qq.com/pay/refundquery
   * </pre>
   * 以下四个参数四选一
   *
   * @param transactionId 微信订单号
   * @param outTradeNo 商户订单号
   * @param outRefundNo 商户退款单号
   * @param refundId 微信退款单号
   * @return 退款信息
   */
  WxPayRefundQueryResult refundQuery(String transactionId, String outTradeNo, String outRefundNo,
      String refundId)
      throws WxPayException;

  /**
   * <pre>
   * 微信支付-查询退款（适合于需要自定义子商户号和子商户appid的情形）.
   * 应用场景：
   *  提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，
   *  银行卡支付的退款3个工作日后重新查询退款状态。
   * 详见 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_5
   * 接口链接：https://api.mch.weixin.qq.com/pay/refundquery
   * </pre>
   *
   * @param request 微信退款单号
   * @return 退款信息
   */
  WxPayRefundQueryResult refundQuery(WxPayRefundQueryRequest request) throws WxPayException;

}
