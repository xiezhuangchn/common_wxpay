package com.hnair.pay.common.models.dto.request.refund;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 下午1:41 2018/7/20
 */
@ApiModel("订单退款请求消息体")
public class OrderRefundRequest {

  @ApiModelProperty(value = "订单号", required = true)
  @NotBlank(message = "订单号不允许为空")
  private String orderNo;

  @ApiModelProperty(value = "支付订单号", required = true)
  @NotBlank(message = "支付订单号，不允许为空")
  private String payOrderNo;

  @ApiModelProperty(value = "订单类型：01 客房 02商城、03预售卷  04 限抢购", required = true)
  @NotNull(message = "订单类型：01 客房 02商城、03预售卷  04 限抢购")
  private String orderType;

  @ApiModelProperty(value = "支付渠道 01 微信支付 02 支付宝支付", required = true)
  @NotNull(message = "支付渠道 01 微信支付 02 支付宝支付")
  private String payType;

  @ApiModelProperty(value = "订单支付总金额", required = true)
  private Long totalFee;

  @ApiModelProperty(value = "退款金额", required = true)
  private Long refundFee;

  @ApiModelProperty(value = "商户id", required = true)
  @NotBlank(message = "商户id，不允许为空")
  private String mchId;

  @ApiModelProperty(value = "微信订单号", required = true)
  @NotBlank(message = "微信订单号，不允许为空")
  private String tradePayNo;

  @ApiModelProperty(value = "退款原因")
  private String reason;

  @ApiModelProperty(value = "订单渠道：01 微官网", required = true)
  @NotNull(message = "订单渠道：01 微官网")
  private String busChannel;

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public String getPayOrderNo() {
    return payOrderNo;
  }

  public void setPayOrderNo(String payOrderNo) {
    this.payOrderNo = payOrderNo;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  public String getPayType() {
    return payType;
  }

  public void setPayType(String payType) {
    this.payType = payType;
  }

  public Long getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(Long totalFee) {
    this.totalFee = totalFee;
  }

  public Long getRefundFee() {
    return refundFee;
  }

  public void setRefundFee(Long refundFee) {
    this.refundFee = refundFee;
  }

  public String getMchId() {
    return mchId;
  }

  public void setMchId(String mchId) {
    this.mchId = mchId;
  }

  public String getTradePayNo() {
    return tradePayNo;
  }

  public void setTradePayNo(String tradePayNo) {
    this.tradePayNo = tradePayNo;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getBusChannel() {
    return busChannel;
  }

  public void setBusChannel(String busChannel) {
    this.busChannel = busChannel;
  }
}
