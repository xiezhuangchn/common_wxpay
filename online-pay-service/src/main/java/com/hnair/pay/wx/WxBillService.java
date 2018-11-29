package com.hnair.pay.wx;

import com.hnair.pay.agent.weixin.Request.WxPayDownloadBillRequest;
import com.hnair.pay.agent.weixin.Response.WxPayBillBaseResult;
import com.hnair.pay.agent.weixin.Response.WxPayBillResult;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.impl.WxBillServiceImpl;
import com.hnair.pay.agent.weixin.service.impl.WxPayServiceImpl;
import com.hnair.pay.common.models.dto.request.bill.DownloadBillRequest;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.dao.mapper.ProfitsharingOrderMapper;
import com.hnair.pay.db.dao.mapper.RefundOrderMapper;
import com.hnair.pay.db.entity.ProfitsharingOrder;
import com.hnair.pay.db.entity.RefundOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class WxBillService {

    @Autowired
    private RefundOrderMapper refundOrderMapper;

    @Autowired
    private ProfitsharingOrderMapper profitsharingOrderMapper;

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private WxPayServiceImpl wxPayServiceImpl;

    @Autowired
    private WxBillServiceImpl wxBillServiceImpl;


    public WxPayBillResult exportPayBill(DownloadBillRequest dto) throws WxPayException, IOException {

        WxPayDownloadBillRequest wxPayDownloadBillRequest = new WxPayDownloadBillRequest();
        wxPayDownloadBillRequest.setBillType(dto.getBillType());
        wxPayDownloadBillRequest.setBillDate(dto.getBillDate());

        WxPayBillResult wxPayBillResult = wxBillServiceImpl.downloadBill(wxPayDownloadBillRequest);
        return wxPayBillResult;
    }

    public WxPayBillResult exportRefundBill(WxPayDownloadBillRequest dto) {
        WxPayDownloadBillRequest req = new WxPayDownloadBillRequest();
        List<RefundOrder> refundOrders = refundOrderMapper.selectByExample(null);
        for (RefundOrder order : refundOrders) {



        }

        WxPayBillResult wxPayBillResult = new WxPayBillResult();
        WxPayBillBaseResult wxPayBillBaseResult = new WxPayBillBaseResult();
        return null;
    }

    public WxPayBillResult exportProfitSharingBill(WxPayDownloadBillRequest dto) {
        WxPayDownloadBillRequest req = new WxPayDownloadBillRequest();
        List<ProfitsharingOrder> profitsharingOrders = profitsharingOrderMapper.selectByExample(null);
        for (ProfitsharingOrder order : profitsharingOrders) {




        }


        WxPayBillResult wxPayBillResult = new WxPayBillResult();
        WxPayBillBaseResult wxPayBillBaseResult = new WxPayBillBaseResult();
        return null;
    }
}
