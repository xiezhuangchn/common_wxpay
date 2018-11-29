package com.hnair.pay.agent.weixin.exception;

import com.hnair.pay.agent.weixin.constant.WxType;
import com.hnair.pay.agent.weixin.json.WxGsonBuilder;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 微信错误码.
 */
public class WxError implements Serializable {
  private static final long serialVersionUID = 7869786563361406291L;

  /**
   * 微信错误代码.
   */
  private int errorCode;

  /**
   * 微信错误信息.
   * （如果可以翻译为中文，就为中文）
   */
  private String errorMsg;

  /**
   * 微信接口返回的错误原始信息（英文）.
   */
  private String errorMsgEn;

  private String json;

  public static WxError fromJson(String json) {
    return fromJson(json, null);
  }

  public static WxError fromJson(String json, WxType type) {
    final WxError wxError = WxGsonBuilder.create().fromJson(json, WxError.class);
    if (StringUtils.isNotEmpty(wxError.getErrorMsg())) {
      wxError.setErrorMsgEn(wxError.getErrorMsg());
    }

    if (type == null) {
      return wxError;
    }

    if (type == WxType.MP) {
      final String msg = WxMpErrorMsgEnum.findMsgByCode(wxError.getErrorCode());
      if (msg != null) {
        wxError.setErrorMsg(msg);
      }
    } else if (type == WxType.CP) {
      final String msg = WxCpErrorMsgEnum.findMsgByCode(wxError.getErrorCode());
      if (msg != null) {
        wxError.setErrorMsg(msg);
      }
    }

    return wxError;
  }

  @Override
  public String toString() {
    if (this.json != null) {
      return this.json;
    }
    return "错误: Code=" + this.errorCode + ", Msg=" + this.errorMsg;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public String getErrorMsgEn() {
    return errorMsgEn;
  }

  public void setErrorMsgEn(String errorMsgEn) {
    this.errorMsgEn = errorMsgEn;
  }
}
