package com.hnair.pay.common.models.dto.request.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@ApiModel("微信预下单 统一入参")
public class BasePreCreateOrderRequest {

    @ApiModelProperty(value = "支付方式--不同的支付渠道传入不同的值，目前只支持微信公众号支付(微信：公证号支付 JSAPI)", required = true)
    @NotBlank(message = "payTradeType不能为空")
    private String payTradeType ;

    @ApiModelProperty(value = "订单号--业务系统订单号", required = true)
    @NotBlank(message = "订单号不能为空")
    private String orderId;

    @ApiModelProperty(value = "订单类型(订单系统的订单类型 业务系统可以自定义 但是必须规范传入）,如微官网：01 酒店 02 商城 03 预售卷 04 限时请购)", required = true)
    @NotBlank(message = "订单类型不能为空")
    private String orderType;

    @ApiModelProperty(value = "用户Id", required = true)
    private String userId;

    @ApiModelProperty(value = "商品名称", required = true)
    @NotNull
    private String goodsName;

    @ApiModelProperty(value = "商品描述", required = true)
    @NotNull
    private String goodsDes;

    @ApiModelProperty(value = "实际支付金额(单位为分)", required = true)
    @NotNull(message = "支付金额不能为空")
    private Integer payAmount;

    public String getPayTradeType() {
        return payTradeType;
    }

    public void setPayTradeType(String payTradeType) {
        this.payTradeType = payTradeType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDes() {
        return goodsDes;
    }

    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }
}
