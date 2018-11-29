package com.hnair.pay.db.entity;

import java.io.Serializable;
import java.util.Date;

public class PayOrderLog implements Serializable {
    private Integer id;

    private Integer payOrderNo;

    private Integer refundOrderNo;

    private String busType;

    private String busOrderNo;

    private String context;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPayOrderNo() {
        return payOrderNo;
    }

    public void setPayOrderNo(Integer payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    public Integer getRefundOrderNo() {
        return refundOrderNo;
    }

    public void setRefundOrderNo(Integer refundOrderNo) {
        this.refundOrderNo = refundOrderNo;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType == null ? null : busType.trim();
    }

    public String getBusOrderNo() {
        return busOrderNo;
    }

    public void setBusOrderNo(String busOrderNo) {
        this.busOrderNo = busOrderNo == null ? null : busOrderNo.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", payOrderNo=").append(payOrderNo);
        sb.append(", refundOrderNo=").append(refundOrderNo);
        sb.append(", busType=").append(busType);
        sb.append(", busOrderNo=").append(busOrderNo);
        sb.append(", context=").append(context);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}