package com.hnair.pay.common.models.dto.response.wx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 上午11:44 2018/7/27
 */
@ApiModel("微信订单状态返回")
public class WxOrderStatusResponse {

  @ApiModelProperty(value = "支付平台状态名称")
  private String plat_status_name;
  @ApiModelProperty(value = "支付平台状态码")
  private int plat_status_code;

  @ApiModelProperty(value = "微信平台状态名称")
  private String wx_status_name;

  @ApiModelProperty(value = "微信返回的xml信息")

  private String xml;


  public String getPlat_status_name() {
    return plat_status_name;
  }

  public void setPlat_status_name(String plat_status_name) {
    this.plat_status_name = plat_status_name;
  }

  public int getPlat_status_code() {
    return plat_status_code;
  }

  public void setPlat_status_code(int plat_status_code) {
    this.plat_status_code = plat_status_code;
  }

  public String getWx_status_name() {
    return wx_status_name;
  }

  public void setWx_status_name(String wx_status_name) {
    this.wx_status_name = wx_status_name;
  }


  public String getXml() {
    return xml;
  }

  public void setXml(String xml) {
    this.xml = xml;
  }
}
