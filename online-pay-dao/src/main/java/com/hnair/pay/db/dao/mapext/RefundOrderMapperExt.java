package com.hnair.pay.db.dao.mapext;


import com.hnair.pay.db.entity.RefundOrder;

import java.util.List;
import java.util.Map;

public interface RefundOrderMapperExt {

    /**
     * 初始化limit查询
     * @param conditionMap
     * @return
     */
    List<RefundOrder> selectPendingLimit(Map conditionMap);

    /**
     * 处理失败的单子
     * @param conditionMap
     * @return
     */
    List<RefundOrder> selectFailLimit(Map conditionMap);

    /**
     * 正在处理操作5分钟未处理的单子
     * @param conditionMap
     * @return
     */
    List<RefundOrder> selectHandingLimit(Map conditionMap);

    /**
     * 根据业务退款单号 行锁查询该条退款信息
     * @param refundOrderNo
     * @return
     */
    RefundOrder selectByRefundOrderNoForUpdate(String refundOrderNo);

    /**
     * 发送退款请求成功 微信一直没有回调
     * @param conditionMap
     * @return
     */
    List<RefundOrder> selectSendSuccessLimit(Map conditionMap);

    List<RefundOrder> selectNumTimesLimit(Map conditionMap);
}

