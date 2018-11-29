package com.hnair.pay.common.models.dto.request.wx;

import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel("查询微信企业付款订单-请求")
public class QueryWxEntPayOrderRequest extends PayPlatformBaseRequest {

    @ApiModelProperty(value = "提现订单号", required = true)
    @NotBlank(message = "提现订单号，不允许为空")
    private String withdrawOrderNo;

    public String getWithdrawOrderNo() {
        return withdrawOrderNo;
    }

    public void setWithdrawOrderNo(String withdrawOrderNo) {
        this.withdrawOrderNo = withdrawOrderNo;
    }
}