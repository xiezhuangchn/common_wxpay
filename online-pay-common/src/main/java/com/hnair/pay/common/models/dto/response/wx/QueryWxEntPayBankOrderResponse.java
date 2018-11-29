package com.hnair.pay.common.models.dto.response.wx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询微信企业付款银行订单-返回")
public class QueryWxEntPayBankOrderResponse {

    @ApiModelProperty(value = "商户企业付款单号")
    private String partnerTradeNo;

    @ApiModelProperty(value = "微信企业付款单号,即为微信内部业务单号")
    private String paymentNo;

    @ApiModelProperty(value = "银行卡号")
    private String bankNo;

    @ApiModelProperty(value = "用户真实姓名")
    private String trueName;

    @ApiModelProperty(value = "付款金额")
    private Integer amount;

    @ApiModelProperty(value = "代付单状态"+
              "PROCESSING（处理中，如有明确失败，则返回额外失败原因；否则没有错误原因）"+
              "SUCCESS（付款成功）"+
              "FAILED（付款失败）"+
              "BANK_FAIL（银行退票，订单状态由付款成功流转至退票,退票时付款金额和手续费会自动退还")
    private String status;

    @ApiModelProperty(value = "手续费(分)")
    private Integer cmmsAmount;

    @ApiModelProperty(value = "商户下单时间,微信侧订单创建时间")
    private String createTime;

    @ApiModelProperty(value = "微信侧付款成功时间（但无法保证银行不会退票）")
    private String paySuccessTime;

    @ApiModelProperty(value = "单失败原因（如：余额不足）")
    private String failReason;

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

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCmmsAmount() {
        return cmmsAmount;
    }

    public void setCmmsAmount(Integer cmmsAmount) {
        this.cmmsAmount = cmmsAmount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(String paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
}