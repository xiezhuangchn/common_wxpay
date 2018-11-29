package com.hnair.pay.common.models.dto.response.sharing;

import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("业务系统发起分账返回结果")
public class CreateSharingOrderResponse extends PayPlatformBaseResponse {

    @ApiModelProperty("订单号--业务系统订单号")
    private String busOrderNo;

    @ApiModelProperty("订单类型(订单系统传入,如微官网：01 酒店 02 商城 03 预售卷 04 限时请购)")
    private String orderType;

    @ApiModelProperty(value = "支付订单号")
    private String busPayNo;

    @ApiModelProperty(value = "商户分账单号")
    private String sharingOrderNo;

    @ApiModelProperty(value = "分账状态")
    private Integer sharingStatus;

    public Integer getSharingStatus() {
        return sharingStatus;
    }

    public void setSharingStatus(Integer sharingStatus) {
        this.sharingStatus = sharingStatus;
    }

    public String getBusPayNo() {
        return busPayNo;
    }

    public void setBusPayNo(String busPayNo) {
        this.busPayNo = busPayNo;
    }

    public String getSharingOrderNo() {
        return sharingOrderNo;
    }

    public void setSharingOrderNo(String sharingOrderNo) {
        this.sharingOrderNo = sharingOrderNo;
    }

    public String getBusOrderNo() {
        return busOrderNo;
    }

    public void setBusOrderNo(String busOrderNo) {
        this.busOrderNo = busOrderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
