package com.hnair.pay.common.models.dto.response.wx;

import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询微信企业付款订单-返回")
public class QueryWxEntPayOrderResponse extends PayPlatformBaseResponse {

    @ApiModelProperty(value = "创建结果 true 成功 false 失败")
    private Boolean status;
    @ApiModelProperty(value = "错误信息")
    private String errorMsg;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}