package com.hnair.pay.common.enums.pay;

/**
 * 支付订单-支付渠道
 */
public enum PayChannelTypeEnum {

    WX("01", "wx"),
    APLI("02", "apli");

    private String code;
    private String message;

     PayChannelTypeEnum(String code, String message) {
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
