package com.hnair.pay.agent.weixin.service.impl;

import com.hnair.pay.agent.weixin.Request.WxProfitsharingaddreceiverRequest;
import com.hnair.pay.agent.weixin.Request.WxSharingAccountStatusRequest;
import com.hnair.pay.agent.weixin.Request.WxSharingRequest;
import com.hnair.pay.agent.weixin.Response.WxProfitsharingaddreceiverResponse;
import com.hnair.pay.agent.weixin.Response.WxSharingAccountStatusResponse;
import com.hnair.pay.agent.weixin.Response.WxSharingResult;
import com.hnair.pay.agent.weixin.config.WxBaseConfig;
import com.hnair.pay.agent.weixin.constant.UrlConstants;
import com.hnair.pay.agent.weixin.constant.WxPayConstants;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.IWxHttpClient;
import com.hnair.pay.agent.weixin.service.IWxSharing;
import com.hnair.pay.agent.weixin.utils.WxUtils;

/**
 * 微信分账实现
 **/
public class WxSharingImpl implements IWxSharing {

    private WxBaseConfig wxPayConfig;

    private IWxHttpClient iWxHttpClient;

    /**
     * 构造函数 创建bean注入
     * @param wxPayConfig
     * @param iWxHttpClient
     */
    public WxSharingImpl(WxBaseConfig wxPayConfig, IWxHttpClient iWxHttpClient) {
        this.wxPayConfig = wxPayConfig;
        this.iWxHttpClient = iWxHttpClient;
    }

    @Override
    public WxSharingResult profitsharing(WxSharingRequest request) throws WxPayException {
        request.setSignType(WxPayConstants.SignType.HMAC_SHA256);
        request.checkAndSign(wxPayConfig);
        String url = wxPayConfig.getPayBaseUrl() + UrlConstants.WX_SHARING;
        String responseContent = iWxHttpClient.post(url, request.toXML(), true);
        WxSharingResult result = WxUtils.fromXML(responseContent, WxSharingResult.class);
        WxUtils.checkResult(request.getSignType(), true, result, wxPayConfig.getMchKey());
        return result;
    }

    @Override
    public WxSharingAccountStatusResponse queryShareAccountStatus(
            WxSharingAccountStatusRequest request) throws WxPayException {
        request.setSignType(WxPayConstants.SignType.HMAC_SHA256);
        request.checkAndSign(wxPayConfig);
        String url = wxPayConfig.getPayBaseUrl() + UrlConstants.WX_QUERY_SHARING;
        String responseContent = iWxHttpClient.post(url, request.toXML(), true);
        WxSharingAccountStatusResponse result = WxUtils.fromXML(responseContent, WxSharingAccountStatusResponse.class);
        WxUtils.checkResult(request.getSignType(), true, result, wxPayConfig.getMchKey());
        return result;
    }

    @Override
    public WxProfitsharingaddreceiverResponse wxProfitsharingaddreceiver(WxProfitsharingaddreceiverRequest request) throws WxPayException {
        request.setSignType(WxPayConstants.SignType.HMAC_SHA256);
        request.checkAndSign(wxPayConfig);
        String url = wxPayConfig.getPayBaseUrl() + UrlConstants.WX_PROFITSHARINGADDRECEIVER;
        String responseContent = iWxHttpClient.post(url, request.toXML(), false);
        WxProfitsharingaddreceiverResponse result = WxUtils
                .fromXML(responseContent, WxProfitsharingaddreceiverResponse.class);
        WxUtils.checkResult( request.getSignType(), true, result, wxPayConfig.getMchKey());
        return result;
    }


}
