package com.hnair.pay.agent.weixin.Response;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * 微信支付结果共用属性类.
 *
 */
public abstract class BaseWxPayResult implements Serializable {
  /**
   * 返回状态码.
   */
  @XStreamAlias("return_code")
  protected String returnCode;
  /**
   * 返回信息.
   */
  @XStreamAlias("return_msg")
  protected String returnMsg;

  //当return_code为SUCCESS的时候，还会包括以下字段：

  /**
   * 业务结果.
   */
  @XStreamAlias("result_code")
  private String resultCode;
  /**
   * 错误代码.
   */
  @XStreamAlias("err_code")
  private String errCode;
  /**
   * 错误代码描述.
   */
  @XStreamAlias("err_code_des")
  private String errCodeDes;
  /**
   * 公众账号ID.
   */
  @XStreamAlias("appid")
  private String appid;
  /**
   * 商户号.
   */
  @XStreamAlias("mch_id")
  private String mchId;
  /**
   * 服务商模式下的子公众账号ID.
   */
  @XStreamAlias("sub_appid")
  private String subAppId;
  /**
   * 服务商模式下的子商户号.
   */
  @XStreamAlias("sub_mch_id")
  private String subMchId;
  /**
   * 随机字符串.
   */
  @XStreamAlias("nonce_str")
  private String nonceStr;
  /**
   * 签名.
   */
  @XStreamAlias("sign")
  private String sign;

  //以下为辅助属性
  /**
   * xml字符串.
   */
  private String xmlString;

  /**
   * xml的Document对象，用于解析xml文本.
   */
  private Document xmlDoc;

  /**
   * 获取xml中元素的值.
   */
  String getXmlValue(String... path) {
    Document doc = this.getXmlDoc();
    String expression = String.format("/%s//text()", Joiner.on("/").join(path));
    try {
      return (String) XPathFactory
        .newInstance()
        .newXPath()
        .compile(expression)
        .evaluate(doc, XPathConstants.STRING);
    } catch (XPathExpressionException e) {
      throw new RuntimeException("未找到相应路径的文本：" + expression);
    }
  }

  /**
   * 获取xml中元素的值，作为int值返回.
   */
  Integer getXmlValueAsInt(String... path) {
    String result = this.getXmlValue(path);
    if (StringUtils.isBlank(result)) {
      return null;
    }
    return Integer.valueOf(result);
  }

  /**
   * 将xml字符串转换成Document对象，以便读取其元素值.
   */
  private Document getXmlDoc() {
    if (this.xmlDoc != null) {
      return this.xmlDoc;
    }
    try {
      this.xmlDoc = DocumentBuilderFactory
              .newInstance()
              .newDocumentBuilder()
              .parse(new ByteArrayInputStream(this.xmlString.getBytes("UTF-8")));
      return xmlDoc;
    } catch (SAXException | IOException | ParserConfigurationException e) {
      throw new RuntimeException("非法的xml文本内容：" + this.xmlString);
    }

  }

  public String getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(String returnCode) {
    this.returnCode = returnCode;
  }

  public String getReturnMsg() {
    return returnMsg;
  }

  public void setReturnMsg(String returnMsg) {
    this.returnMsg = returnMsg;
  }

  public String getResultCode() {
    return resultCode;
  }

  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  public String getErrCode() {
    return errCode;
  }

  public void setErrCode(String errCode) {
    this.errCode = errCode;
  }

  public String getErrCodeDes() {
    return errCodeDes;
  }

  public void setErrCodeDes(String errCodeDes) {
    this.errCodeDes = errCodeDes;
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getMchId() {
    return mchId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public String getSubAppId() {
    return subAppId;
  }

  public void setSubAppId(String subAppId) {
    this.subAppId = subAppId;
  }

  public String getSubMchId() {
    return subMchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getXmlString() {
    return xmlString;
  }

  public void setXmlString(String xmlString) {
    this.xmlString = xmlString;
  }



  public void setXmlDoc(Document xmlDoc) {
    this.xmlDoc = xmlDoc;
  }

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }

}
