package com.hnair.pay.common.models.dto.request.wx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel("订单状态请求消息体")
public class OrderPayStatusSearchRequest {




  @ApiModelProperty(value = "订单号--业务系统订单号", required = true)
  @NotBlank(message = "订单号不能为空")
  private String busOrderNo;


  public String getBusOrderNo() {
    return busOrderNo;
  }

  public void setBusOrderNo(String busOrderNo) {
    this.busOrderNo = busOrderNo;
  }
}
