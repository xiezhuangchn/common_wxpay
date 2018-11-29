package com.pay.task.close.excutor;

import com.hnair.pay.agent.weixin.Request.WxSharingRequest;
import com.hnair.pay.agent.weixin.service.IWxPay;
import com.hnair.pay.db.dao.mapext.PayOrderExtMapper;
import com.hnair.pay.db.dao.mapper.PayOrderLogMapper;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.dao.mapper.ProfitsharingOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 离店超时处理
 */
public class CloseOrderExcutor implements Runnable{

    private final Logger logger = LoggerFactory.getLogger(CloseOrderExcutor.class);

    private PayOrder payOrderModel;

    private PayOrderMapper payOrderMapper;

    private PayOrderExtMapper payOrderExtMapper;

    private ProfitsharingOrderMapper profitsharingOrderMapper;

    private PayOrderLogMapper payOrderLogMapper;

    private IWxPay wxPayService;



    public CloseOrderExcutor(PayOrder model, PayOrderMapper payOrderMapper, PayOrderExtMapper payOrderExtMapper, ProfitsharingOrderMapper profitsharingOrderMapper, PayOrderLogMapper payOrderLogMapper, IWxPay wxPayService) {
            this.payOrderModel=model;
            this.payOrderMapper=payOrderMapper;
            this.payOrderExtMapper=payOrderExtMapper;
            this.profitsharingOrderMapper=profitsharingOrderMapper;
            this.payOrderLogMapper=payOrderLogMapper;
            this.wxPayService=wxPayService;
    }

    @Override
    public void run() {
        WxSharingRequest wxSharingRequest = new WxSharingRequest();
        //wxSharingRequest.setOutOrderNo(payOrderModel.get);
        //wxPayService.profitsharing();
        wxSharingRequest.setTransactionId(wxSharingRequest.getTransactionId());






    }

}
