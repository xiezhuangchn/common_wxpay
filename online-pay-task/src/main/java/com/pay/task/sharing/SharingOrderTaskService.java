package com.pay.task.sharing;

import com.hnair.pay.common.enums.sharing.CallOrderSendStatusEnum;
import com.hnair.pay.common.enums.sharing.SharingStatusEnum;
import com.hnair.pay.db.dao.mapext.PayOrderExtMapper;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.entity.ProfitsharingOrder;
import com.pay.task.sharing.excutor.PushSharingStatusExcutor;
import com.pay.task.sharing.excutor.SharingOrderExcutor;
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
 *  分单相关批处理
 *
 */
@Service
public class SharingOrderTaskService {

    private final Logger logger = LoggerFactory.getLogger(SharingOrderTaskService.class);

    @Autowired
    private PayOrderExtMapper payOrderExtMapper;
    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private SharingExcutorService sharingExcutorService;
    @Autowired
    private PushSharingStatusExcutorService pushSharingStatusExcutorService;

    // 分账批处理 线程池 待处理
    private ExecutorService payOrderSharingPendingThreadPool = Executors.newFixedThreadPool(10);
    // 分账批处理 线程池 处理中
    private ExecutorService payOrderSharingInHandThreadPool = Executors.newFixedThreadPool(5);
    // 分账批处理 线程池 处理失败
    private ExecutorService payOrderSharingDisposeFailThreadPool = Executors.newFixedThreadPool(3);
    // 推送分账状态
    private ExecutorService payOrderPushSharingStatusThreadPool = Executors.newFixedThreadPool(2);

    /**
     * 推送分账状态
     */
    public String pushSharingStatusTask(Integer num) {
        logger.info("pushSharingStatusTask start");
        Map conditionMap = new HashMap<>();
        conditionMap.put("num", num);
        conditionMap.put("sendStatus", CallOrderSendStatusEnum.UN_SEND.getCode());
        conditionMap.put("sharingStatus", SharingStatusEnum.PROCESS_SUCCESS.getCode());
        List<ProfitsharingOrder> list = payOrderExtMapper.selectSharingOrderLimit(conditionMap);
        if (null == list || list.size() <= 0) {
            logger.info("pushSharingStatusTask end,没有需要推送分账状态的账单--不做处理");
            return "没有需要推送分账状态的账单--不做处理";
        }
        logger.info("pushSharingStatusTask num =" + list.size());
        for (ProfitsharingOrder model : list) {
            payOrderPushSharingStatusThreadPool.execute(new PushSharingStatusExcutor(model, pushSharingStatusExcutorService, payOrderMapper));
        }
        logger.info("pushSharingStatusTask end，正在处理： num =" + list.size());
        return "pushSharingStatusTask end";
    }

    /**
     * 分账批处理发起
     * @param num
     * @param status
     */
    public void sharingOrder(Integer num, Integer status) {
        if (SharingStatusEnum.INIT.getCode() == status) {
            //初始化的单子
            sharingOrderPending(num);
        } else if (SharingStatusEnum.PROCCESSING.getCode() == status) {
            //正在处理 一直没有处理的单子 超过更新时间多长的情况
            sharingOrderInHand(num);
        } else if (SharingStatusEnum.PROCESS_FAILED.getCode() == status) {
            //处理失败的单子
            sharingOrderDisposeFail(num);
        } else {
            throw new RuntimeException("status不存在");
        }
    }

    /**
     * 分账批处理-待处理
     */
    public String sharingOrderPending(Integer num) {
        logger.info("sharingOrderPending start");
        Map conditionMap = new HashMap<>();
        conditionMap.put("num", num);
        conditionMap.put("sharingStatus", SharingStatusEnum.INIT.getCode());
        List<ProfitsharingOrder> list = payOrderExtMapper.selectSharingOrderLimit(conditionMap);
        if (null == list || list.size() <= 0) {
            logger.info("sharingOrderPending end,  没有需要分账处理的账单--不做处理(待处理)");
            return "没有需要分账处理的账单--不做处理";
        }
        logger.info("sharingOrderPending num =" + list.size());
        for (ProfitsharingOrder model : list) {
            payOrderSharingPendingThreadPool.execute(new SharingOrderExcutor(model, sharingExcutorService, payOrderMapper));
        }
        logger.info("sharingOrderPending end，正在处理： num =" + list.size());
        return "sharingOrderPending end";
    }

    /**
     * 分账批处理-处理中
     */
    public String sharingOrderInHand(Integer num) {
        logger.info("sharingOrderInHand start");
        Map conditionMap = new HashMap<>();
        conditionMap.put("num", num);
        List<ProfitsharingOrder> list = payOrderExtMapper.selectHandingLimit(conditionMap);
        if (null == list || list.size() <= 0) {
            logger.info("sharingOrderInHand end,  没有需要分账处理的账单--不做处理(处理中)");
            return "没有需要分账处理的账单--不做处理";
        }
        logger.info("sharingOrderInHand num =" + list.size());
        for (ProfitsharingOrder model : list) {
            payOrderSharingInHandThreadPool.execute(new SharingOrderExcutor(model, sharingExcutorService, payOrderMapper));
        }
        logger.info("sharingOrderInHand end，正在处理： num =" + list.size());
        return "sharingOrderInHand end";
    }

    /**
     * 分账批处理-处理失败
     */
    public String sharingOrderDisposeFail(Integer num) {
        logger.info("sharingOrderDisposeFail start");
        Map conditionMap = new HashMap<>();
        conditionMap.put("num", num);
        conditionMap.put("sharingStatus", SharingStatusEnum.PROCESS_FAILED.getCode());
        List<ProfitsharingOrder> list = payOrderExtMapper.selectSharingOrderLimit(conditionMap);
        if (null == list || list.size() <= 0) {
            logger.info("sharingOrderDisposeFail end,  没有需要分账处理的账单--不做处理(处理失败)");
            return "没有需要分账处理的账单--不做处理";
        }
        logger.info("sharingOrderDisposeFail num =" + list.size());
        for (ProfitsharingOrder model : list) {
            payOrderSharingDisposeFailThreadPool.execute(new SharingOrderExcutor(model, sharingExcutorService, payOrderMapper));
        }
        logger.info("sharingOrderDisposeFail end，正在处理： num =" + list.size());
        return "sharingOrderDisposeFail end";
    }

}
