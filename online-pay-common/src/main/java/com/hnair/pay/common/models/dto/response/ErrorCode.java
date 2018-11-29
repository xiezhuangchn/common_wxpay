package com.hnair.pay.common.models.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by bing.cheng on 2018/7/4.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    SUCCESS("0", "成功"),

    /**
     * 系统相关异常
     */
    ERR_SYSTEM("-1", "系统异常"),

    PARAM_ERROR("-2", "参数错误"),

    SIGN_ERROR("-3", "签名错误"),

    BIZ_ERROR("9999", "业务错误"),

    /**
     * 业务相关异常
     */
    ORDER_IS_NOT_EXST("100", "订单不存在"),
    ORDER_IS_PAY("101", "该订单已支付,请勿重复提交"),
    ORDER_IS_NO_PAY_SUCCESS_NO_SHARING("102", "订单并没有支付成功,不允许发生分账操作"),
    ORDER_SHARING_PRICE_LG_PAY_PRICE("103", "分账金额大于订单订单总支付金额"),
    ORDER_IS_MUTIL("104", "预下单失败，多个支付订单号"),

    CREATE_WX_SHARING_ORDER_FAIL("105", "创建微信分账订单失败"),
    PUSH_SHARING_RESULT_TO_ORDER_ERROR("106", "推送分账结果至order工程错误"),
    CALL_WX_CREATE_ORDER_FAIL("107", "调用微信预下单接口失败"),

    ORDER_IS_SHARING_DO_NOT_CALL("108", "该订单已分账,请勿重复发起"),

    PRE_ORDER_FAIL("109", "预下单失败"),

    REFUND_ORDER_IS_NOT_EXST("110", "退款订单不存在"),

    /**
     * 微信
     */
    REQUEST_WX_RESPONSE_ERROR("201", "调用微信接口,返回失败"),

    PAY_CHANNEL_NOT_SUPPORT("202", "支付渠道暂时不支持-请联系支付平台，例：orderFrom=01为微官网"),

    WX_PAY_TRADE_TYPE_NOT_SUPPORT("203", "微信支付方式不支持，传入例：微信：公证号支付 JSAPI")

    ;

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}