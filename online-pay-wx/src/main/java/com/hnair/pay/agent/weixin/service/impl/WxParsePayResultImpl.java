package com.hnair.pay.agent.weixin.service.impl;

import com.hnair.pay.agent.weixin.Response.WxPayOrderNotifyResultConverter;
import com.hnair.pay.agent.weixin.Response.notify.WxPayOrderNotifyResult;
import com.hnair.pay.agent.weixin.Response.notify.WxPayRefundNotifyResult;
import com.hnair.pay.agent.weixin.config.WxBaseConfig;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.IWxPayParseResult;
import com.hnair.pay.agent.weixin.utils.WxUtils;
import com.hnair.pay.agent.weixin.utils.XStreamInitializer;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 解析微信支付相關返回xml转换为对象
 */
public class WxParsePayResultImpl implements IWxPayParseResult {

    public final static Logger log = LoggerFactory.getLogger(WxParsePayResultImpl.class);

    private WxBaseConfig wxConfig;

    public WxParsePayResultImpl(WxBaseConfig wxConfig) {
        this.wxConfig = wxConfig;
    }

    @Override
    public WxPayRefundNotifyResult parseRefundNotifyResult(String xmlData) throws WxPayException {
        try {
            log.debug("微信支付退款异步通知参数：{}", xmlData);
            WxPayRefundNotifyResult result = this.parseRefundNotifyResult(xmlData, wxConfig.getMchKey());
            log.debug("微信支付退款异步通知解析后的对象：{}", result);
            return result;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxPayException("发生异常，" + e.getMessage(), e);
        }
    }

    /**
     * 从xml字符串创建bean对象
     *
     * @param xmlString xml字符串
     * @param mchKey    商户密钥
     */
    public static WxPayRefundNotifyResult parseRefundNotifyResult(String xmlString, String mchKey) throws WxPayException {
        WxPayRefundNotifyResult result = WxUtils.fromXML(xmlString, WxPayRefundNotifyResult.class);
        String reqInfoString = result.getReqInfoString();
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(mchKey.getBytes());
            final String keyMd5String = new BigInteger(1, md5.digest()).toString(16).toLowerCase();
            SecretKeySpec key = new SecretKeySpec(keyMd5String.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            result.setReqInfo(WxPayRefundNotifyResult.ReqInfo.fromXML(new String(cipher.doFinal(Base64.decodeBase64(reqInfoString)))));
        } catch (Exception e) {
            log.error("parseRefundNotifyResult error", e);
            throw new WxPayException("解密退款通知加密信息时出错");
        }

        return result;
    }

    @Override
    public WxPayOrderNotifyResult parseOrderNotifyResult(String xmlData) throws WxPayException {
        try {
            log.debug("微信支付异步通知请求参数：{}", xmlData);
            WxPayOrderNotifyResult result = this.fromXML(xmlData);
            log.debug("微信支付异步通知请求解析后的对象：{}", result);
            WxUtils.checkResult(wxConfig.getSignType(), false, result, wxConfig.getMchKey());
            return result;
        } catch (WxPayException e) {
            log.error(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxPayException("发生异常，" + e.getMessage(), e);
        }
    }

    public static WxPayOrderNotifyResult fromXML(String xmlString) {
        XStream xstream = XStreamInitializer.getInstance();
        xstream.processAnnotations(WxPayOrderNotifyResult.class);
        xstream.registerConverter(new WxPayOrderNotifyResultConverter(xstream.getMapper(), xstream.getReflectionProvider()));
        WxPayOrderNotifyResult result = (WxPayOrderNotifyResult) xstream.fromXML(xmlString);
        result.setXmlString(xmlString);
        return result;
    }

}
