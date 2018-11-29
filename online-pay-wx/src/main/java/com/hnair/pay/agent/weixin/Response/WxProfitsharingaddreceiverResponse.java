package com.hnair.pay.agent.weixin.Response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 分账关系绑定返回值
 */
@XStreamAlias("xml")
public class WxProfitsharingaddreceiverResponse extends BaseWxPayResult{

    private String receiver;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
