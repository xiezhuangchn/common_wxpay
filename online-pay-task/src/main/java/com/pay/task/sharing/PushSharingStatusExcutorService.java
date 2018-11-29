package com.pay.task.sharing;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.enums.sharing.CallOrderSendStatusEnum;
import com.hnair.pay.common.enums.sharing.SharingStatusEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.db.dao.mapper.ProfitsharingOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.ProfitsharingOrder;
import com.hnair.pay.db.entity.ProfitsharingOrderExample;
import com.hnair.pay.rpc.sharing.SharingRpcService;
import com.hnair.pay.rpc.sharing.dto.SharingNotifyRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 *  推送分账状态
 *
 */
@Service
public class PushSharingStatusExcutorService {

    private final Logger logger = LoggerFactory.getLogger(PushSharingStatusExcutorService.class);

    @Autowired
    private ProfitsharingOrderMapper profitsharingOrderMapper;

    @Autowired
    private SharingRpcService sharingRpcService;
    @Autowired
    private ChannelCommonService channelCommonService;


    @Transactional
    public void sendMessageToOrder(ProfitsharingOrder model, PayOrder payOrder) {

        // 推送分账结果至order工程
        SharingNotifyRequest req = createOrderProjectRequest(model, payOrder);

        Boolean orderResult = null;
        try {
        logger.info("sendMessageToOrder start busPayNo:{} param:{}", model.getBusPayNo(), JSON.toJSONString(req));
            orderResult = sharingRpcService.sharingNotify(req, channelCommonService.getSharingNotifyUrlByChannel(req.getBusChannel()));
        logger.info("sendMessageToOrder end busPayNo:{} result:{}", model.getBusPayNo(), JSON.toJSONString(orderResult));
        } catch (Exception e) {
            logger.error("推送分账结果至order工程失败 busPayNo:{}"+model.getBusPayNo(),e);
            throw new PayException(ErrorCode.PUSH_SHARING_RESULT_TO_ORDER_ERROR);
        }

        if(orderResult != null && orderResult){
            // 更改发送状态为发送成功
            updateProfitsharingOrderStatus(model, CallOrderSendStatusEnum.SENDED.getCode());
        }

    }

    private SharingNotifyRequest createOrderProjectRequest(ProfitsharingOrder model, PayOrder payOrder){
        SharingNotifyRequest req = new SharingNotifyRequest();

        req.setBusOrderNo(model.getBusOrderNo());
        req.setOrderType(payOrder.getBusType());
        req.setPayOrderNo(model.getBusPayNo());
        req.setSharingTradeNo(model.getSharingTradeNo());
        req.setSharingFee(model.getSharingFee());
        req.setSharingStatus(SharingStatusEnum.PROCESS_SUCCESS.getCode());
        req.setFailureReason(model.getFailureReason());
        req.setSharingType(model.getSharingType().intValue());
        req.setBusChannel(model.getBusChannel());

        return req;
    }

    public void updateProfitsharingOrderStatus(ProfitsharingOrder model, Integer sendStatus){
        ProfitsharingOrder record = new ProfitsharingOrder();
        record.setUpdateTime(new Date());
        record.setSendStatus(sendStatus.byteValue());

        ProfitsharingOrderExample example = new ProfitsharingOrderExample();
        example.createCriteria().andBusPayNoEqualTo(model.getBusPayNo());
        profitsharingOrderMapper.updateByExampleSelective(record, example);
    }

}
