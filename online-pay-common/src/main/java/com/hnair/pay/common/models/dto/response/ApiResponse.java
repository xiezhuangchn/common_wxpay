package com.hnair.pay.common.models.dto.response;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.models.dto.exception.PayException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  Created by bing.cheng on 2018/7/4.
 * @param <T>
 */
@ApiModel("接口响应")
public class ApiResponse<T> {

    @ApiModelProperty("状态")
    private String status = ErrorCode.SUCCESS.getCode();

    @ApiModelProperty("数据")
    private T data;

    @ApiModelProperty("错误信息")
    private String msg;

    public ApiResponse() {

    }

    public static <T> ApiResponse<T> paramfail(String msg) {
        ApiResponse response = new ApiResponse();
        response.setStatus(ErrorCode.PARAM_ERROR.getCode());
        response.setMsg(ErrorCode.PARAM_ERROR.getMsg() + msg);
        return response;
    }

    public ApiResponse(String status, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = null;
    }

    public ApiResponse(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiResponse<T> createBusFailRespons(Exception e) {
        if (e instanceof PayException) {
            return ApiResponse.busFail(((PayException) e).getCode(), e.getMessage());
        }
        return ApiResponse.fail(ErrorCode.ERR_SYSTEM, e.getMessage());
    }

    public String getStatus() {
        return status;
    }

    public ApiResponse<T> setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ApiResponse<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ApiResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> ApiResponse<T> success(T t) {
        ApiResponse<T> response = new ApiResponse<T>();
        response.setData(t);
        response.setMsg("SUCCESS");
        return response;
    }

    public static <T> ApiResponse<T> fail(String msg) {
        ApiResponse response = new ApiResponse();
        response.setStatus(ErrorCode.BIZ_ERROR.getCode());
        response.setMsg(msg);
        return response;
    }

    public static <T> ApiResponse<T> fail(String format, Object... arguments) {
        ApiResponse response = new ApiResponse();
        response.setStatus(ErrorCode.BIZ_ERROR.getCode());
        response.setMsg(setFormatMsg(format, arguments));
        return response;
    }

    public static <T> ApiResponse<T> fail(ErrorCode code) {
        ApiResponse response = new ApiResponse();
        response.setStatus(code.getCode());
        response.setMsg(code.getMsg());
        return response;
    }

    public static <T> ApiResponse<T> busFail(String code, String msg) {
        ApiResponse response = new ApiResponse();
        response.setStatus(code);
        response.setMsg(msg);
        return response;
    }

    public static <T> ApiResponse<T> fail(ErrorCode code, String msg) {
        ApiResponse response = new ApiResponse();
        response.setStatus(code.getCode());
        response.setMsg(msg);
        return response;
    }

    public static <T> ApiResponse<T> fail(ErrorCode code, String format, Object... arguments) {
        ApiResponse response = new ApiResponse();
        response.setStatus(code.getCode());
        response.setMsg(setFormatMsg(format, arguments));
        return response;
    }

    public static ApiResponse exception(String msg) {
        ApiResponse response = new ApiResponse();
        response.setStatus(ErrorCode.BIZ_ERROR.getCode());
        response.setMsg(msg);
        return response;
    }

    /**
     * 格式化消息
     *
     * @param format
     * @param arguments
     * @return
     */
    private static String setFormatMsg(String format, Object... arguments) {
        if (null == format) {
            return null;
        }
        if (null == arguments) {
            return format;
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

        return sb.toString();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
