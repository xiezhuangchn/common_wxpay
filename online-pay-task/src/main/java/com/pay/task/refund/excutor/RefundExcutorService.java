package com.pay.task.refund.excutor;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.agent.weixin.Request.WxPayRefundRequest;
import com.hnair.pay.agent.weixin.Response.WxPayRefundQueryResult;
import com.hnair.pay.agent.weixin.Response.WxPayRefundResult;
import com.hnair.pay.agent.weixin.config.WxPayConfig;
import com.hnair.pay.agent.weixin.constant.WxPayConstants;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.impl.WxPayServiceImpl;
import com.hnair.pay.common.enums.refund.OrderRefundStatusEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.utils.TimeUtil;
import com.hnair.pay.db.dao.mapext.RefundOrderMapperExt;
import com.hnair.pay.db.dao.mapper.RefundOrderMapper;
import com.hnair.pay.db.entity.RefundOrder;
import com.hnair.pay.db.entity.RefundOrderExample;
import com.hnair.pay.wx.WxRefundService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RefundExcutorService {

    private final Logger logger = LoggerFactory.getLogger(RefundExcutorService.class);

    @Autowired
    private RefundOrderMapper refundOrderMapper;

    @Autowired
    private RefundOrderMapperExt refundOrderMapperExt;

    @Autowired
    private WxPayConfig wxPayConfig;

    @Autowired
    private WxPayServiceImpl wxPayServiceImpl;

    @Autowired
    private WxRefundService wxRefundService;


    @Value("${wx.refund.notify.url}")
    private String refundAddress;

    /**
     * 调用微信，发起退款操作，并更新退款操作记录表信息
     *
     * @param model
     * @throws Exception
     */
    @Transactional
    public void sendRefundInfo(RefundOrder model) throws Exception {
        String refundOrderNo = model.getRefundOrderNo();
        RefundOrder refundOrder = refundOrderMapperExt.selectByRefundOrderNoForUpdate(refundOrderNo);
        if (refundOrder == null) {
            throw new PayException("退款单号不存在,refundOrderNo:" + refundOrderNo);
        }
        if (OrderRefundStatusEnum.REFUND_SUCCES.getCode() == refundOrder.getRefundStatus()
                || OrderRefundStatusEnum.SEND_SUCCESSFUL.getCode() == refundOrder.getRefundStatus()) {
            logger.info("退款已经成功,直接返回,info{}", JSON.toJSONString(refundOrder));
            return;
        }

        WxPayRefundRequest wxPayRefundRequest = buildWxPayRefundRequest(refundOrder);
        logger.info("调用微信退款，请求参数信息{}", JSON.toJSONString(refundOrder));
        WxPayRefundResult response = wxPayServiceImpl.refund(wxPayRefundRequest);
        logger.info("调用微信退款，返回参数信息{}", JSON.toJSONString(response));

        //判断微信的退款发送状态信息
        if (response.getReturnCode().equals(WxPayConstants.ResultCode.SUCCESS)) {
            if (StringUtils.isNotBlank(response.getResultCode()) & response.getResultCode()
                    .equalsIgnoreCase(WxPayConstants.ResultCode.SUCCESS)) {
                //更新发送退款状态
                updateRefundStatus(refundOrder, OrderRefundStatusEnum.SEND_SUCCESSFUL.getCode(), refundOrder.getNum() + 1);
            } else {
                throw new PayException("发送退款信息异常,RefundOrderNo=" + model.getRefundOrderNo());
            }
        } else {
            throw new PayException("发送退款信息不是成功,微信返回异常,RefundOrderNo=" + model.getRefundOrderNo());
        }
    }

    /**
     * 拼接微信退款请求的参数信息
     * @param refundOrder
     * @return
     */
    private WxPayRefundRequest buildWxPayRefundRequest(RefundOrder refundOrder) {
        WxPayRefundRequest wxPayRefundRequest = new WxPayRefundRequest();
        wxPayRefundRequest.setNotifyUrl(refundAddress);
        wxPayRefundRequest.setOutTradeNo(refundOrder.getBusPayNo());
        wxPayRefundRequest.setOutRefundNo(refundOrder.getRefundOrderNo());
        wxPayRefundRequest.setTotalFee(refundOrder.getTotalFee().intValue());
        wxPayRefundRequest.setRefundFee(refundOrder.getRefundFee().intValue());
        wxPayRefundRequest.setOpUserId("SYS");
        wxPayRefundRequest.setSubMchId(refundOrder.getSubMchId());
        wxPayRefundRequest.setMchId(wxPayConfig.getMchId());
        wxPayRefundRequest.setAppid(wxPayConfig.getAppId());
        wxPayRefundRequest.setSignType(WxPayConstants.SignType.MD5);
        return wxPayRefundRequest;
    }

    /**
     * 更新数据库执行状态
     *
     * @param model
     * @param refundStatus
     * @param num
     */
    public void updateRefundStatus(RefundOrder model, Integer refundStatus, Integer num) {
        RefundOrder record = new RefundOrder();
        Date now = new Date();
        record.setRefundStatus(refundStatus);
        record.setUpdateTime(now);
        record.setNum(num);
        RefundOrderExample example = new RefundOrderExample();
        example.createCriteria().andRefundOrderNoEqualTo(model.getRefundOrderNo());
        refundOrderMapper.updateByExampleSelective(record, example);
    }

    /**
     * 查询退款状态 并且更新退款状态
     * @param model
     */
    public void queryRefundStatus(RefundOrder model) throws Exception{
        RefundOrderExample refundOrderExample = new RefundOrderExample();
        refundOrderExample.createCriteria().andRefundOrderNoEqualTo(model.getRefundOrderNo());
        List<RefundOrder> refundOrders = refundOrderMapper.selectByExample(refundOrderExample);
        RefundOrder refundOrder = refundOrders.get(0);
        if (OrderRefundStatusEnum.REFUND_SUCCES.getCode() == refundOrder.getRefundStatus()) {
            return;
        }

        //调用微信接口查询退款状态
        WxPayRefundQueryResult result = wxRefundService.callWxRefundQuery(refundOrder);
        logger.info("queryRefundStatusTask WxPayRefundQueryResult：{}", JSON.toJSONString(result));

        if (null != result && null !=result.getRefundRecords() && result.getRefundRecords().size()>0) {
            String refundTradeNo = result.getRefundRecords().get(0).getRefundId();
            if (StringUtils.isNotEmpty(refundTradeNo)) {
                logger.info("queryRefundStatusTask 微信退款单号: {}", refundTradeNo);
                //更新数据库
                RefundOrder record = new RefundOrder();
                record.setRefundTradeNo(refundTradeNo); //微信退款单号保存
                record.setRefundTime(TimeUtil.parse_yyyy_MM_dd_HH_mm_ss(result.getRefundRecords().get(0).getRefundSuccessTime()));
                record.setRefundStatus(OrderRefundStatusEnum.REFUND_SUCCES.getCode());
                record.setUpdateTime(new Date());

                RefundOrderExample updateExample = new RefundOrderExample();
                updateExample.createCriteria().andRefundOrderNoEqualTo(model.getRefundOrderNo());
                int i = refundOrderMapper.updateByExampleSelective(record, updateExample);
                if (i <= 0) {
                    throw new WxPayException("退款回调结果，更新数据库退款状态失败，更新入参：" + JSON.toJSONString(record));
                }
            }
            //通知订单 退款成功
            wxRefundService.notifyRefundOrderStatus(model.getRefundOrderNo());
        }
    }
}
