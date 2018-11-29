package com.hnair.pay.common.enums.sharing;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 下午2:20 2018/7/29
 */
public enum ShareAccountStatusEnum {

  INIT(0, "初始化"),
  PROCCESSING(1, "已经发起分账"),
  PROCESS_SUCCESS(2, "分账成功"),
  PROCESS_FAILED(-1, "处理失败");
  private int code;

  private String name;


  ShareAccountStatusEnum(int code, String name) {
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
