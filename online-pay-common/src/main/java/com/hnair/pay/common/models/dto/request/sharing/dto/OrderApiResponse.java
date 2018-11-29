package com.hnair.pay.common.models.dto.request.sharing.dto;


import com.fasterxml.jackson.databind.JsonNode;

/**
 * order的标准返回
 */
public class OrderApiResponse {

    private String status;

    private JsonNode data;

    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JsonNode getData() {
        return data;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
