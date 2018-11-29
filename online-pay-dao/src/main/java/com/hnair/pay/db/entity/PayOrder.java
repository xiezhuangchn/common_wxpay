package com.hnair.pay.db.entity;

import java.io.Serializable;
import java.util.Date;

public class PayOrder implements Serializable {
    private Integer id;

    private String busPayNo;

    private String prepayId;

    private String busOrderNo;

    private String busType;

    private Integer totalFee;

    private String tradePayNo;

    private String busChannel;

    private String feeType;

    private Byte tradeType;

    private Date paySuccessTime;

    private Byte payStatus;

    private String payChannelType;

    private String userId;

    private String wxOpenId;

    private String hotelId;

    private String subAppId;

    private String subMchId;

    private String isSharingOrder;

    private Byte sendStatus;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusPayNo() {
        return busPayNo;
    }

    public void setBusPayNo(String busPayNo) {
        this.busPayNo = busPayNo == null ? null : busPayNo.trim();
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId == null ? null : prepayId.trim();
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

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getTradePayNo() {
        return tradePayNo;
    }

    public void setTradePayNo(String tradePayNo) {
        this.tradePayNo = tradePayNo == null ? null : tradePayNo.trim();
    }

    public String getBusChannel() {
        return busChannel;
    }

    public void setBusChannel(String busChannel) {
        this.busChannel = busChannel == null ? null : busChannel.trim();
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType == null ? null : feeType.trim();
    }

    public Byte getTradeType() {
        return tradeType;
    }

    public void setTradeType(Byte tradeType) {
        this.tradeType = tradeType;
    }

    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(String payChannelType) {
        this.payChannelType = payChannelType == null ? null : payChannelType.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId == null ? null : hotelId.trim();
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId == null ? null : subAppId.trim();
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId == null ? null : subMchId.trim();
    }

    public String getIsSharingOrder() {
        return isSharingOrder;
    }

    public void setIsSharingOrder(String isSharingOrder) {
        this.isSharingOrder = isSharingOrder == null ? null : isSharingOrder.trim();
    }

    public Byte getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Byte sendStatus) {
        this.sendStatus = sendStatus;
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
        sb.append(", busPayNo=").append(busPayNo);
        sb.append(", prepayId=").append(prepayId);
        sb.append(", busOrderNo=").append(busOrderNo);
        sb.append(", busType=").append(busType);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", tradePayNo=").append(tradePayNo);
        sb.append(", busChannel=").append(busChannel);
        sb.append(", feeType=").append(feeType);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", paySuccessTime=").append(paySuccessTime);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payChannelType=").append(payChannelType);
        sb.append(", userId=").append(userId);
        sb.append(", wxOpenId=").append(wxOpenId);
        sb.append(", hotelId=").append(hotelId);
        sb.append(", subAppId=").append(subAppId);
        sb.append(", subMchId=").append(subMchId);
        sb.append(", isSharingOrder=").append(isSharingOrder);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}