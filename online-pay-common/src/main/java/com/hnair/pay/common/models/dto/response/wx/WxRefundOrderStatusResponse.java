package com.hnair.pay.common.models.dto.response.wx;

import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("微信退款订单状态返回")
public class WxRefundOrderStatusResponse extends PayPlatformBaseResponse {

  @ApiModelProperty(value = "微信返回的xml信息")
  private String xml;

  @ApiModelProperty(value = "微信返回的xml信息")
  private String resultJson;

  public String getXml() {
    return xml;
  }

  public void setXml(String xml) {
    this.xml = xml;
  }

  public String getResultJson() {
    return resultJson;
  }

  public void setResultJson(String resultJson) {
    this.resultJson = resultJson;
  }
}
