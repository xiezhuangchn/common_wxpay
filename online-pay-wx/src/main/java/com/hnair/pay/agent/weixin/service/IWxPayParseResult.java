package com.hnair.pay.agent.weixin.service;

import com.hnair.pay.agent.weixin.Response.notify.WxPayOrderNotifyResult;
import com.hnair.pay.agent.weixin.Response.notify.WxPayRefundNotifyResult;
import com.hnair.pay.agent.weixin.exception.WxPayException;

/**
 * 解析微信返回结果接口.
 * bing.cheng
 */
public interface IWxPayParseResult {

  /**
   * 解析支付结果通知. 详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_7
   */
  WxPayOrderNotifyResult parseOrderNotifyResult(String xmlData) throws WxPayException;

  /**
   * 解析退款结果通知 详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_16&index=9
   */
  WxPayRefundNotifyResult parseRefundNotifyResult(String xmlData) throws WxPayException;

}
