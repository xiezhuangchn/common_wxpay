package com.hnair.pay.common.models.dto.request.wx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 上午11:34 2018/7/27 微信订单状态查看
 */
@ApiModel("查询微信订单状态")
public class WxOrderStatusRequest {

  @ApiModelProperty(value = "业务订单号")
  private String orderId;
  @ApiModelProperty(value = "微信支付订单号")
  private String trade_pay_no;
  @ApiModelProperty(value = "支付平台订单号")
  private String bus_pay_order_no;


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getTrade_pay_no() {
    return trade_pay_no;
  }

  public void setTrade_pay_no(String trade_pay_no) {
    this.trade_pay_no = trade_pay_no;
  }

  public String getBus_pay_order_no() {
    return bus_pay_order_no;
  }

  public void setBus_pay_order_no(String bus_pay_order_no) {
    this.bus_pay_order_no = bus_pay_order_no;
  }
}
