package com.hnair.pay.common.models.dto.request.wx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("查询微信退款订单状态")
public class RefundQueryRequest {

  @ApiModelProperty(value = "支付平台订单号")
  private String busPayOrderNo;

  public String getBusPayOrderNo() {
    return busPayOrderNo;
  }

  public void setBusPayOrderNo(String busPayOrderNo) {
    this.busPayOrderNo = busPayOrderNo;
  }
}
