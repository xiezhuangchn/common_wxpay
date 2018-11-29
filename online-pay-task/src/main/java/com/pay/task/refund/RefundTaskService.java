package com.pay.task.refund;

import com.hnair.pay.common.enums.refund.OrderRefundStatusEnum;
import com.hnair.pay.db.dao.mapext.RefundOrderMapperExt;
import com.hnair.pay.db.entity.RefundOrder;
import com.pay.task.refund.excutor.QueryRefundStatusExcutor;
import com.pay.task.refund.excutor.RefundExcutorService;
import com.pay.task.refund.excutor.SendRefundTaskExcutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 退款任务
 */
@Service
public class RefundTaskService {

    private final Logger logger = LoggerFactory.getLogger(RefundTaskService.class);

    @Autowired
    private RefundExcutorService refundExcutorService;

    @Autowired
    private RefundOrderMapperExt refundOrderMapperExt;

    private ExecutorService sendRefundTaskForPendingThreadPool = Executors.newFixedThreadPool(10);

    private ExecutorService sendRefundTaskForFailThreadPool  = Executors.newFixedThreadPool(5);

    private ExecutorService sendRefundTaskForHandingPool = Executors.newFixedThreadPool(5);

    private ExecutorService queryRefundStatusTaskPool = Executors.newFixedThreadPool(2);

    /**
     * 退款批处理发起
     * @param num
     * @param status
     */
    public void sendRefundTask(Integer num, Integer status) {
        if (OrderRefundStatusEnum.PENDING.getCode() == status) {
            //初始化的单子
            sendRefundTaskForPending(num);
        } else if (OrderRefundStatusEnum.IN_HAND.getCode() == status) {
            //正在处理 一直没有处理的单子 超过更新时间多长的情况
            sendRefundTaskForHanding(num);
        } else if (OrderRefundStatusEnum.TO_DEAL_WITH_FAILURE.getCode() == status) {
            //处理失败的单子
            sendRefundTaskForFail(num);
        } else {
            throw new RuntimeException("status不存在");
        }
    }

    /**
     * 处理失败的单子
     * @param num
     */
    private void sendRefundTaskForFail(Integer num) {
        logger.info("sendRefundTaskForFail start");
        Map conditionMap = new HashMap<>();
        conditionMap.put("num", num);
        List<RefundOrder>  list =  refundOrderMapperExt.selectFailLimit(conditionMap);
        if (null == list || list.size() <= 0) {
            logger.info("sendRefundTaskForFail end 不存在状态为待处理的需要退款的单子");
            return;
        }
        logger.info("sendRefundTaskForFail num =" + list.size());

        for (RefundOrder model : list) {
            sendRefundTaskForFailThreadPool.execute(new SendRefundTaskExcutor(model, refundExcutorService));
        }
        logger.info("sendRefundTaskForFail end，正在处理： num =" + list.size());
    }

    /**
     * 正在处理 一直没有处理的单子 超过更新时间多长的情况
     * @param num
     */
    private void sendRefundTaskForHanding(Integer num) {
        logger.info("sendRefundTaskForHanding start");
        Map conditionMap = new HashMap<>();
        conditionMap.put("num", num);
        List<RefundOrder>  list =  refundOrderMapperExt.selectHandingLimit(conditionMap);
        if (null == list || list.size() <= 0) {
            logger.info("sendRefundTaskForHanding end 不存在需要退款的单子");
            return;
        }
        logger.info("sendRefundTaskForHanding num =" + list.size());

        for (RefundOrder model : list) {
            sendRefundTaskForHandingPool.execute(new SendRefundTaskExcutor(model, refundExcutorService));
        }
        logger.info("sendRefundTaskForHanding end，正在处理： num =" + list.size());
    }

    /**
     * 初始化的单子
     * @param num
     */
    private void sendRefundTaskForPending(Integer num) {
        logger.info("sendRefundTaskForPending start");
        Map conditionMap = new HashMap<>();
        conditionMap.put("num", num);
        List<RefundOrder> list =  refundOrderMapperExt.selectPendingLimit(conditionMap);
        if (null == list || list.size() <= 0) {
            logger.info("sendRefundTaskForPending end 不存在需要退款的单子");
            return;
        }
        logger.info("sendRefundTaskForPending num =" + list.size());

        for (RefundOrder model : list) {
            sendRefundTaskForPendingThreadPool.execute(new SendRefundTaskExcutor(model, refundExcutorService));
        }
        logger.info("sendRefundTaskForPending end，正在处理： num =" + list.size());
    }

    /**
     * 退款状态查询
     * @param num
     */
    public void queryRefundStatusTask(Integer num) {
        logger.info("queryRefundStatusTask start");
        Map conditionMap = new HashMap<>();
        conditionMap.put("num", num);
        List<RefundOrder> list =  refundOrderMapperExt.selectSendSuccessLimit(conditionMap);
        if (null == list || list.size() <= 0) {
            logger.info("queryRefundStatusTask end 不存在需要查询退款的单子");
            return;
        }
        logger.info("queryRefundStatusTask num =" + list.size());

        for (RefundOrder model : list) {
            queryRefundStatusTaskPool.execute(new QueryRefundStatusExcutor(model, refundExcutorService));
        }
        logger.info("queryRefundStatusTask end，正在处理： num =" + list.size());
    }

    /**
     * 查询处理31次的退款订单
     * @param num
     */
    public void queryHandleTimesThan30(Integer num) {
        logger.info("queryHandleTimesThan30 start");
        Map conditionMap = new HashMap<>();
        conditionMap.put("num", num);
        List<RefundOrder> list =  refundOrderMapperExt.selectNumTimesLimit(conditionMap);
        if (null == list || list.size() <= 0) {
            logger.info("queryHandleTimesThan30 end 不存在需要查询退款的单子");
            return;
        }
        logger.info("queryHandleTimesThan30 num =" + list.size());

        for (RefundOrder model : list) {
            queryRefundStatusTaskPool.execute(new QueryRefundStatusExcutor(model, refundExcutorService));
        }
        logger.info("queryHandleTimesThan30 end，正在处理： num =" + list.size());

    }
}
