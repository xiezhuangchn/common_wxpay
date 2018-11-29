package com.hnair.pay.agent.weixin.service.impl;

import com.hnair.pay.agent.weixin.Request.*;
import com.hnair.pay.agent.weixin.Request.order.WxPayAppOrderResult;
import com.hnair.pay.agent.weixin.Request.order.WxPayMpOrderResult;
import com.hnair.pay.agent.weixin.Request.order.WxPayMwebOrderResult;
import com.hnair.pay.agent.weixin.Request.order.WxPayNativeOrderResult;
import com.hnair.pay.agent.weixin.Response.*;
import com.hnair.pay.agent.weixin.config.WxBaseConfig;
import com.hnair.pay.agent.weixin.constant.UrlConstants;
import com.hnair.pay.agent.weixin.constant.WxPayConstants;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.IWxHttpClient;
import com.hnair.pay.agent.weixin.service.IWxPay;
import com.hnair.pay.agent.weixin.utils.SignUtils;
import com.hnair.pay.agent.weixin.utils.WxUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  微信支付接口请求实现类
 * </pre>
 */
public class WxPayServiceImpl implements IWxPay{

  private WxBaseConfig wxPayConfig;

  private IWxHttpClient iWxHttpClient;

  /**
   * 构造函数 创建bean注入
   * @param wxPayConfig
   * @param iWxHttpClient
   */
  public WxPayServiceImpl (WxBaseConfig wxPayConfig, IWxHttpClient iWxHttpClient) {
    this.wxPayConfig = wxPayConfig;
    this.iWxHttpClient = iWxHttpClient;
  }

  @Override
  public WxPayRefundResult refund(WxPayRefundRequest request) throws WxPayException {
    request.checkAndSign(wxPayConfig);
    String url = wxPayConfig.getPayBaseUrl() + UrlConstants.WX_REFUND;
    String responseContent = iWxHttpClient.post(url, request.toXML(), true);
    WxPayRefundResult result = WxUtils.fromXML(responseContent, WxPayRefundResult.class);
    WxUtils.checkResult(request.getSignType(), true, result, wxPayConfig.getMchKey());
    return result;
  }

  @Override
  public WxPayRefundQueryResult refundQuery(String transactionId, String outTradeNo,
      String outRefundNo, String refundId)
      throws WxPayException {
    WxPayRefundQueryRequest request = new WxPayRefundQueryRequest();
    request.setOutTradeNo(StringUtils.trimToNull(outTradeNo));
    request.setTransactionId(StringUtils.trimToNull(transactionId));
    request.setOutRefundNo(StringUtils.trimToNull(outRefundNo));
    request.setRefundId(StringUtils.trimToNull(refundId));
    return this.refundQuery(request);
  }

  @Override
  public WxPayRefundQueryResult refundQuery(WxPayRefundQueryRequest request) throws WxPayException {
    request.checkAndSign(wxPayConfig);
    String url = wxPayConfig.getPayBaseUrl() + UrlConstants.WX_REFUNDQUERY;
    String responseContent = iWxHttpClient.post(url, request.toXML(), false);
    WxPayRefundQueryResult result = WxUtils
        .fromXML(responseContent, WxPayRefundQueryResult.class);
    result.composeRefundRecords();
    WxUtils.checkResult(request.getSignType(), true, result, wxPayConfig.getMchKey());
    return result;
  }

  @Override
  public WxPayOrderQueryResult queryOrder(WxPayOrderQueryRequest request) throws WxPayException {
    request.checkAndSign(wxPayConfig);

    String url = wxPayConfig.getPayBaseUrl() + UrlConstants.WX_ORDERQUERY;
    String responseContent = iWxHttpClient.post(url, request.toXML(), false);
    if (StringUtils.isBlank(responseContent)) {
      throw new WxPayException("无响应结果");
    }

    WxPayOrderQueryResult result = WxUtils
        .fromXML(responseContent, WxPayOrderQueryResult.class);
    result.composeCoupons();
    WxUtils.checkResult(request.getSignType(), true, result, wxPayConfig.getMchKey());
    return result;
  }

  @Override
  public WxPayOrderCloseResult closeOrder(WxPayOrderCloseRequest request) throws WxPayException {
    request.checkAndSign(wxPayConfig);
    String url = wxPayConfig.getPayBaseUrl() + UrlConstants.WX_CLOSEORDER;
    String responseContent = iWxHttpClient.post(url, request.toXML(), false);
    WxPayOrderCloseResult result = WxUtils
        .fromXML(responseContent, WxPayOrderCloseResult.class);
    WxUtils.checkResult(request.getSignType(), true, result, wxPayConfig.getMchKey());
    return result;
  }

  @Override
  public <T> T createOrder(WxPayUnifiedOrderRequest request) throws WxPayException {
    WxPayUnifiedOrderResult unifiedOrderResult = this.unifiedOrder(request);
    String prepayId = unifiedOrderResult.getPrepayId();
    if (StringUtils.isBlank(prepayId)) {
      throw new WxPayException(String.format("无法获取prepay id，错误代码： '%s'，信息：%s。",
          unifiedOrderResult.getErrCode(), unifiedOrderResult.getErrCodeDes()));
    }

    String timestamp = String.valueOf(System.currentTimeMillis());
    String nonceStr = timestamp;
    switch (request.getTradeType()) {
      case WxPayConstants.TradeType.MWEB: {
        return (T) new WxPayMwebOrderResult(unifiedOrderResult.getMwebUrl());
      }

      case WxPayConstants.TradeType.NATIVE: {
        return (T) new WxPayNativeOrderResult(unifiedOrderResult.getCodeURL());
      }

      case WxPayConstants.TradeType.APP: {
        // APP支付绑定的是微信开放平台上的账号，APPID为开放平台上绑定APP后发放的参数
        String appId = unifiedOrderResult.getAppid();
        if (StringUtils.isNotEmpty(unifiedOrderResult.getSubAppId())) {
          appId = unifiedOrderResult.getSubAppId();
        }

        Map<String, String> configMap = new HashMap<>(8);
        // 此map用于参与调起sdk支付的二次签名,格式全小写，timestamp只能是10位,格式固定，切勿修改
        String partnerId;
        if (StringUtils.isEmpty(request.getMchId())) {
          partnerId = wxPayConfig.getMchId();
        } else {
          partnerId = request.getMchId();
        }

        configMap.put("prepayid", prepayId);
        configMap.put("partnerid", partnerId);
        String packageValue = "Sign=WXPay";
        configMap.put("package", packageValue);
        configMap.put("timestamp", timestamp);
        configMap.put("noncestr", nonceStr);
        configMap.put("appid", appId);

        final WxPayAppOrderResult result = new WxPayAppOrderResult();
        result.setSign(SignUtils.createSign(configMap, null, wxPayConfig.getMchKey(), false));
        result.setPrepayId(prepayId);
        result.setPartnerId(partnerId);
        result.setAppId(appId);
        result.setPackageValue(packageValue);
        result.setTimeStamp(timestamp);
        result.setNonceStr(nonceStr);
        return (T) result;
      }

      case WxPayConstants.TradeType.JSAPI: {
        String signType = WxPayConstants.SignType.MD5;
        WxPayMpOrderResult payResult = new WxPayMpOrderResult();
        payResult.setAppId(unifiedOrderResult.getAppid());
        payResult.setSubAppId(unifiedOrderResult.getSubAppId());
        payResult.setTimeStamp(timestamp);
        payResult.setNonceStr(nonceStr);
        payResult.setPackageValue("prepay_id=" + prepayId);
        payResult.setSignType(signType);

        payResult.setPaySign(SignUtils.createSign(payResult, signType, wxPayConfig.getMchKey(), false));
        return (T) payResult;
      }
      default: {
        throw new WxPayException("该交易类型暂不支持");
      }
    }
  }

  @Override
  public WxPayUnifiedOrderResult unifiedOrder(WxPayUnifiedOrderRequest request) throws WxPayException {
    request.checkAndSign(wxPayConfig);

    String url = wxPayConfig.getPayBaseUrl() + UrlConstants.WX_UNIFIEDORDER;
    String responseContent = iWxHttpClient.post(url, request.toXML(), false);
    WxPayUnifiedOrderResult result = WxUtils.fromXML(responseContent, WxPayUnifiedOrderResult.class);
    WxUtils.checkResult(request.getSignType(), true, result, wxPayConfig.getMchKey());
    return result;
  }


}
