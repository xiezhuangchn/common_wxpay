package com.hnair.pay.common.models.dto.response.pay;

import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("预下单 统一出参")
public class BasePreCreateOrderResponse extends PayPlatformBaseResponse {

    @ApiModelProperty(value = "订单号--业务系统订单号")
    private String orderId;

    @ApiModelProperty(value = "订单类型(订单系统传入,如微官网：01 酒店 02 商城 03 预售卷 04 限时请购)")
    private String orderType;

    @ApiModelProperty(value = "支付平台 订单号")
    private String payOrderId;

    @ApiModelProperty(value = "第三方返回的订单号-微信、支付宝等")
    private String prePayId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getPrePayId() {
        return prePayId;
    }

    public void setPrePayId(String prePayId) {
        this.prePayId = prePayId;
    }

}
