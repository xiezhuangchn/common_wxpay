package com.hnair.pay.common.enums;

/**
 * 订单号前缀 分账单号 退款单号
 */
public enum NoPreNoEnum {

  SHARING_NO_PREX("200", "分账单号前缀"),
  REFUND_NO_PREX("300", "退款单号前缀");

  private String code;
  private String message;

  NoPreNoEnum(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
