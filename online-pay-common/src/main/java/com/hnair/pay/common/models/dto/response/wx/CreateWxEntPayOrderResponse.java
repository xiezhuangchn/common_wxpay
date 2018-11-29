package com.hnair.pay.common.models.dto.response.wx;

import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("微信企业付款创建订单-返回")
public class CreateWxEntPayOrderResponse extends PayPlatformBaseResponse {

    @ApiModelProperty(value = "支付订单号")
    private String busPayNo;
    @ApiModelProperty(value = "微信订单号(企业付款成功，返回的微信订单号)")
    private String paymentNo;
    @ApiModelProperty(value = "企业付款成功时间")
    private String paymentTime;

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getBusPayNo() {
        return busPayNo;
    }

    public void setBusPayNo(String busPayNo) {
        this.busPayNo = busPayNo;
    }
}