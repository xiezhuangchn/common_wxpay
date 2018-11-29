package com.hnair.pay.common.models.dto.response.sharing;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("微信分账响应")
public class WechatSharingResponse {

  @ApiModelProperty(value = "支付订单号")
  private String busPayNo;

  @ApiModelProperty(value = "商户分账单号")
  private String sharingOrderNo;

  @ApiModelProperty(value = "三方返回的分账单号")
  private  String sharingTradeNo;

  @ApiModelProperty(value = "分账状态")
  private boolean status;

  @ApiModelProperty(value = "分账失败原因")
  private String failureReason;

  public String getFailureReason() {
    return failureReason;
  }

  public void setFailureReason(String failureReason) {
    this.failureReason = failureReason;
  }

  public String getBusPayNo() {
    return busPayNo;
  }

  public void setBusPayNo(String busPayNo) {
    this.busPayNo = busPayNo;
  }

  public String getSharingOrderNo() {
    return sharingOrderNo;
  }

  public void setSharingOrderNo(String sharingOrderNo) {
    this.sharingOrderNo = sharingOrderNo;
  }

  public String getSharingTradeNo() {
    return sharingTradeNo;
  }

  public void setSharingTradeNo(String sharingTradeNo) {
    this.sharingTradeNo = sharingTradeNo;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
