package com.pay.task.sharing.excutor;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.enums.sharing.SharingStatusEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.sharing.WechatSharingResponse;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.PayOrderExample;
import com.hnair.pay.db.entity.ProfitsharingOrder;
import com.pay.task.sharing.SharingExcutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * 分账批处理
 */
public class SharingOrderExcutor implements Runnable{

    private final Logger logger = LoggerFactory.getLogger(SharingOrderExcutor.class);

    private ProfitsharingOrder model;

    private SharingExcutorService sharingExcutorService;

    private PayOrderMapper payOrderMapper;

    public SharingOrderExcutor(ProfitsharingOrder model, SharingExcutorService sharingExcutorService, PayOrderMapper payOrderMapper) {
        this.model = model;
        this.sharingExcutorService = sharingExcutorService;
        this.payOrderMapper = payOrderMapper;
    }

    @Override
    public void run() {
        logger.info("sharingOrderExcutor start busPayNo:{} param:{}",model.getBusPayNo(),JSON.toJSONString(model));
        // 分账
        Integer sharingStatus = SharingStatusEnum.PROCESS_SUCCESS.getCode();
        // 更改分账处理状态为处理中
        sharingExcutorService.updateProfitsharingOrderStatus(model, SharingStatusEnum.PROCCESSING.getCode(), new Date(), null, null,null, null,null);

        PayOrder payOrder = getPayOrder(model.getBusPayNo());

        WechatSharingResponse wechatSharingResponse = new WechatSharingResponse();
        try {
            wechatSharingResponse = sharingExcutorService.sharingOrder(model, payOrder);
        } catch (Exception e) {
            // 更改分账处理状态为处理失败
            sharingStatus = SharingStatusEnum.PROCESS_FAILED.getCode();
            sharingExcutorService.updateProfitsharingOrderStatus(model, SharingStatusEnum.PROCESS_FAILED.getCode(), null, null, wechatSharingResponse.getFailureReason(),null, null,model.getNum()+1);
            logger.error("创建微信分账订单失败 busPayNo:{}",model.getBusPayNo(),e);
        }

        if(SharingStatusEnum.PROCESS_SUCCESS.getCode() == sharingStatus){
            // 推送状态至Order
            sharingExcutorService.sendMessageToOrder(model, payOrder, wechatSharingResponse);
        }

        logger.info("sharingOrderExcutor end busPayNo:{}",model.getBusPayNo());
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
