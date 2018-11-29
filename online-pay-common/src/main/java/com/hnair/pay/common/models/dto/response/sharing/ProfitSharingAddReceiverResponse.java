package com.hnair.pay.common.models.dto.response.sharing;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分账关系绑定返回值
 */
public class ProfitSharingAddReceiverResponse {

    @ApiModelProperty(value = "绑定状态 true 成功 false 失败")
    public Boolean status ;

    @ApiModelProperty(value = "错误信息")
    public String errorMsg ;

    @ApiModelProperty(value = "商户号")
    public String mchId ;

    @ApiModelProperty(value = "子商户号")
    public String subMchId ;

    @ApiModelProperty(value = "子商户公众账号 ID")
    public String subAppid ;

    @ApiModelProperty(value = "分账接收方类型")
    public String type ;

    @ApiModelProperty(value = "分账接收方帐号")
    public String account ;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
