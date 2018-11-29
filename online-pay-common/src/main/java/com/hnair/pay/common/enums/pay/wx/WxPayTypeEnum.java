package com.hnair.pay.common.enums.pay.wx;

/**
 *微信支付类型
 */
public enum WxPayTypeEnum {

    JSAPI(1, "公众号支付"),
    NATIVE(2, "原生扫码支付"),
    APP(3, "App支付");

    private Integer code;
    private String message;

     WxPayTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
