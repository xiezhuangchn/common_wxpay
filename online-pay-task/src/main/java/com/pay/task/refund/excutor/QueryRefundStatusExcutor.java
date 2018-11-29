package com.pay.task.refund.excutor;

import com.hnair.pay.db.entity.RefundOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryRefundStatusExcutor implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(QueryRefundStatusExcutor.class);

    private RefundOrder model;

    private RefundExcutorService refundExcutorService;

    public QueryRefundStatusExcutor(RefundOrder model, RefundExcutorService refundExcutorService) {
        this.model = model;
        this.refundExcutorService = refundExcutorService;
    }

    @Override
    public void run() {
        try {
            refundExcutorService.queryRefundStatus(model);
        } catch (Exception e) {
            logger.error("异步查询查询退款状态异常,refundOrderNo=" + model.getRefundOrderNo(), e);
        }
    }
}
