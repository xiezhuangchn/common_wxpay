package com.pay.task.pay;

import com.hnair.pay.common.enums.CallOrderStatusEnum;
import com.hnair.pay.common.enums.pay.PayStatusEnum;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.PayOrderExample;
import com.hnair.pay.service.WxNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通知订单系统 支付成功的单子
 */
@Service
public class CompesantPayTaskService {

    private final Logger logger = LoggerFactory.getLogger(CompesantPayTaskService.class);

    @Autowired
    private WxNotifyService wxNotifyService;

    @Autowired
    private PayOrderMapper payOrderMapper;

    private ExecutorService compesantPushThreadPool = Executors.newFixedThreadPool(5);

    /**
     * 通知订单系统 支付成功
     * 先这样子 除非订单系统挂了 不然数据量不会大 TODO
     */
    public void compesantPushPayOrderStatus() {
        logger.info("开始异步补偿，通知订单平台更改支付状态信息 star");
        PayOrderExample payOrderExample = new PayOrderExample();
        PayOrderExample.Criteria criteria = payOrderExample.createCriteria();
        criteria.andSendStatusEqualTo(CallOrderStatusEnum.INIT.getCode().byteValue());
        criteria.andPayStatusEqualTo(PayStatusEnum.PAY_SUCCESS.getCode().byteValue());
        List<PayOrder> payOrderList = payOrderMapper.selectByExample(payOrderExample);
        for (PayOrder payOrder : payOrderList) {
            compesantPushThreadPool.execute(new CompesantPushPayOrderStatusTask(wxNotifyService, payOrder));
        }
        logger.info("成功通知订单平台更改支付状态信息 end，本次推送条数为{}", payOrderList.size());
    }

   final class CompesantPushPayOrderStatusTask implements Runnable {

        private WxNotifyService wxNotifyService;
        private PayOrder payOrder;

        public CompesantPushPayOrderStatusTask(WxNotifyService wxNotifyService, PayOrder payOrder) {
            this.wxNotifyService = wxNotifyService;
            this.payOrder = payOrder;
        }

        @Override
        public void run() {
            try {
                wxNotifyService.notifyOrderPayStatus(payOrder.getBusPayNo());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
