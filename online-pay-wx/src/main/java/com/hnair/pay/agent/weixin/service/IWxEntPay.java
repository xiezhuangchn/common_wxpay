package com.hnair.pay.agent.weixin.service;

import com.hnair.pay.agent.weixin.Request.entpay.EntPayBankRequest;
import com.hnair.pay.agent.weixin.Request.entpay.EntPayRequest;
import com.hnair.pay.agent.weixin.Response.entpay.EntPayBankQueryResult;
import com.hnair.pay.agent.weixin.Response.entpay.EntPayBankResult;
import com.hnair.pay.agent.weixin.Response.entpay.EntPayQueryResult;
import com.hnair.pay.agent.weixin.Response.entpay.EntPayResult;
import com.hnair.pay.agent.weixin.exception.WxPayException;

/**
 *
 *  企业付款相关服务类.
 *
 */
public interface IWxEntPay {
  /**
   * <pre>
   * 企业付款API.
   * 企业付款业务是基于微信支付商户平台的资金管理能力，为了协助商户方便地实现企业向个人付款，针对部分有开发能力的商户，提供通过API完成企业付款的功能。
   * 比如目前的保险行业向客户退保、给付、理赔。
   * 企业付款将使用商户的可用余额，需确保可用余额充足。查看可用余额、充值、提现请登录商户平台“资金管理”https://pay.weixin.qq.com/进行操作。
   * 注意：与商户微信支付收款资金并非同一账户，需要单独充值。
   * 文档详见: https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2
   * 接口链接：https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers
   * </pre>
   *
   * @param request 请求对象
   */
  EntPayResult entPay(EntPayRequest request) throws WxPayException;

  /**
   * <pre>
   * 查询企业付款API.
   * 用于商户的企业付款操作进行结果查询，返回付款操作详细结果。
   * 文档详见:https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_3
   * 接口链接：https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo
   * </pre>
   *
   * @param partnerTradeNo 商户订单号
   */
  EntPayQueryResult queryEntPay(String partnerTradeNo) throws WxPayException;

  /**
   * 企业付款到银行卡.
   * <pre>
   * 用于企业向微信用户银行卡付款
   * 目前支持接口API的方式向指定微信用户的银行卡付款。
   * 文档详见：https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_2
   * 接口链接：https://api.mch.weixin.qq.com/mmpaysptrans/pay_bank
   * </pre>
   *
   * @param request 请求对象
   */
  EntPayBankResult payBank(EntPayBankRequest request) throws WxPayException;

  /**
   * 企业付款到银行卡查询.
   * <pre>
   * 用于对商户企业付款到银行卡操作进行结果查询，返回付款操作详细结果。
   * 文档详见：https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_3
   * 接口链接：https://api.mch.weixin.qq.com/mmpaysptrans/query_bank
   * </pre>
   *
   * @param partnerTradeNo 商户订单号
   */
  EntPayBankQueryResult queryPayBank(String partnerTradeNo) throws WxPayException;



}
