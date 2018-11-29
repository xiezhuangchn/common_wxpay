package com.hnair.pay.common.models.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 支付平台统一返回参数设置
 */
@ApiModel("支付平台统一返回参数设置")
public class PayPlatformBaseResponse implements Serializable {

    @ApiModelProperty(value = "接入产品线--支付系统需根据该产品线分配的key进行验签--接入支付的系统，需要到支付平台进行配置上线", required = true)
    @NotNull
    private String productAppId;

    @ApiModelProperty(value = "请求来源:01 微官网 --别的接入需要先到支付平台来定义", required = true)
    @NotBlank(message = "orderFrom")
    private String busChannel;

    @ApiModelProperty(value = "请求支付渠道（01:wx 02:apli）", required = true)
    @NotNull
    private String payChannelType;

    @ApiModelProperty(value = "支付平台的服务器IP", required = true)
    @NotNull
    private String serverIp;

    @ApiModelProperty(value = "响应时间戳单位毫秒")
    @NotNull
    private String resTimeStamp;

    @ApiModelProperty(value = "签名-productLineKey的MD5值", required = true)
    @NotNull
    private String sign;

    public String getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(String payChannelType) {
        this.payChannelType = payChannelType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getResTimeStamp() {
        return resTimeStamp;
    }

    public void setResTimeStamp(String resTimeStamp) {
        this.resTimeStamp = resTimeStamp;
    }

    public String getProductAppId() {
        return productAppId;
    }

    public void setProductAppId(String productAppId) {
        this.productAppId = productAppId;
    }

    public String getBusChannel() {
        return busChannel;
    }

    public void setBusChannel(String busChannel) {
        this.busChannel = busChannel;
    }
}
