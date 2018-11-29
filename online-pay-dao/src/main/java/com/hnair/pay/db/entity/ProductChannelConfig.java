package com.hnair.pay.db.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductChannelConfig implements Serializable {
    private Integer id;

    private String productAppId;

    private String busChannel;

    private String signKey;

    private String payNotifyUrl;

    private String refundNotifyUrl;

    private String sharingNotifyUrl;

    private String huiduPayNotifyUrl;

    private String huiduRefundNotifyUrl;

    private String huiduSharingNotifyUrl;

    private String operatorId;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductAppId() {
        return productAppId;
    }

    public void setProductAppId(String productAppId) {
        this.productAppId = productAppId == null ? null : productAppId.trim();
    }

    public String getBusChannel() {
        return busChannel;
    }

    public void setBusChannel(String busChannel) {
        this.busChannel = busChannel == null ? null : busChannel.trim();
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey == null ? null : signKey.trim();
    }

    public String getPayNotifyUrl() {
        return payNotifyUrl;
    }

    public void setPayNotifyUrl(String payNotifyUrl) {
        this.payNotifyUrl = payNotifyUrl == null ? null : payNotifyUrl.trim();
    }

    public String getRefundNotifyUrl() {
        return refundNotifyUrl;
    }

    public void setRefundNotifyUrl(String refundNotifyUrl) {
        this.refundNotifyUrl = refundNotifyUrl == null ? null : refundNotifyUrl.trim();
    }

    public String getSharingNotifyUrl() {
        return sharingNotifyUrl;
    }

    public void setSharingNotifyUrl(String sharingNotifyUrl) {
        this.sharingNotifyUrl = sharingNotifyUrl == null ? null : sharingNotifyUrl.trim();
    }

    public String getHuiduPayNotifyUrl() {
        return huiduPayNotifyUrl;
    }

    public void setHuiduPayNotifyUrl(String huiduPayNotifyUrl) {
        this.huiduPayNotifyUrl = huiduPayNotifyUrl == null ? null : huiduPayNotifyUrl.trim();
    }

    public String getHuiduRefundNotifyUrl() {
        return huiduRefundNotifyUrl;
    }

    public void setHuiduRefundNotifyUrl(String huiduRefundNotifyUrl) {
        this.huiduRefundNotifyUrl = huiduRefundNotifyUrl == null ? null : huiduRefundNotifyUrl.trim();
    }

    public String getHuiduSharingNotifyUrl() {
        return huiduSharingNotifyUrl;
    }

    public void setHuiduSharingNotifyUrl(String huiduSharingNotifyUrl) {
        this.huiduSharingNotifyUrl = huiduSharingNotifyUrl == null ? null : huiduSharingNotifyUrl.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
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
        sb.append(", productAppId=").append(productAppId);
        sb.append(", busChannel=").append(busChannel);
        sb.append(", signKey=").append(signKey);
        sb.append(", payNotifyUrl=").append(payNotifyUrl);
        sb.append(", refundNotifyUrl=").append(refundNotifyUrl);
        sb.append(", sharingNotifyUrl=").append(sharingNotifyUrl);
        sb.append(", huiduPayNotifyUrl=").append(huiduPayNotifyUrl);
        sb.append(", huiduRefundNotifyUrl=").append(huiduRefundNotifyUrl);
        sb.append(", huiduSharingNotifyUrl=").append(huiduSharingNotifyUrl);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}