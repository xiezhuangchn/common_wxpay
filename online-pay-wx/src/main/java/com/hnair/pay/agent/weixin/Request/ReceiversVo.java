package com.hnair.pay.agent.weixin.Request;

/**
 * 分账方列表
 */
public class ReceiversVo {

    /**
     *分账接收方类型
     *MERCHANT_ID：商户 ID
     PERSONAL_WECHATID：个人微信号
     PERSONAL_OPENID：个人 openid（由父商
     户 APPID 转换得到）
     PERSONAL_SUB_OPENID: 个人
     sub_openid（由子商户 APPID 转换得到）
     */
    private String  type;

    /**
     *分账接收方帐号
     * 类型是 MERCHANT_ID 时，是商户 ID
     类型是 PERSONAL_WECHATID 时，是个人
     微信号
     类型是 PERSONAL_OPENID 时，是个人
     openid
     类型是 PERSONAL_SUB_OPENID 时，是个
     人 sub_openid
     */
    private String  account;

    /**
     * 分账金额
     * 分账金额，单位为分，只能为整数，不能超过原订单支付金额及最大分账比例金额
     */
    private Integer  amount;

    /**
     *  分账描述
     * 分账的原因描述，分账账单中需要体现
     */
    private String  description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
