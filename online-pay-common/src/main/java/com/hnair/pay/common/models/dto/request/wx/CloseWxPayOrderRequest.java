package com.hnair.pay.common.models.dto.request.wx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel("微信支付关闭订单-入参")
public class CloseWxPayOrderRequest {

    @ApiModelProperty(value = "openid--用户微信openid", required = true)
    @NotBlank(message = "openid")
    private String openId;  //必须传

    @ApiModelProperty(value = "酒店Id", required = true)
    @NotBlank(message = "hotelId")
    private String hotelId;

    @ApiModelProperty(value = "订单号--业务系统订单号", required = true)
    @NotBlank(message = "订单号不能为空")
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}