package com.hnair.pay.db.entity;

import java.io.Serializable;
import java.util.Date;

public class WithdrawOrder implements Serializable {
    private Long id;

    private String withdrawOrderNo;

    private String withdrawTradeNo;

    private String marketingPersonId;

    private Integer withdrawFee;

    private String feeType;

    private String busChannel;

    private String payChannelType;

    private Byte status;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWithdrawOrderNo() {
        return withdrawOrderNo;
    }

    public void setWithdrawOrderNo(String withdrawOrderNo) {
        this.withdrawOrderNo = withdrawOrderNo == null ? null : withdrawOrderNo.trim();
    }

    public String getWithdrawTradeNo() {
        return withdrawTradeNo;
    }

    public void setWithdrawTradeNo(String withdrawTradeNo) {
        this.withdrawTradeNo = withdrawTradeNo == null ? null : withdrawTradeNo.trim();
    }

    public String getMarketingPersonId() {
        return marketingPersonId;
    }

    public void setMarketingPersonId(String marketingPersonId) {
        this.marketingPersonId = marketingPersonId == null ? null : marketingPersonId.trim();
    }

    public Integer getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(Integer withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType == null ? null : feeType.trim();
    }

    public String getBusChannel() {
        return busChannel;
    }

    public void setBusChannel(String busChannel) {
        this.busChannel = busChannel == null ? null : busChannel.trim();
    }

    public String getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(String payChannelType) {
        this.payChannelType = payChannelType == null ? null : payChannelType.trim();
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
        sb.append(", withdrawOrderNo=").append(withdrawOrderNo);
        sb.append(", withdrawTradeNo=").append(withdrawTradeNo);
        sb.append(", marketingPersonId=").append(marketingPersonId);
        sb.append(", withdrawFee=").append(withdrawFee);
        sb.append(", feeType=").append(feeType);
        sb.append(", busChannel=").append(busChannel);
        sb.append(", payChannelType=").append(payChannelType);
        sb.append(", status=").append(status);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}