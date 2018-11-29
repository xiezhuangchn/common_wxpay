package com.hnair.pay.common.models.dto.response.wx;

import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("订单关闭返回")
public class OrderCloseResponse extends PayPlatformBaseResponse {

  // 支付订单号（系统内部的支付订单号）
  @ApiModelProperty(value = "支付订单号（系统内部的支付订单号）")
  private String busPayOrderNo;

  // 关单时间
  @ApiModelProperty(value = "关单时间")
  private Date paySuccessTime;

  // 支付状态（0 初始化 未支付 1 支付成功 2 支付失败）
  @ApiModelProperty(value = "订单支付状态")
  private Integer payStatus;

  private String msg;

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getBusPayOrderNo() {
    return busPayOrderNo;
  }

  public void setBusPayOrderNo(String busPayOrderNo) {
    this.busPayOrderNo = busPayOrderNo;
  }

  public Date getPaySuccessTime() {
    return paySuccessTime;
  }

  public void setPaySuccessTime(Date paySuccessTime) {
    this.paySuccessTime = paySuccessTime;
  }

  public Integer getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(Integer payStatus) {
    this.payStatus = payStatus;
  }
}
