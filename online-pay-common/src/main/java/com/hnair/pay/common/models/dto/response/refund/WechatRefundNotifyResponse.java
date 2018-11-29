package com.hnair.pay.common.models.dto.response.refund;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 下午4:07 2018/7/20
 */
@ApiModel("微信退款响应消息体")
public class WechatRefundNotifyResponse {

  @ApiModelProperty(value = "返回状态码")
  private String result_code;


  @ApiModelProperty(value = "当return_code为FAIL时返回信息为错误原因,例如签名失败")
  private String return_msg;


  @ApiModelProperty(value = "公众账号ID")
  private String appid;
  @ApiModelProperty(value = "商户号")

  private String mch_id;
  @ApiModelProperty(value = "随机字符串")

  private String nonce_str;
  @ApiModelProperty(value = "加密信息")
  private String req_info;


  public boolean result() {
    return result_code.toLowerCase().equals(ResultCode.SUCCESS.toLowerCase());
  }

  public static class RefundDetailInfo {

    @ApiModelProperty(value = "微信订单号")
    private String transaction_id;

    @ApiModelProperty(value = "微信退款单号")
    private String refund_id;


    @ApiModelProperty(value = "签名类型")

    private String sign_type;
    @ApiModelProperty(value = "商户订单号")

    private String out_trade_no;
    @ApiModelProperty(value = "商户退款单号")

    private String out_refund_no;

    @ApiModelProperty(value = "退款状态")
    private String refund_status;

    @ApiModelProperty(value = "退款时间")
    private String success_time;
  }

  /**
   * 业务结果代码.
   */
  public static class ResultCode {

    /**
     * 成功.
     */
    public static final String SUCCESS = "SUCCESS";

    /**
     * 失败.
     */
    public static final String FAIL = "FAIL";
  }


}
