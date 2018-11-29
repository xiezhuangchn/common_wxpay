package com.pay.task.sharing.excutor;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.PayOrderExample;
import com.hnair.pay.db.entity.ProfitsharingOrder;
import com.pay.task.sharing.PushSharingStatusExcutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 推送分账状态
 */
public class PushSharingStatusExcutor implements Runnable{

    private final Logger logger = LoggerFactory.getLogger(PushSharingStatusExcutor.class);

    private ProfitsharingOrder model;

    private PushSharingStatusExcutorService pushSharingStatusExcutorService;

    private PayOrderMapper payOrderMapper;

    public PushSharingStatusExcutor(ProfitsharingOrder model, PushSharingStatusExcutorService pushSharingStatusExcutorService, PayOrderMapper payOrderMapper) {
        this.model = model;
        this.pushSharingStatusExcutorService = pushSharingStatusExcutorService;
        this.payOrderMapper = payOrderMapper;
    }

    @Override
    public void run() {
        logger.info("PushSharingStatusExcutor start busPayNo:{} param:{}",model.getBusPayNo(),JSON.toJSONString(model));

        PayOrder payOrder = getPayOrder(model.getBusPayNo());

        // 推送状态至Order
        pushSharingStatusExcutorService.sendMessageToOrder(model, payOrder);

        logger.info("PushSharingStatusExcutor end busPayNo:{}",model.getBusPayNo());
    }

    private PayOrder getPayOrder(String busPayNo){
        PayOrderExample example = new PayOrderExample();
        example.createCriteria().andBusPayNoEqualTo(busPayNo);
        List<PayOrder> payOrders = payOrderMapper.selectByExample(example);
        if(null == payOrders || payOrders.size() <= 0){
            throw new PayException(ErrorCode.ORDER_IS_NOT_EXST);
        }
        return payOrders.get(0);
    }

}
