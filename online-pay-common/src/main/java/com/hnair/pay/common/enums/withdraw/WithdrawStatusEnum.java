package com.hnair.pay.common.enums.withdraw;

/**
 * 提现表状态码
 */
public enum WithdrawStatusEnum {

    INIT(0, "初始化"),
    IN_HAND(1, "处理中"),
    SEND_ENTERPRISE_PAYMENT_SUCCESSFULLY(2, "发送企业付款成功"),
    SUCCESSFUL_PAYMENT(3, "企业付款成功"),
    FAIL(-1, "失败"),
            ;

    private Integer code;
    private String message;

     WithdrawStatusEnum(Integer code, String message) {
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
