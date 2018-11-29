package com.hnair.pay.common.enums.sharing;


public enum SharingStatusEnum {

  INIT(0, "待处理"),
  PROCCESSING(1, "正在处理"),
  PROCESS_SUCCESS(2, "分账成功"),
  PROCESS_FAILED(-1, "处理失败");

  private int code;

  private String name;


  SharingStatusEnum(int code, String name) {
    this.name = name;
    this.code = code;
  }


  public int getCode() {
    return code;
  }

  public void setCode(int value) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



}
