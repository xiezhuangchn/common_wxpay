package com.hnair.pay.db.entity;

import java.io.Serializable;
import java.util.Date;

public class RefundOrder implements Serializable {
    private Integer id;

    private String refundOrderNo;

    private String refundTradeNo;

    private String busPayNo;

    private String busChannel;

    private String busOrderNo;

    private String busType;

    private String tradePayNo;

    private Long totalFee;

    private Long refundFee;

    private String refundFeeType;

    private Date refundTime;

    private String refundReason;

    private Integer refundStatus;

    private Integer num;

    private String opUserId;

    private String subMchId;

    private Date updateTime;

    private Date createTime;

    private Byte callOrderStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRefundOrderNo() {
        return refundOrderNo;
    }

    public void setRefundOrderNo(String refundOrderNo) {
        this.refundOrderNo = refundOrderNo == null ? null : refundOrderNo.trim();
    }

    public String getRefundTradeNo() {
        return refundTradeNo;
    }

    public void setRefundTradeNo(String refundTradeNo) {
        this.refundTradeNo = refundTradeNo == null ? null : refundTradeNo.trim();
    }

    public String getBusPayNo() {
        return busPayNo;
    }

    public void setBusPayNo(String busPayNo) {
        this.busPayNo = busPayNo == null ? null : busPayNo.trim();
    }

    public String getBusChannel() {
        return busChannel;
    }

    public void setBusChannel(String busChannel) {
        this.busChannel = busChannel == null ? null : busChannel.trim();
    }

    public String getBusOrderNo() {
        return busOrderNo;
    }

    public void setBusOrderNo(String busOrderNo) {
        this.busOrderNo = busOrderNo == null ? null : busOrderNo.trim();
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType == null ? null : busType.trim();
    }

    public String getTradePayNo() {
        return tradePayNo;
    }

    public void setTradePayNo(String tradePayNo) {
        this.tradePayNo = tradePayNo == null ? null : tradePayNo.trim();
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public Long getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Long refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundFeeType() {
        return refundFeeType;
    }

    public void setRefundFeeType(String refundFeeType) {
        this.refundFeeType = refundFeeType == null ? null : refundFeeType.trim();
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason == null ? null : refundReason.trim();
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(String opUserId) {
        this.opUserId = opUserId == null ? null : opUserId.trim();
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId == null ? null : subMchId.trim();
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

    public Byte getCallOrderStatus() {
        return callOrderStatus;
    }

    public void setCallOrderStatus(Byte callOrderStatus) {
        this.callOrderStatus = callOrderStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", refundOrderNo=").append(refundOrderNo);
        sb.append(", refundTradeNo=").append(refundTradeNo);
        sb.append(", busPayNo=").append(busPayNo);
        sb.append(", busChannel=").append(busChannel);
        sb.append(", busOrderNo=").append(busOrderNo);
        sb.append(", busType=").append(busType);
        sb.append(", tradePayNo=").append(tradePayNo);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", refundFee=").append(refundFee);
        sb.append(", refundFeeType=").append(refundFeeType);
        sb.append(", refundTime=").append(refundTime);
        sb.append(", refundReason=").append(refundReason);
        sb.append(", refundStatus=").append(refundStatus);
        sb.append(", num=").append(num);
        sb.append(", opUserId=").append(opUserId);
        sb.append(", subMchId=").append(subMchId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", callOrderStatus=").append(callOrderStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}