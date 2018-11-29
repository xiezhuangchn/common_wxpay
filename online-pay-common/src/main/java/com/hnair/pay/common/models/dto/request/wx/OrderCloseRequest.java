package com.hnair.pay.common.models.dto.request.wx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel("订单关单请求消息体")
public class OrderCloseRequest {

  // 业务订单号(如客房订单号)
  @ApiModelProperty(value = "订单号--业务系统订单号", required = true)
  @NotBlank(message = "订单号不能为空")
  private String busOrderNo;

  @ApiModelProperty(value = "openid--用户微信openid", required = true)
  @NotBlank(message = "openid")
  private String wxOpenId;

  // 酒店id
  @ApiModelProperty(value = "酒店Id", required = true)
  @NotBlank(message = "hotelId")
  private String hotelId;

  public String getBusOrderNo() {
    return busOrderNo;
  }

  public void setBusOrderNo(String busOrderNo) {
    this.busOrderNo = busOrderNo;
  }


  public String getWxOpenId() {
    return wxOpenId;
  }

  public void setWxOpenId(String wxOpenId) {
    this.wxOpenId = wxOpenId;
  }

  public String getHotelId() {
    return hotelId;
  }

  public void setHotelId(String hotelId) {
    this.hotelId = hotelId;
  }
}
