package com.hnair.pay.agent.weixin.Response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <pre>
 * 关闭订单结果对象类
 * Created by Binary Wang on 2016-10-27.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@XStreamAlias("xml")
public class WxPayOrderCloseResult extends BaseWxPayResult {

  /**
   * 业务结果描述
   */
  @XStreamAlias("result_msg")
  private String resultMsg;

  public String getResultMsg() {
    return resultMsg;
  }

  public void setResultMsg(String resultMsg) {
    this.resultMsg = resultMsg;
  }
}
