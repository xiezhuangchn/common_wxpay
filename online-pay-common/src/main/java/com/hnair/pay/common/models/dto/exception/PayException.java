package com.hnair.pay.common.models.dto.exception;


import com.hnair.pay.common.models.dto.response.ErrorCode;

/**
 * 异常返回
 * bing.cheng
 */
public class PayException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PayException(String desc) {
        this.message = desc;
    }

    public PayException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public PayException(ErrorCode errorCode, String message) {
        this.code = errorCode.getCode();
        this.message = message;
    }

    public PayException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }
    /**
     * 类似日志类的入参实现
     *
     * @param format
     * @param arguments
     */
    public PayException(String format, Object... arguments) {
        setFormatMessage(format, arguments);
    }

    /**
     * 类似日志类的入参实现
     *
     * @param code
     * @param format
     * @param arguments
     */
    public PayException(String code, String format, Object... arguments) {
        this.code = code;
        setFormatMessage(format, arguments);
    }

    /**
     * @param errorCode
     * @param format
     * @param arguments
     */
    public PayException(ErrorCode errorCode, String format, Object... arguments) {
        this.code = errorCode.getCode();
        setFormatMessage(format, arguments);
    }

    /**
     * 设置格式化消息
     *
     * @param format
     * @param arguments
     */
    private void setFormatMessage(String format, Object... arguments) {
        if (null == format) {
            return;
        }
        if (null == arguments) {
            this.message = format;
            return;
        }
        String regex = "\\{}";
        String[] arry = format.split(regex);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arry.length; ++i) {
            if (i < arguments.length) {
                String tmp = arry[i] + String.valueOf(arguments[i]);
                sb.append(tmp);
            } else {
                sb.append(arry[i]);
            }
        }
        this.message = sb.toString();
    }


}
