package com.hnair.pay.common.enums.refund;

/**
 * 退款状态
 */
public enum OrderRefundStatusEnum {

  PENDING(0, "待处理"),
  IN_HAND(1, "处理中"),
  SEND_SUCCESSFUL(2, "发送成功"),
  REFUND_SUCCES(3, "退款成功"),
  TO_DEAL_WITH_FAILURE(-1, "处理失败");

  private Integer code;

  private String name;


  OrderRefundStatusEnum(Integer code, String name) {
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
