package com.hnair.pay.common.models.dto.request.wx;

import com.hnair.pay.common.models.dto.request.pay.BasePreCreateOrderRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("订单系统远程调用-订单创建支付订单-入参")
public class NoNeedPayOrderCreatePayOrderRequest extends BasePreCreateOrderRequest {

    @ApiModelProperty(value = "openid--用户微信openid", required = true)
    private String openId;

    @ApiModelProperty(value = "酒店id", required = true)
    @NotNull
    private String hotelId;

    @ApiModelProperty(value = "子商户账号", required = true)
    private String subMchId;

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
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
