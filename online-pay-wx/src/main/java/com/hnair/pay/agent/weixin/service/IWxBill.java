package com.hnair.pay.agent.weixin.service;

import com.hnair.pay.agent.weixin.Request.WxPayDownloadBillRequest;
import com.hnair.pay.agent.weixin.Response.WxPayBillResult;
import com.hnair.pay.agent.weixin.exception.WxPayException;

import java.io.IOException;

public interface IWxBill {

    /**
     *
     * @param request
     * @return
     * @throws WxPayException
     */
    WxPayBillResult downloadBill(WxPayDownloadBillRequest request) throws WxPayException, IOException;

}
