package com.hnair.pay.rpc.refund.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * 退款回调
 */
@ApiModel(value = "退款回调")
public class RefundNotifyRequest {

    @ApiModelProperty("订单渠道( 01 微官网 )")
    private String busChannel;

    @NotEmpty
    @ApiModelProperty(value = "订单号", required = true)
    private String orderId;

    @NotEmpty
    @ApiModelProperty(value = "微信（支付宝）退款流水号", required = true)
    private String refundTradeNo;

    @NotEmpty
    @ApiModelProperty(value = "退款时间", required = true)
    private Date refundTime;

    @NotEmpty
    @ApiModelProperty(value = "退款金额", required = true)
    private Long refundAmount;

    @NotEmpty
    @ApiModelProperty(value = "退款状态（2 退款成功、3 退款失败）", required = true)
    private Integer refundStatus;

    @ApiModelProperty(value = "退款失败原因（退款成功、退款失败）", required = true)
    private String refunFailReason;

    @NotEmpty
    @ApiModelProperty(value = "退款订单类型（01客房、02商城、03预售卷）", required = true)
    private String orderType;

    @ApiModelProperty(value = "支付平台退款订单号", required = true)
    private String refundOrderNo;

    public String getBusChannel() {
        return busChannel;
    }

    public void setBusChannel(String busChannel) {
        this.busChannel = busChannel;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRefundTradeNo() {
        return refundTradeNo;
    }

    public void setRefundTradeNo(String refundTradeNo) {
        this.refundTradeNo = refundTradeNo;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRefunFailReason() {
        return refunFailReason;
    }

    public void setRefunFailReason(String refunFailReason) {
        this.refunFailReason = refunFailReason;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getRefundOrderNo() {
        return refundOrderNo;
    }

    public void setRefundOrderNo(String refundOrderNo) {
        this.refundOrderNo = refundOrderNo;
    }
}
