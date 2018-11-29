package com.hnair.pay.common.models.dto.request.wx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@ApiModel("创建微信企业付款订单-请求")
public class CreateWxEntPayOrderRequest {

    @ApiModelProperty(value = "提现订单号", required = true)
    @NotBlank(message = "提现订单号，不允许为空")
    private String withdrawOrderNo;

    @ApiModelProperty(value = "商户appid下，某用户的openid", required = true)
    @NotBlank(message = "openid，不允许为空")
    private String openid;

    @ApiModelProperty(value = "企业付款金额， 单位为分")
    @NotNull
    private Integer amount;

    @ApiModelProperty("营销人员id")
    private String marketingPersonId;

    @ApiModelProperty("货币类型")
    private String feeType;

    public String getMarketingPersonId() {
        return marketingPersonId;
    }

    public void setMarketingPersonId(String marketingPersonId) {
        this.marketingPersonId = marketingPersonId;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getWithdrawOrderNo() {
        return withdrawOrderNo;
    }

    public void setWithdrawOrderNo(String withdrawOrderNo) {
        this.withdrawOrderNo = withdrawOrderNo;
    }
}