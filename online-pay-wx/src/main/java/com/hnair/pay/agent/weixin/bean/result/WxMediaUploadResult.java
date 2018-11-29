package com.hnair.pay.agent.weixin.bean.result;

import com.hnair.pay.agent.weixin.json.WxGsonBuilder;
import com.hnair.pay.agent.weixin.utils.ToStringUtils;

import java.io.Serializable;

public class WxMediaUploadResult implements Serializable {
  private static final long serialVersionUID = 330834334738622341L;

  private String type;
  private String mediaId;
  private String thumbMediaId;
  private long createdAt;

  public static WxMediaUploadResult fromJson(String json) {
    return WxGsonBuilder.create().fromJson(json, WxMediaUploadResult.class);
  }

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getMediaId() {
    return mediaId;
  }

  public void setMediaId(String mediaId) {
    this.mediaId = mediaId;
  }

  public String getThumbMediaId() {
    return thumbMediaId;
  }

  public void setThumbMediaId(String thumbMediaId) {
    this.thumbMediaId = thumbMediaId;
  }

  public long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
  }
}
