package com.hnair.pay.common.models.dto.response.wx;

import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("微信企业付款银行创建订单-返回")
public class CreateWxEntPayBankOrderResponse extends PayPlatformBaseResponse {

    @ApiModelProperty(value = "付款金额")
    private Integer amount;

    @ApiModelProperty(value = "商户企业付款单号")
    private String partnerTradeNo;

    //############以下字段在return_code 和result_code都为SUCCESS的时候有返回##############
    @ApiModelProperty(value = "微信企业付款单号,代付成功后，返回的内部业务单号")
    private String paymentNo;

    @ApiModelProperty(value = "手续费金额(分)")
    private Integer cmmsAmount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public Integer getCmmsAmount() {
        return cmmsAmount;
    }

    public void setCmmsAmount(Integer cmmsAmount) {
        this.cmmsAmount = cmmsAmount;
    }
}
