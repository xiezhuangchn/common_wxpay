package com.hnair.pay.common.models.dto.response.wx;

import com.hnair.pay.common.models.dto.response.pay.BasePreCreateOrderResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("远程调用-订单创建支付订单-返回")
public class NoNeedPayOrderCreatePayOrderResponse extends BasePreCreateOrderResponse {

    @ApiModelProperty("支付状态 1 支付成功 2 支付失败")
    private Integer payStatus;

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
}
