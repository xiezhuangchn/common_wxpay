package com.pay.task.sharing;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.enums.CallOrderStatusEnum;
import com.hnair.pay.common.enums.sharing.SharingStatusEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.sharing.WechatSharingRequest;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.sharing.WechatSharingResponse;
import com.hnair.pay.db.dao.mapper.ProfitsharingOrderMapper;
import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.ProfitsharingOrder;
import com.hnair.pay.db.entity.ProfitsharingOrderExample;
import com.hnair.pay.rpc.sharing.SharingRpcService;
import com.hnair.pay.rpc.sharing.dto.SharingNotifyRequest;
import com.hnair.pay.wx.WxSharingService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 *  分账相关批处理
 *
 */
@Service
public class SharingExcutorService {

    private final Logger logger = LoggerFactory.getLogger(SharingExcutorService.class);

    @Autowired
    private ProfitsharingOrderMapper profitsharingOrderMapper;

    @Autowired
    WxSharingService wSharingService;
    @Autowired
    private SharingRpcService sharingRpcService;
    @Autowired
    private ChannelCommonService channelCommonService;

    /**
     * 分账处理
     */
    @Transactional
    public WechatSharingResponse sharingOrder(ProfitsharingOrder model, PayOrder payOrder) throws Exception{

        // 向微信发起分账申请
        WechatSharingRequest wechatSharingRequest = createBusSendsharingInfoRequest(payOrder, model);

        logger.info("sharingOrder start busPayNo={} param={}",model.getBusPayNo(),JSON.toJSONString(wechatSharingRequest));
        WechatSharingResponse result = wSharingService.createSharingOrder(wechatSharingRequest);
        logger.info("sharingOrder end busPayNo={} result={}",model.getBusPayNo(), JSON.toJSONString(result));

        if(StringUtils.isBlank(result.getSharingTradeNo())){
            logger.info("sharingOrder:调用微信请求分账结果返回为空 busPayNo:{}",model.getBusPayNo());
            throw new RuntimeException("调用微信请求分账结果返回为空");
        }

        // 更改分账处理状态为分账成功
        updateProfitsharingOrderStatus(model, SharingStatusEnum.PROCESS_SUCCESS.getCode(), null, new Date(), null,result.getSharingTradeNo(), null,null);

        return result;
    }

    @Transactional
    public void sendMessageToOrder(ProfitsharingOrder model, PayOrder payOrder, WechatSharingResponse wechatSharingResponse) {

        // 推送分账结果至order工程
        SharingNotifyRequest req = createOrderProjectRequest(model, payOrder, wechatSharingResponse);

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
            updateProfitsharingOrderStatus(model, null, null, null,
                    null,null, CallOrderStatusEnum.SUCCESS.getCode(),null);
        }

    }

    private SharingNotifyRequest createOrderProjectRequest(ProfitsharingOrder model, PayOrder payOrder,
                                                           WechatSharingResponse wechatSharingResponse){
        SharingNotifyRequest req = new SharingNotifyRequest();

        req.setBusOrderNo(model.getBusOrderNo());
        req.setOrderType(payOrder.getBusType());
        req.setPayOrderNo(model.getBusPayNo());
        req.setSharingTradeNo(wechatSharingResponse.getSharingTradeNo());
        req.setSharingFee(model.getSharingFee());
        req.setSharingStatus(SharingStatusEnum.PROCESS_SUCCESS.getCode());
        req.setFailureReason(wechatSharingResponse.getFailureReason());
        req.setSharingType(model.getSharingType().intValue());
        req.setBusChannel(model.getBusChannel());

        return req;
    }

    public void updateProfitsharingOrderStatus(ProfitsharingOrder model, Integer sharingStatus, Date sharingSendTime,
                                                Date sharingSuccessTime, String failureReason, String sharingTradeNo,
                                               Integer sendStatus, Integer num){
        ProfitsharingOrder record = new ProfitsharingOrder();
        record.setUpdateTime(new Date());
        record.setSharingSendTime(sharingSendTime);
        record.setSharingSuccessTime(sharingSuccessTime);
        record.setFailureReason(failureReason);
        record.setSharingTradeNo(sharingTradeNo);
        record.setNum(num);
        if(sharingStatus != null){
            record.setSharingStatus(sharingStatus.byteValue());
        }
        if(sendStatus != null){
            record.setSendStatus(sendStatus.byteValue());
        }

        ProfitsharingOrderExample example = new ProfitsharingOrderExample();
        example.createCriteria().andBusPayNoEqualTo(model.getBusPayNo());
        profitsharingOrderMapper.updateByExampleSelective(record, example);
    }

    private WechatSharingRequest createBusSendsharingInfoRequest(PayOrder payOrder, ProfitsharingOrder model){
        WechatSharingRequest req = new WechatSharingRequest();
        req.setSharingOrderNo(model.getSharingOrderNo());
        req.setBusPayNo(payOrder.getBusPayNo());
        req.setSharingAccountType(model.getSharingAccountType());
        req.setSharingAccount(model.getSharingAccount());
        req.setSharingFee(model.getSharingFee());
        req.setSharingFeeType(model.getSharingFeeType());
        req.setSharingDesc(model.getSharingDesc());
        req.setSharingType(model.getSharingType().intValue());
        req.setSharingReceivers(model.getSharingReceivers());
        req.setPlatformSharingFee(model.getPlatformSharingFee());
        req.setOtherSharingFee(model.getOtherSharingFee());
        return req;
    }

}
