package com.hnair.pay.common.enums;

/**
 * 订单渠道 01 微官网
 */
public enum OrderChannelEnum {

    ORDER_FROM_WECHART("01", "微官网");

    private String code;
    private String message;

    OrderChannelEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
