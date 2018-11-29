package com.hnair.pay.common.enums;

public enum EnvConfigEnum {

    HUIDU("huidu", "灰度环境");

    private String code;
    private String message;

    EnvConfigEnum(String code, String message) {
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
