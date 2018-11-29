package com.hnair.pay.common.enums.sharing;

/**
 * 分账通知订单状态
 */
public enum CallOrderSendStatusEnum {

  UN_SEND(0, "未发送"),
  SENDED(1, "已发送");
  private Integer code;

  private String name;

  CallOrderSendStatusEnum(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
