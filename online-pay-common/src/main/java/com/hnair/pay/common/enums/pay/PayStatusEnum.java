package com.hnair.pay.common.enums.pay;

/**
 * 支付订单-支付状态
 */
public enum PayStatusEnum {

  INITIALIZE(0, "初始化"),
  NO_PAY(-1, "未支付"),
  PAY_SUCCESS(1, "支付成功"),
  PAYMENT_FAILED(2, "支付失败");

  private Integer code;
  private String message;

  PayStatusEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  public static PayStatusEnum value(int code) {
    for (PayStatusEnum payStatusEnum : PayStatusEnum.values()) {
      if (payStatusEnum.getCode() == code) {
        return payStatusEnum;
      }
    }

    return null;
  }
}
