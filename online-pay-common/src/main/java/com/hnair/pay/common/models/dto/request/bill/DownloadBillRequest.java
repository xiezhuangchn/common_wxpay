package com.hnair.pay.common.models.dto.request.bill;

import io.swagger.annotations.ApiModel;

@ApiModel("微信下载对账单")
public class DownloadBillRequest {

    private String billType;

    private String billDate;

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }
}
