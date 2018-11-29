package com.hnair.pay.common.models.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 所有外部请求入参
 */
@ApiModel("支付平台--统一入参")
public class PayPlatformBaseRequest implements Serializable {

    @ApiModelProperty(value = "接入产品线--支付系统需根据该产品线分配的key进行验签--接入支付的系统，需要到支付平台进行配置上线", required = true)
    @NotNull
    private String productAppId;

    @ApiModelProperty(value = "请求来源:01 微官网 --别的接入需要先到支付平台来定义", required = true)
    @NotBlank(message = "请求来源,不能为空")
    private String busChannel;

    @ApiModelProperty(value = "请求支付渠道（01:wx 02:apli）", required = true)
    @NotNull
    private String payChannelType;

    @ApiModelProperty(value = "请求支付平台的服务器IP", required = true)
    @NotNull
    private String serverIp;

    @ApiModelProperty(value = "请求时间戳")
    @NotNull
    private String timeStamp;

    @ApiModelProperty(value = "签名-(productAppId=''&busChannel=''&payChannelType=''&serverIp=''&timeStamp='',按照参数名ASCII码从小到大排序（字典序）)的MD5值", required = true)
    @NotNull
    private String sign;

    @ApiModelProperty(value = "数据JSON串", required = true)
    private String data;

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

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
