package com.pay.task.search;

import com.hnair.pay.agent.weixin.service.IWxPay;
import com.hnair.pay.db.dao.mapext.PayOrderExtMapper;
import com.hnair.pay.db.dao.mapper.PayOrderLogMapper;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.dao.mapper.ProfitsharingOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import com.pay.task.close.excutor.CloseOrderExcutor;
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
 * 关单相关批处理
 *
 */
@Service
public class SearchOrderTaskService {

    private final Logger logger = LoggerFactory.getLogger(SearchOrderTaskService.class);

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private PayOrderExtMapper payOrderExtMapper;

    @Autowired
    private ProfitsharingOrderMapper profitsharingOrderMapper;

    @Autowired
    private PayOrderLogMapper payOrderLogMapper;

    @Autowired
    private IWxPay wxPayService;

    // 查询订单状态批处理 线程池
    private ExecutorService payOrderSearchThreadPool = Executors.newFixedThreadPool(10);


    /**
     * 装处理
     * TODO 暂时未使用
     */
    public String sharingOrder(Integer num) {
        logger.info("CloseOrderTaskService start");
        Map conditionMap = new HashMap<>();
        conditionMap.put("num", num);
        List<PayOrder> list =  payOrderExtMapper.selectCloseOrderLimit(conditionMap);
        if (null == list || list.size() <= 0) {
            return "没有能查询到的订单状态--不做处理";
        }
        logger.info("CloseOrderTaskService num =" + list.size());
        for (PayOrder model : list) {
            payOrderSearchThreadPool.execute(new CloseOrderExcutor(model, payOrderMapper, payOrderExtMapper,profitsharingOrderMapper,payOrderLogMapper,wxPayService));
        }
        logger.info("CloseOrderTaskService end，正在处理： num =" + list.size());
        return "CloseOrderTaskService end";
    }



}
