package com.hnair.pay.agent.weixin.service;

import com.hnair.pay.agent.weixin.exception.WxPayException;

/**
 * 微信发送请求相关接口.
 * bing.cheng
 */
public interface IWxHttpClient {
  /**
   * 发送post请求，得到响应字节数组.
   *
   * @param url 请求地址
   * @param requestStr 请求信息
   * @param useKey 是否使用证书
   * @return 返回请求结果字节数组
   */
  byte[] postForBytes(String url, String requestStr, boolean useKey) throws WxPayException;

  /**
   * 发送post请求，得到响应字符串.
   *
   * @param url 请求地址
   * @param requestStr 请求信息
   * @param useKey 是否使用证书
   * @return 返回请求结果字符串
   */
  String post(String url, String requestStr, boolean useKey) throws WxPayException;



}
