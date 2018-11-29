package com.hnair.pay.rpc.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * 支付成功回调
 */
@ApiModel(value = "支付成功回调")
public class PayNotifyRequest {

    @ApiModelProperty("订单渠道( 01 微官网 )")
    private String busChannel;

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
}
