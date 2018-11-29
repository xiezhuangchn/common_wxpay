package com.hnair.pay.db.entity;

import java.io.Serializable;
import java.util.Date;

public class SharingBindingInfo implements Serializable {
    private Integer id;

    private String hotelMchId;

    private String receiverMchId;

    private String operatorId;

    private Byte status;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelMchId() {
        return hotelMchId;
    }

    public void setHotelMchId(String hotelMchId) {
        this.hotelMchId = hotelMchId == null ? null : hotelMchId.trim();
    }

    public String getReceiverMchId() {
        return receiverMchId;
    }

    public void setReceiverMchId(String receiverMchId) {
        this.receiverMchId = receiverMchId == null ? null : receiverMchId.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        sb.append(", hotelMchId=").append(hotelMchId);
        sb.append(", receiverMchId=").append(receiverMchId);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", status=").append(status);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}