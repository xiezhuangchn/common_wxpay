package com.hnair.pay.rpc.sharing.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 分账回调
 */
@ApiModel(value = "分账回调")
public class SharingNotifyRequest {

    @ApiModelProperty("订单渠道( 01 微官网 )")
    private String busChannel;

    @ApiModelProperty(value = "订单号--业务系统订单号", required = true)
    @NotBlank(message = "订单号不能为空")
    private String busOrderNo;

    @ApiModelProperty(value = "退款订单类型（01客房、02商城、03预售卷）", required = true)
    @NotEmpty
    private String orderType;

    @ApiModelProperty(value = "支付订单号", required = true)
    @NotBlank(message = "支付订单号，不允许为空")
    private String payOrderNo;

    @ApiModelProperty(value = "支付宝或者微信分账订单号", required = true)
    @NotBlank(message = "支付宝或者微信分账订单号，不允许为空")
    private String sharingTradeNo;

    @ApiModelProperty(value = "分账总金额（单位分）", required = true)
    private Integer sharingFee;

    @NotEmpty
    @ApiModelProperty(value = "分账状态（2，分账成功， -1处理失败）", required = true)
    private Integer sharingStatus;

    @ApiModelProperty(value = "分账失败原因")
    private String failureReason;

    @ApiModelProperty(value = "分账类型", required = true)
    @NotNull
    private Integer sharingType;

    public String getBusChannel() {
        return busChannel;
    }

    public void setBusChannel(String busChannel) {
        this.busChannel = busChannel;
    }

    public Integer getSharingType() {
        return sharingType;
    }

    public void setSharingType(Integer sharingType) {
        this.sharingType = sharingType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getBusOrderNo() {
        return busOrderNo;
    }

    public void setBusOrderNo(String busOrderNo) {
        this.busOrderNo = busOrderNo;
    }

    public String getPayOrderNo() {
        return payOrderNo;
    }

    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    public Integer getSharingFee() {
        return sharingFee;
    }

    public void setSharingFee(Integer sharingFee) {
        this.sharingFee = sharingFee;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Integer getSharingStatus() {
        return sharingStatus;
    }

    public void setSharingStatus(Integer sharingStatus) {
        this.sharingStatus = sharingStatus;
    }

    public String getSharingTradeNo() {
        return sharingTradeNo;
    }

    public void setSharingTradeNo(String sharingTradeNo) {
        this.sharingTradeNo = sharingTradeNo;
    }
}
