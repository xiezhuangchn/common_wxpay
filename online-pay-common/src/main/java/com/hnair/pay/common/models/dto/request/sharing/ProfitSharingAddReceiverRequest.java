package com.hnair.pay.common.models.dto.request.sharing;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 分账关系绑定入参
 */
@ApiModel("绑定子商户分账关系请求入参")
public class ProfitSharingAddReceiverRequest {

    @ApiModelProperty(value = "微信支付分配的子商户号   子商户号")
    @NotNull
    public String subMchId ;//是 string(32) 1900000109 微信支付分配的子商户号   子商户号

    @ApiModelProperty(value = "子商户公众 账号 微信分配的子商户公众账号 ID，分账接收 方类型为 PERSONAL_SUB_OPENID 时必填")
    private String subAppid;

    @NotNull
    private ReceiverVo receiver;

    public ReceiverVo getReceiver() {
        return receiver;
    }

    public void setReceiver(ReceiverVo receiver) {
        this.receiver = receiver;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }
}
