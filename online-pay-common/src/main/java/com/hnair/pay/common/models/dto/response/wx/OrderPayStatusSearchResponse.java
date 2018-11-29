package com.hnair.pay.common.models.dto.response.wx;

import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@ApiModel("订单状态返回")
public class OrderPayStatusSearchResponse extends PayPlatformBaseResponse {

  // 支付状态（0 初始化 未支付 1 支付成功 2 支付失败）
  @ApiModelProperty(value = "订单支付状态")
  private Integer payStatus;

  @NotEmpty
  @ApiModelProperty(value = "订单号", required = true)
  private String orderId;

  @NotEmpty
  @ApiModelProperty(value = "订单类型（01客房、02商城、03预售卷 ）", required = true)
  private String orderType;

  @NotEmpty
  @ApiModelProperty(value = "支付时间", required = true)
  private Date payTime;

  @NotEmpty
  @ApiModelProperty(value = "支付金额--单位分", required = true)
  private Integer payAmount;

  @NotEmpty
  @ApiModelProperty(value = "支付宝或者微信订单号", required = true)
  private String tradePayNo;

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Date getPayTime() {
    return payTime;
  }

  public void setPayTime(Date payTime) {
    this.payTime = payTime;
  }

  public Integer getPayAmount() {
    return payAmount;
  }

  public void setPayAmount(Integer payAmount) {
    this.payAmount = payAmount;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  public String getTradePayNo() {
    return tradePayNo;
  }

  public void setTradePayNo(String tradePayNo) {
    this.tradePayNo = tradePayNo;
  }

  public Integer getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(Integer payStatus) {
    this.payStatus = payStatus;
  }
}
