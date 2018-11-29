package com.hnair.pay.agent.weixin.bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 卡券Api签名.
 */
public class WxCardApiSignature implements Serializable {
  private static final long serialVersionUID = 158176707226975979L;

  private String appId;

  private String cardId;

  private String cardType;

  private String locationId;

  private String code;

  private String openId;

  private Long timestamp;

  private String nonceStr;

  private String signature;

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public String getLocationId() {
    return locationId;
  }

  public void setLocationId(String locationId) {
    this.locationId = locationId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }
}
