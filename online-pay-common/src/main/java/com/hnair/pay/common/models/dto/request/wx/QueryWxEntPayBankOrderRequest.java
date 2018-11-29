package com.hnair.pay.common.models.dto.request.wx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel("查询微信企业付款银行订单-请求")
public class QueryWxEntPayBankOrderRequest {

    @ApiModelProperty(value = "订单号", required = true)
    @NotBlank(message = "订单号，不允许为空")
    private String partnerTradeNo;

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }
}