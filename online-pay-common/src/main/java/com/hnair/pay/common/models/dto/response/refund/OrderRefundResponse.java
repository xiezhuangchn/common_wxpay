package com.hnair.pay.common.models.dto.response.refund;

import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("微信信息保存退款响应消息体")
public class OrderRefundResponse extends PayPlatformBaseResponse {

  @ApiModelProperty(value = "退款这状态")
  private Integer refundStatus = 0;

  @ApiModelProperty(value = "退款唯一流水号")
  private String refundOrderNo;

  public Integer getRefundStatus() {
    return refundStatus;
  }

  public void setRefundStatus(Integer refundStatus) {
    this.refundStatus = refundStatus;
  }

  public String getRefundOrderNo() {
    return refundOrderNo;
  }

  public void setRefundOrderNo(String refundOrderNo) {
    this.refundOrderNo = refundOrderNo;
  }
}
