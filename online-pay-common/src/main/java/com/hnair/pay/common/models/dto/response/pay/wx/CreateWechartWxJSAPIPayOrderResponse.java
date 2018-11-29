package com.hnair.pay.common.models.dto.response.pay.wx;

import com.hnair.pay.common.models.dto.response.pay.BasePreCreateOrderResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("微信JSAPI支付-预创建订单-返回")
public class CreateWechartWxJSAPIPayOrderResponse extends BasePreCreateOrderResponse {

    @ApiModelProperty(value = "商户注册具有支付权限的公众号成功后即可获得")
    private String appId;

    @ApiModelProperty(value = "随机字符串，不长于32位")
    private String nonceStr;

    @ApiModelProperty(value = "统一下单接口返回的prepay_id参数值，提交格式如：prepay_id=***")
    private String packageValue;

    @ApiModelProperty(value = "微信签名类型，默认为MD5，支持HMAC-SHA256和MD5。注意此处需与统一下单的签名类型一致")
    private String signType;

    @ApiModelProperty(value = "签名")
    private String paySign;

    @ApiModelProperty(value = "响应时间戳")
    private String timeStamp;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}