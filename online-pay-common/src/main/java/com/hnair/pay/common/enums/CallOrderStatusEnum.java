package com.hnair.pay.common.enums;

/**
 * 通知订单系统-状态
 */
public enum CallOrderStatusEnum {

  INIT(0, "未通知"),
  SUCCESS(1, "通知成功");
  private Integer code;
  private String name;

  CallOrderStatusEnum(int code, String name) {
    this.name = name;
    this.code = code;
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
