package com.hnair.pay.agent.weixin.service.impl;

import com.hnair.pay.agent.weixin.Request.WxPayDefaultRequest;
import com.hnair.pay.agent.weixin.Request.entpay.EntPayBankQueryRequest;
import com.hnair.pay.agent.weixin.Request.entpay.EntPayBankRequest;
import com.hnair.pay.agent.weixin.Request.entpay.EntPayQueryRequest;
import com.hnair.pay.agent.weixin.Request.entpay.EntPayRequest;
import com.hnair.pay.agent.weixin.Response.entpay.*;
import com.hnair.pay.agent.weixin.config.WxBaseConfig;
import com.hnair.pay.agent.weixin.constant.UrlConstants;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.IWxEntPay;
import com.hnair.pay.agent.weixin.service.IWxHttpClient;
import com.hnair.pay.agent.weixin.utils.SignUtils;
import com.hnair.pay.agent.weixin.utils.WxUtils;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PublicKey;
import java.security.Security;

/**
 * 企业付款实现
 */
public class EntPayServiceImpl implements IWxEntPay {

  private WxBaseConfig wxEnPayConfig;

  private IWxHttpClient iWxHttpClient;

  public EntPayServiceImpl(WxBaseConfig wxEnPayConfig, IWxHttpClient iWxHttpClient) {
    this.wxEnPayConfig = wxEnPayConfig;
    this.iWxHttpClient = iWxHttpClient;
  }

  @Override
  public EntPayResult entPay(EntPayRequest request) throws WxPayException {
    request.checkAndSign(wxEnPayConfig);
    String url = wxEnPayConfig.getPayBaseUrl() + UrlConstants.WX_ENT_PAY;

    String responseContent = iWxHttpClient.post(url, request.toXML(), true);
    EntPayResult result = WxUtils.fromXML(responseContent, EntPayResult.class);
    WxUtils.checkResult(request.getSignType(), true, result, wxEnPayConfig.getMchKey());
    return result;
  }

  @Override
  public EntPayQueryResult queryEntPay(String partnerTradeNo) throws WxPayException {
    EntPayQueryRequest request = new EntPayQueryRequest();
    request.setPartnerTradeNo(partnerTradeNo);
    request.checkAndSign(wxEnPayConfig);

    String url = wxEnPayConfig.getPayBaseUrl() + UrlConstants.WX_QUERY_ENT_PAY;
    String responseContent = iWxHttpClient.post(url, request.toXML(), true);
    EntPayQueryResult result = WxUtils.fromXML(responseContent, EntPayQueryResult.class);
    WxUtils.checkResult(request.getSignType(), true, result, wxEnPayConfig.getMchKey());
    return result;
  }

  @Override
  public EntPayBankResult payBank(EntPayBankRequest request) throws WxPayException {
    request.checkAndSign(wxEnPayConfig);
    File publicKeyFile = this.buildPublicKeyFile();
    request.setEncBankNo(this.encryptRSA(publicKeyFile, request.getEncBankNo()));
    request.setEncTrueName(this.encryptRSA(publicKeyFile, request.getEncTrueName()));
    publicKeyFile.deleteOnExit();

    request.checkAndSign(wxEnPayConfig);

    String url = this.wxEnPayConfig.getPayBaseUrl() +UrlConstants.WX_ENT_PAY_BANK;
    String responseContent = this.iWxHttpClient.post(url, request.toXML(), true);
    EntPayBankResult result = WxUtils.fromXML(responseContent, EntPayBankResult.class);
    WxUtils.checkResult(request.getSignType(), true, result, wxEnPayConfig.getMchKey());
    return result;
  }

  @Override
  public EntPayBankQueryResult queryPayBank(String partnerTradeNo) throws WxPayException {
    EntPayBankQueryRequest request = new EntPayBankQueryRequest();
    request.setPartnerTradeNo(partnerTradeNo);
    request.checkAndSign(wxEnPayConfig);

    String url = this.wxEnPayConfig.getPayBaseUrl() + UrlConstants.WX_QUERY_ENT_PAY_BANK;
    String responseContent = this.iWxHttpClient.post(url, request.toXML(), true);
    EntPayBankQueryResult result = WxUtils.fromXML(responseContent, EntPayBankQueryResult.class);
    WxUtils.checkResult(request.getSignType(), true, result, wxEnPayConfig.getMchKey());
    return result;
  }

  public String getPublicKey() throws WxPayException {
    WxPayDefaultRequest request = new WxPayDefaultRequest();
    request.setMchId(this.wxEnPayConfig.getMchId());
    request.setNonceStr(String.valueOf(System.currentTimeMillis()));
    request.setSign(SignUtils.createSign(request, null, this.wxEnPayConfig.getMchKey(),
            true));

    String url = "https://fraud.mch.weixin.qq.com/risk/getpublickey";
    String responseContent = this.iWxHttpClient.post(url, request.toXML(), true);
    GetPublicKeyResult result = WxUtils.fromXML(responseContent, GetPublicKeyResult.class);
    WxUtils.checkResult(request.getSignType(), true, result, wxEnPayConfig.getMchKey());
    return result.getPubKey();
  }

  private String encryptRSA(File publicKeyFile, String srcString) throws WxPayException {
    try {
      Security.addProvider(new BouncyCastleProvider());
      Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
      try (PEMParser reader = new PEMParser(new FileReader(publicKeyFile))) {
        final PublicKey publicKey = new JcaPEMKeyConverter().setProvider("BC")
                .getPublicKey((SubjectPublicKeyInfo) reader.readObject());

        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypt = cipher.doFinal(srcString.getBytes());
        return Base64.encodeBase64String(encrypt);
      }
    } catch (Exception e) {
      throw new WxPayException("加密出错", e);
    }
  }


  private File buildPublicKeyFile() throws WxPayException {
    try {
      String publicKeyStr = this.getPublicKey();
      Path tmpFile = Files.createTempFile("payToBank", ".pem");
      Files.write(tmpFile, publicKeyStr.getBytes());
      return tmpFile.toFile();
    } catch (Exception e) {
      throw new WxPayException("生成加密公钥文件时发生异常", e);
    }
  }



}
