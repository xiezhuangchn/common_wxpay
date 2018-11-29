package com.hnair.pay.agent.weixin.service.impl;

import com.hnair.pay.agent.weixin.Request.WxPayDownloadBillRequest;
import com.hnair.pay.agent.weixin.Response.WxPayBillResult;
import com.hnair.pay.agent.weixin.config.WxBaseConfig;
import com.hnair.pay.agent.weixin.constant.UrlConstants;
import com.hnair.pay.agent.weixin.constant.WxPayConstants;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.IWxBill;
import com.hnair.pay.agent.weixin.service.IWxHttpClient;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WxBillServiceImpl implements IWxBill {

    private WxBaseConfig wxPayConfig;

    private IWxHttpClient iWxHttpClient;

    @Value("${download.place}")
    private String downloadPlace;



    /**
     * 构造函数 创建bean注入
     * @param wxPayConfig
     * @param iWxHttpClient
     */
    public WxBillServiceImpl(WxBaseConfig wxPayConfig, IWxHttpClient iWxHttpClient) {
        this.wxPayConfig = wxPayConfig;
        this.iWxHttpClient = iWxHttpClient;
    }

    @Override
    public WxPayBillResult downloadBill(WxPayDownloadBillRequest request) throws WxPayException, IOException {
        request.checkAndSign(wxPayConfig);
        String url = wxPayConfig.getPayBaseUrl() + UrlConstants.WX_DOWNLOADBILL;
        String responseContent = iWxHttpClient.post(url, request.toXML(), false);
        //WxPayBillResult result = WxUtils.fromXML(responseContent, WxPayBillResult.class);
        //WxUtils.checkResult(request.getSignType(), true, result, wxPayConfig.getMchKey());
        String fileName=request.getBillDate();
        File file = new File(downloadPlace+"wx"+fileName+request.getBillType()+".csv");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
        FileWriter fileWritter = new FileWriter(file, false);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(responseContent);
        bufferWritter.close();
        //把第一行表头去掉
        String tradeMsg = responseContent.substring(responseContent.indexOf("`"));
        //去掉汇总数据，并且去掉"`"这个符号。
        String tradeInfo = tradeMsg.substring(0, tradeMsg.indexOf("总")).replace("`", "");
        //用spilt方法拿出每一天数据放进数组里。之后再用spilt方法把数据放进二维数组里。
        String[] tradeArray = tradeInfo.split("%");  // 根据%来区分
        for (String tradeDetailInfo : tradeArray) {
            String[] tradeDetailArray = tradeDetailInfo.split(",");
            for (String s : tradeDetailArray) {


            }
        }


        return null;
    }

    public WxPayBillResult downloadBill(String billDate, String billType, String tarType, String deviceInfo) throws WxPayException, IOException {
        if (!WxPayConstants.BillType.ALL.equals(billType)) {
            throw new WxPayException("目前仅支持ALL类型的对账单下载");
        }
        WxPayDownloadBillRequest request = new WxPayDownloadBillRequest();
        request.setBillType(billType);
        request.setBillDate(billDate);
        request.setTarType(tarType);
        request.setDeviceInfo(deviceInfo);
        return this.downloadBill(request);
    }
}
