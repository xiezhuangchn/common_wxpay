package com.hnair.pay.common.models.dto.request.sharing;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class ReceiverVo {

//    分账接收方 类型
//    MERCHANT_ID：商户 ID PERSONAL_WECHATID：个人微信号 PERSONAL_OPENID：个人 openid（由父商
//    微信支付开发文档(内部文档)
    @ApiModelProperty(value = "分账接收方类型(MERCHANT_ID：商户 ID PERSONAL_WECHATID：个人微信号 PERSONAL_OPENID：个人 openid)")
    @NotNull
    private String type;

//    类型是 MERCHANT_ID 时，是商户 ID 类型是 PERSONAL_WECHATID 时，是个人 微信号 类型是 PERSONAL_OPENID 时，是个人 openid 类型是 PERSONAL_SUB_OPENID 时，是个 人 sub_openid
    @ApiModelProperty(value = "分账接收方帐号(类型是 MERCHANT_ID 时，是商户 ID 类型是 PERSONAL_WECHATID 时，是个人 微信号 类型是 PERSONAL_OPENID 时，是个人 openid 类型是 PERSONAL_SUB_OPENID 时，是个 人 sub_openid)")
    @NotNull
    private String account;

    //分账接收方类型是 MERCHANT_ID 时，是 商户全称（必传） 分账接收方类型是 PERSONAL_WECHATID 时，是个人姓名（必传） 分账接收方类型是 PERSONAL_OPENID 时，是个人姓名（选传，传则校验） 分账接收方类型是 PERSONAL_SUB_OPENID 时，是个人姓名 （选传，传则校验）
    @ApiModelProperty(value = "分账接收方全称(分账接收方类型是 MERCHANT_ID 时，是 商户全称（必传） 分账接收方类型是 PERSONAL_WECHATID 时，是个人姓名（必传） 分账接收方类型是 PERSONAL_OPENID 时，是个人姓名（选传，传则校验） 分账接收方类型是 PERSONAL_SUB_OPENID 时，是个人姓名 （选传，传则校验）)")
    @NotNull
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
