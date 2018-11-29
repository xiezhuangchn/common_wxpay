package com.hnair.pay.common.enums.sharing;


public enum SharingBindingInfoStatusEnum {

  FALSE((byte)0, "失败"),
  SUCCESS((byte)1, "成功"),
  ;

  private Byte code;

  private String name;

  SharingBindingInfoStatusEnum(Byte code, String name) {
    this.code = code;
    this.name = name;
  }

  public Byte getCode() {
    return code;
  }

  public void setCode(Byte code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
