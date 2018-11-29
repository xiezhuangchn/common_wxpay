package com.hnair.pay.rpc.refund;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.hnair.pay.common.utils.HttpClientUtil;
import com.hnair.pay.rpc.refund.dto.RefundNotifyRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RefundRpcService {

  private final Logger logger = LoggerFactory.getLogger("RefundRpcService");

  /**
   * 通知订单支付状态
   */
  public ApiResponse<Boolean> callOrderNotifyRefundStatus(RefundNotifyRequest refundNotifyRequest, String refundUrl) {
      String reqStr = JSON.toJSONString(refundNotifyRequest);
      logger.info("callOrderNotifyRefundStatus，req{}", reqStr);
      String resultJson = HttpClientUtil.doPostJson(refundUrl, reqStr);
      ApiResponse<Boolean> result = JSON.parseObject(resultJson, ApiResponse.class);
      logger.info("callOrderNotifyRefundStatus，返回报文{}", resultJson);
      return result;
  }

}
