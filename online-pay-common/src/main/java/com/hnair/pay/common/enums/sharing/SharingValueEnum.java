package com.hnair.pay.common.enums.sharing;


public enum SharingValueEnum {

  TRUE("Y", "是"),
  FALSE("N", "否");

  private String code;

  private String name;

  SharingValueEnum(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



}
