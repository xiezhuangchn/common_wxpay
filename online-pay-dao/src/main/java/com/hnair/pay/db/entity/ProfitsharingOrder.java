package com.hnair.pay.db.entity;

import java.io.Serializable;
import java.util.Date;

public class ProfitsharingOrder implements Serializable {
    private Integer id;

    private String sharingOrderNo;

    private String sharingTradeNo;

    private String busPayNo;

    private String busChannel;

    private String busOrderNo;

    private String busType;

    private String tradePayNo;

    private Integer totalFee;

    private String sharingAccountType;

    private String sharingAccount;

    private Integer sharingFee;

    private Integer platformSharingFee;

    private Integer otherSharingFee;

    private String sharingFeeType;

    private String sharingDesc;

    private Date sharingSendTime;

    private Date sharingSuccessTime;

    private String failureReason;

    private String hotelId;

    private String subMchId;

    private String opUserId;

    private Byte sharingStatus;

    private Byte sendStatus;

    private Integer num;

    private Date updateTime;

    private Date createTime;

    private Byte sharingType;

    private String sharingReceivers;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSharingOrderNo() {
        return sharingOrderNo;
    }

    public void setSharingOrderNo(String sharingOrderNo) {
        this.sharingOrderNo = sharingOrderNo == null ? null : sharingOrderNo.trim();
    }

    public String getSharingTradeNo() {
        return sharingTradeNo;
    }

    public void setSharingTradeNo(String sharingTradeNo) {
        this.sharingTradeNo = sharingTradeNo == null ? null : sharingTradeNo.trim();
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

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getSharingAccountType() {
        return sharingAccountType;
    }

    public void setSharingAccountType(String sharingAccountType) {
        this.sharingAccountType = sharingAccountType == null ? null : sharingAccountType.trim();
    }

    public String getSharingAccount() {
        return sharingAccount;
    }

    public void setSharingAccount(String sharingAccount) {
        this.sharingAccount = sharingAccount == null ? null : sharingAccount.trim();
    }

    public Integer getSharingFee() {
        return sharingFee;
    }

    public void setSharingFee(Integer sharingFee) {
        this.sharingFee = sharingFee;
    }

    public Integer getPlatformSharingFee() {
        return platformSharingFee;
    }

    public void setPlatformSharingFee(Integer platformSharingFee) {
        this.platformSharingFee = platformSharingFee;
    }

    public Integer getOtherSharingFee() {
        return otherSharingFee;
    }

    public void setOtherSharingFee(Integer otherSharingFee) {
        this.otherSharingFee = otherSharingFee;
    }

    public String getSharingFeeType() {
        return sharingFeeType;
    }

    public void setSharingFeeType(String sharingFeeType) {
        this.sharingFeeType = sharingFeeType == null ? null : sharingFeeType.trim();
    }

    public String getSharingDesc() {
        return sharingDesc;
    }

    public void setSharingDesc(String sharingDesc) {
        this.sharingDesc = sharingDesc == null ? null : sharingDesc.trim();
    }

    public Date getSharingSendTime() {
        return sharingSendTime;
    }

    public void setSharingSendTime(Date sharingSendTime) {
        this.sharingSendTime = sharingSendTime;
    }

    public Date getSharingSuccessTime() {
        return sharingSuccessTime;
    }

    public void setSharingSuccessTime(Date sharingSuccessTime) {
        this.sharingSuccessTime = sharingSuccessTime;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason == null ? null : failureReason.trim();
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId == null ? null : hotelId.trim();
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId == null ? null : subMchId.trim();
    }

    public String getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(String opUserId) {
        this.opUserId = opUserId == null ? null : opUserId.trim();
    }

    public Byte getSharingStatus() {
        return sharingStatus;
    }

    public void setSharingStatus(Byte sharingStatus) {
        this.sharingStatus = sharingStatus;
    }

    public Byte getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Byte sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public Byte getSharingType() {
        return sharingType;
    }

    public void setSharingType(Byte sharingType) {
        this.sharingType = sharingType;
    }

    public String getSharingReceivers() {
        return sharingReceivers;
    }

    public void setSharingReceivers(String sharingReceivers) {
        this.sharingReceivers = sharingReceivers == null ? null : sharingReceivers.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sharingOrderNo=").append(sharingOrderNo);
        sb.append(", sharingTradeNo=").append(sharingTradeNo);
        sb.append(", busPayNo=").append(busPayNo);
        sb.append(", busChannel=").append(busChannel);
        sb.append(", busOrderNo=").append(busOrderNo);
        sb.append(", busType=").append(busType);
        sb.append(", tradePayNo=").append(tradePayNo);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", sharingAccountType=").append(sharingAccountType);
        sb.append(", sharingAccount=").append(sharingAccount);
        sb.append(", sharingFee=").append(sharingFee);
        sb.append(", platformSharingFee=").append(platformSharingFee);
        sb.append(", otherSharingFee=").append(otherSharingFee);
        sb.append(", sharingFeeType=").append(sharingFeeType);
        sb.append(", sharingDesc=").append(sharingDesc);
        sb.append(", sharingSendTime=").append(sharingSendTime);
        sb.append(", sharingSuccessTime=").append(sharingSuccessTime);
        sb.append(", failureReason=").append(failureReason);
        sb.append(", hotelId=").append(hotelId);
        sb.append(", subMchId=").append(subMchId);
        sb.append(", opUserId=").append(opUserId);
        sb.append(", sharingStatus=").append(sharingStatus);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", num=").append(num);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", sharingType=").append(sharingType);
        sb.append(", sharingReceivers=").append(sharingReceivers);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}