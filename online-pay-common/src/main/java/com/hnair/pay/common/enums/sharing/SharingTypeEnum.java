package com.hnair.pay.common.enums.sharing;

/**
 * 分账类型
 */
public enum SharingTypeEnum {

    NO_MARKETING_SHARING(0, "无人员营销,直接平台抽成分账"),
    HAVE_MARKETING_SHARING_THAN_REMITTANCE(1, "有人员营销,先(平台抽成+营销奖励金)分账,再企业微信打款给营销人员"),
    HAVE_MARKETING_AUTO_SHARING(2, "有人员营销,直接全部自动分账"),
            ;

    private Integer code;
    private String message;

     SharingTypeEnum(Integer code, String message) {
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
