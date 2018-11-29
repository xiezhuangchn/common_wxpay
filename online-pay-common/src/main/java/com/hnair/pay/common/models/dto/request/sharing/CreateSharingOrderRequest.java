package com.hnair.pay.common.models.dto.request.sharing;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@ApiModel("业务系统发起分账请求")
public class CreateSharingOrderRequest {

  @ApiModelProperty(value = "酒店Id", required = true)
  @NotBlank(message = "hotelId")
  private String hotelId;

  @ApiModelProperty(value = "子商户号", required = true)
  @NotBlank(message = "subMchId")
  private String subMchId;

  @ApiModelProperty(value = "订单号--业务系统订单号", required = true)
  @NotBlank(message = "订单号不能为空")
  private String busOrderNo;

  @ApiModelProperty(value = "订单类型(订单系统传入,如微官网：01 酒店 02 商城 03 预售卷 04 限时请购)", required = true)
  @NotBlank(message = "订单类型不能为空")
  private String orderType;

  @ApiModelProperty(value = "支付订单号", required = true)
  @NotBlank(message = "支付订单号，不允许为空")
  private String busPayNo;

  @ApiModelProperty(value = "订单渠道( 01 微官网 )", required = true)
  @NotBlank(message = "订单渠道，不允许为空")
  private String busChannel;

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

  public String getBusChannel() {
    return busChannel;
  }

  public void setBusChannel(String busChannel) {
    this.busChannel = busChannel;
  }

  public String getHotelId() {
    return hotelId;
  }

  public void setHotelId(String hotelId) {
    this.hotelId = hotelId;
  }

  public String getBusOrderNo() {
    return busOrderNo;
  }

  public void setBusOrderNo(String busOrderNo) {
    this.busOrderNo = busOrderNo;
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

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  public String getBusPayNo() {
    return busPayNo;
  }

  public void setBusPayNo(String busPayNo) {
    this.busPayNo = busPayNo;
  }

  public String getSubMchId() {
    return subMchId;
  }

  public void setSubMchId(String subMchId) {
    this.subMchId = subMchId;
  }

}
