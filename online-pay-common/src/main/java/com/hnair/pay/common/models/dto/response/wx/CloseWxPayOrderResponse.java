package com.hnair.pay.common.models.dto.response.wx;

import io.swagger.annotations.ApiModel;

@ApiModel("微信支付关闭订单-返回")
public class CloseWxPayOrderResponse {

    private String resultMsg;

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}