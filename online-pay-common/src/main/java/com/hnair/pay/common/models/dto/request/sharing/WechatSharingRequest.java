package com.hnair.pay.common.models.dto.request.sharing;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@ApiModel("微信分账请求")
public class WechatSharingRequest {

  @ApiModelProperty(value = "支付订单号", required = true)
  @NotBlank(message = "支付订单号，不允许为空")
  private String busPayNo;

  @ApiModelProperty(value = "商户分账单号(为null时,表示退款前调用分账接口)")
  private String sharingOrderNo;

  @ApiModelProperty(value = "分账接收方类型", required = true)
  @NotBlank(message = "分账接收方类型不能为空")
  private String sharingAccountType;

  @ApiModelProperty(value = "分账接收方账户", required = true)
  @NotBlank(message = "分账接收方账户不能为空")
  private String sharingAccount;

  @ApiModelProperty(value = "分账总金额（单位分）", required = true)
  private Integer sharingFee;

  @ApiModelProperty(value = "平台分账金额（单位分）", required = true)
  private Integer platformSharingFee;

  @ApiModelProperty(value = "其他分账金额（单位分）", required = true)
  private Integer otherSharingFee;

  @ApiModelProperty(value = "货币种类（默认人民币）", required = true)
  @NotBlank(message = "货币种类（默认人民币）")
  private String sharingFeeType;

  @ApiModelProperty(value = "分账描述", required = true)
  @NotBlank(message = "分账描述")
  private String sharingDesc;

  @ApiModelProperty(value = "分账类型", required = true)
  @NotNull
  private Integer sharingType;

  @ApiModelProperty("分账接收方集合(JSON串)")
  private String sharingReceivers;

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

  public Integer getSharingType() {
    return sharingType;
  }

  public void setSharingType(Integer sharingType) {
    this.sharingType = sharingType;
  }

  public String getSharingReceivers() {
    return sharingReceivers;
  }

  public void setSharingReceivers(String sharingReceivers) {
    this.sharingReceivers = sharingReceivers;
  }

  public String getBusPayNo() {
    return busPayNo;
  }

  public void setBusPayNo(String busPayNo) {
    this.busPayNo = busPayNo;
  }

  public String getSharingOrderNo() {
    return sharingOrderNo;
  }

  public void setSharingOrderNo(String sharingOrderNo) {
    this.sharingOrderNo = sharingOrderNo;
  }

  public String getSharingAccountType() {
    return sharingAccountType;
  }

  public void setSharingAccountType(String sharingAccountType) {
    this.sharingAccountType = sharingAccountType;
  }

  public String getSharingAccount() {
    return sharingAccount;
  }

  public void setSharingAccount(String sharingAccount) {
    this.sharingAccount = sharingAccount;
  }

  public Integer getSharingFee() {
    return sharingFee;
  }

  public void setSharingFee(Integer sharingFee) {
    this.sharingFee = sharingFee;
  }

  public String getSharingFeeType() {
    return sharingFeeType;
  }

  public void setSharingFeeType(String sharingFeeType) {
    this.sharingFeeType = sharingFeeType;
  }

  public String getSharingDesc() {
    return sharingDesc;
  }

  public void setSharingDesc(String sharingDesc) {
    this.sharingDesc = sharingDesc;
  }

}
