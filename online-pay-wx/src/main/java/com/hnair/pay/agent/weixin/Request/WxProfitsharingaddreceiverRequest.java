package com.hnair.pay.agent.weixin.Request;

import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class WxProfitsharingaddreceiverRequest extends BaseWxPayRequest{
    @Override
    protected void checkConstraints() throws WxPayException { }

    public String sub_mch_id ;//是 string(32) 1900000109 微信支付分配的子商户号   子商户号

    private String sub_appid;

    private String receiver;

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
