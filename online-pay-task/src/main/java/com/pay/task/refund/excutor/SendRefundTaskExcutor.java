package com.pay.task.refund.excutor;

import com.hnair.pay.common.enums.refund.OrderRefundStatusEnum;
import com.hnair.pay.db.entity.RefundOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发起退款请求
 */
public class SendRefundTaskExcutor implements Runnable {

  private final Logger logger = LoggerFactory.getLogger(SendRefundTaskExcutor.class);

  private RefundOrder model;

  private RefundExcutorService refundExcutorService;

  public SendRefundTaskExcutor(RefundOrder model, RefundExcutorService refundExcutorService) {
    this.model = model;
    this.refundExcutorService = refundExcutorService;
  }

  @Override
  public void run() {
    try {
      //更新执行状态
      refundExcutorService.updateRefundStatus(model, OrderRefundStatusEnum.IN_HAND.getCode(), model.getNum());
      refundExcutorService.sendRefundInfo(model);
    } catch (Exception e) {
      logger.error("sendRefundInfo error busOrderId=" + model.getBusOrderNo(), e);
      refundExcutorService.updateRefundStatus(model, OrderRefundStatusEnum.TO_DEAL_WITH_FAILURE.getCode(), model.getNum() + 1);
    }
  }

}
