package com.hnair.pay.common.models.dto.request.pay.wx;

import com.hnair.pay.common.models.dto.request.pay.BasePreCreateOrderRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel("微官网-微信支付-JSAPI-预创建订单")
public class CreateWechartWxJSAPIPayOrderRequest extends BasePreCreateOrderRequest {

    @ApiModelProperty(value = "openid--用户微信openid", required = true)
    @NotBlank(message = "openid--用户微信openid不能为空")
    private String openId;

    @ApiModelProperty(value = "子商户号", required = true)
    @NotBlank(message = "子商户号不能为空")
    private String subMchId;

    @ApiModelProperty(value = "子商户subAppId", required = true)
    @NotBlank(message = "子商户subAppId不能为空")
    private String subAppId;

    @ApiModelProperty(value = "酒店Id", required = true)
    @NotBlank(message = "酒店Id不能为空")
    private String hotelId;

    @ApiModelProperty(value = "终端IP支付提交用户端ip", required = true)
    @NotBlank(message = "终端IP支付提交用户端ip不能为空")
    private String spbillCreateIp;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }
}