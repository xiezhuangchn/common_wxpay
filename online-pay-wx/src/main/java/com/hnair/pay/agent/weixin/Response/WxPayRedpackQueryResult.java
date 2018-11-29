package com.hnair.pay.agent.weixin.Response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *     回调
 * </pre>
 *
 */
@XStreamAlias("xml")
public class WxPayRedpackQueryResult extends BaseWxPayResult {
  private static final long serialVersionUID = -3849864122189552906L;

  /**
   * <pre>
   * 字段含义：商户订单号.
   * 字段名：mch_billno
   * 是否必填：是
   * 示例值：10000098201411111234567890
   * 类型：String(28)
   * 字段说明：商户使用查询API填写的商户单号的原路返回
   * </pre>
   */
  @XStreamAlias("mch_billno")
  private String mchBillNo;

  /**
   * <pre>
   * 字段含义：红包单号.
   * 字段名：detail_id
   * 是否必填：是
   * 示例值：1000000000201503283103439304
   * 类型：String(32)
   * 字段说明：使用API发放现金红包时返回的红包单号
   * </pre>
   */
  @XStreamAlias("detail_id")
  private String detailId;

  /**
   * <pre>
   * 字段含义：红包状态.
   * 字段名：status
   * 是否必填：是
   * 示例值：RECEIVED
   * 类型：string(16)
   * 字段说明：SENDING:发放中，
   * SENT:已发放待领取，
   * FAILED：发放失败，
   * RECEIVED:已领取，
   * RFUND_ING:退款中，
   * REFUND:已退款
   * </pre>
   */
  @XStreamAlias("status")
  private String status;

  /**
   * <pre>
   * 字段含义：发放类型.
   * 字段名：send_type
   * 是否必填：是
   * 示例值：API
   * 类型：String(32)
   * 字段说明：API:通过API接口发放，
   *  UPLOAD:通过上传文件方式发放，
   *  ACTIVITY:通过活动方式发放
   * </pre>
   */
  @XStreamAlias("send_type")
  private String sendType;

  /**
   * <pre>
   * 字段含义：红包类型.
   * 字段名：hb_type
   * 是否必填：是
   * 示例值：GROUP
   * 类型：String(32)
   * 字段说明：GROUP:裂变红包，
   *  NORMAL:普通红包
   * </pre>
   */
  @XStreamAlias("hb_type")
  private String hbType;

  /**
   * <pre>
   * 字段含义：红包个数.
   * 字段名：total_num
   * 是否必填：是
   * 示例值：1
   * 类型：int
   * 字段说明：红包个数
   * </pre>
   */
  @XStreamAlias("total_num")
  private Integer totalNum;

  /**
   * <pre>
   * 字段含义：红包金额.
   * 字段名：total_amount
   * 是否必填：是
   * 示例值：5000
   * 类型：int
   * 字段说明：红包总金额（单位分）
   * </pre>
   */
  @XStreamAlias("total_amount")
  private Integer totalAmount;

  /**
   * <pre>
   * 字段含义：失败原因.
   * 字段名：reason
   * 是否必填：否
   * 示例值：余额不足
   * 类型：String(32)
   * 字段说明：发送失败原因
   * </pre>
   */
  @XStreamAlias("reason")
  private String reason;

  /**
   * <pre>
   * 字段含义：红包发送时间.
   * 字段名：send_time
   * 是否必填：是
   * 示例值：2015-04-21 20:00:00
   * 类型：String(32)
   * 字段说明：红包的发送时间
   * </pre>
   */
  @XStreamAlias("send_time")
  private String sendTime;

  /**
   * <pre>
   * 字段含义：红包退款时间.
   * 字段名： refund_time
   * 是否必填：否
   * 示例值：2015-04-21 23:03:00
   * 类型：String(32)
   * 字段说明：红包的退款时间（如果其未领取的退款）
   * </pre>
   */
  @XStreamAlias("refund_time")
  private String refundTime;

  /**
   * <pre>
   * 字段含义：红包退款金额.
   * 字段名：refund_amount
   * 是否必填：否
   * 示例值：8000
   * 类型：Int
   * 字段说明：红包退款金额
   * </pre>
   */
  @XStreamAlias("refund_amount")
  private Integer refundAmount;

  /**
   * <pre>
   * 字段含义：祝福语.
   * 字段名：wishing
   * 是否必填：否
   * 示例值：新年快乐
   * 类型：String(128)
   * 字段说明：祝福语
   * </pre>
   */
  @XStreamAlias("wishing")
  private String wishing;

  /**
   * <pre>
   * 字段含义：活动描述.
   * 字段名：remark
   * 是否必填：否
   * 示例值：新年红包
   * 类型：String(256)
   * 字段说明：活动描述，低版本微信可见
   * </pre>
   */
  @XStreamAlias("remark")
  private String remark;

  /**
   * <pre>
   * 字段含义：活动名称.
   * 字段名：act_name
   * 是否必填：否
   * 示例值：新年红包
   * 类型：String(32)
   * 字段说明：发红包的活动名称
   * </pre>
   */
  @XStreamAlias("act_name")
  private String actName;

  /**
   * <pre>
   * 字段含义：裂变红包领取列表.
   * 字段名：redpackList
   * 是否必填：否
   * 字段说明： 裂变红包的领取列表
   * </pre>
   */
  @XStreamAlias("hblist")
  private List<RedpackInfo> redpackList;

  @XStreamAlias("hbinfo")
  public static class RedpackInfo implements Serializable {
    private static final long serialVersionUID = 7829773321457772100L;
    /**
     * <pre>
     * 字段含义：领取红包的Openid.
     * 字段名： openid
     * 是否必填：是
     * 示例值：ohO4GtzOAAYMp2yapORH3dQB3W18
     * 类型：String(32)
     * 字段说明：领取红包的openid
     * </pre>
     */
    @XStreamAlias("openid")
    private String openid;

    /**
     * <pre>
     * 字段含义：金额.
     * 字段名： amount
     * 是否必填：是
     * 示例值：100
     * 类型：int
     * 字段说明：领取金额
     * </pre>
     */
    @XStreamAlias("amount")
    private Integer amount;

    /**
     * <pre>
     * 字段含义：接收时间.
     * 字段名： rcv_time
     * 是否必填：是
     * 示例值：2015-04-21 20:00:00
     * 类型：String(32)
     * 字段说明：领取红包的时间
     * </pre>
     */
    @XStreamAlias("rcv_time")
    private String receiveTime;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getMchBillNo() {
    return mchBillNo;
  }

  public void setMchBillNo(String mchBillNo) {
    this.mchBillNo = mchBillNo;
  }

  public String getDetailId() {
    return detailId;
  }

  public void setDetailId(String detailId) {
    this.detailId = detailId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getSendType() {
    return sendType;
  }

  public void setSendType(String sendType) {
    this.sendType = sendType;
  }

  public String getHbType() {
    return hbType;
  }

  public void setHbType(String hbType) {
    this.hbType = hbType;
  }

  public Integer getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(Integer totalNum) {
    this.totalNum = totalNum;
  }

  public Integer getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getSendTime() {
    return sendTime;
  }

  public void setSendTime(String sendTime) {
    this.sendTime = sendTime;
  }

  public String getRefundTime() {
    return refundTime;
  }

  public void setRefundTime(String refundTime) {
    this.refundTime = refundTime;
  }

  public Integer getRefundAmount() {
    return refundAmount;
  }

  public void setRefundAmount(Integer refundAmount) {
    this.refundAmount = refundAmount;
  }

  public String getWishing() {
    return wishing;
  }

  public void setWishing(String wishing) {
    this.wishing = wishing;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getActName() {
    return actName;
  }

  public void setActName(String actName) {
    this.actName = actName;
  }

  public List<RedpackInfo> getRedpackList() {
    return redpackList;
  }

  public void setRedpackList(List<RedpackInfo> redpackList) {
    this.redpackList = redpackList;
  }
}
