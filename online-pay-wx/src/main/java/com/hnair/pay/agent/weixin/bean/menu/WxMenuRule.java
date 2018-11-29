package com.hnair.pay.agent.weixin.bean.menu;

import com.google.gson.annotations.SerializedName;
import com.hnair.pay.agent.weixin.utils.ToStringUtils;

import java.io.Serializable;

public class WxMenuRule implements Serializable {
  private static final long serialVersionUID = -4587181819499286670L;

  /**
   * 变态的微信接口，反序列化时这里反人类的使用和序列化时不一样的名字.
   */
  @SerializedName(value = "tag_id", alternate = "group_id")
  private String tagId;
  private String sex;
  private String country;
  private String province;
  private String city;
  private String clientPlatformType;
  private String language;

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }

  public String getTagId() {
    return tagId;
  }

  public void setTagId(String tagId) {
    this.tagId = tagId;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getClientPlatformType() {
    return clientPlatformType;
  }

  public void setClientPlatformType(String clientPlatformType) {
    this.clientPlatformType = clientPlatformType;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }
}
