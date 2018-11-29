package com.hnair.pay.agent.weixin.Response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * 向微信用户个人发现金红包返回结果
 */

@XStreamAlias("xml")
public class WxPaySendRedpackResult extends BaseWxPayResult implements Serializable {
  private static final long serialVersionUID = -4837415036337132073L;

  @XStreamAlias("mch_billno")
  private String mchBillno;

  @XStreamAlias("wxappid")
  private String wxappid;

  @XStreamAlias("re_openid")
  private String reOpenid;

  @XStreamAlias("total_amount")
  private int totalAmount;

  @XStreamAlias("send_time")
  private String sendTime;

  @XStreamAlias("send_listid")
  private String sendListid;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getMchBillno() {
    return mchBillno;
  }

  public void setMchBillno(String mchBillno) {
    this.mchBillno = mchBillno;
  }

  public String getWxappid() {
    return wxappid;
  }

  public void setWxappid(String wxappid) {
    this.wxappid = wxappid;
  }

  public String getReOpenid() {
    return reOpenid;
  }

  public void setReOpenid(String reOpenid) {
    this.reOpenid = reOpenid;
  }

  public int getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(int totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getSendTime() {
    return sendTime;
  }

  public void setSendTime(String sendTime) {
    this.sendTime = sendTime;
  }

  public String getSendListid() {
    return sendListid;
  }

  public void setSendListid(String sendListid) {
    this.sendListid = sendListid;
  }
}
