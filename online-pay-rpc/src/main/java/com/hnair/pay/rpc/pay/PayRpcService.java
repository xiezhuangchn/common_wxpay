package com.hnair.pay.rpc.pay;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.hnair.pay.common.utils.HttpClientUtil;
import com.hnair.pay.rpc.pay.dto.PayNotifyRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PayRpcService {

    private final Logger logger = LoggerFactory.getLogger("PayRpcService");

    /**
     * 通知订单支付状态
     * @param payNotifyRequest
     * @return
     */
    public ApiResponse<Boolean> callOrderNotifyPayStatus (PayNotifyRequest payNotifyRequest, String payUrl) {
        String reqStr = JSON.toJSONString(payNotifyRequest);
        logger.info("callOrderNotifyPayStatus，req{}", reqStr);
        String resultJson = HttpClientUtil.doPostJson(payUrl, reqStr);
        ApiResponse<Boolean> result = JSON.parseObject(resultJson, ApiResponse.class);
        logger.info("callOrderNotifyPayStatus，返回报文{}", resultJson);
        return result;
    }

}
