package com.hnair.pay.rpc.sharing;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.models.dto.request.sharing.dto.OrderApiResponse;
import com.hnair.pay.rpc.HttpRestService;
import com.hnair.pay.rpc.sharing.dto.SharingNotifyRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 调用Order工程接口封装service
 *
 */
@Service
public class SharingRpcService {

  private final Logger logger = LoggerFactory.getLogger("SharingRpcService");

  @Autowired
  private HttpRestService httpRestService;

  /**
   * 调order工程接口推送分账结果
   */
  public Boolean sharingNotify(SharingNotifyRequest dto, String sharingNotifyUrl) {
    String requestStr = JSON.toJSONString(dto);
    try {
      logger.info("sharingNotify req={}", requestStr);
      ResponseEntity<OrderApiResponse> responseEntity =
          httpRestService.httpPostJson(sharingNotifyUrl, requestStr, OrderApiResponse.class);
      logger.info("sharingNotify res : {}", JSON.toJSONString(responseEntity));
      if (responseEntity.getStatusCodeValue() != 200) {
        logger.error("sharingNotify  http request error,req={}", requestStr);
        return null;
      }
      if (null == responseEntity.getBody()) {
        logger.error("sharingNotify,接口返回body为null,req={}", requestStr);
        return null;
      }

      logger.info(responseEntity.getBody().toString());
      return Boolean.valueOf(responseEntity.getBody().getData().toString());
    } catch (Exception e) {
      logger.error("preOrder exception ,req=" + requestStr, e);
      return null;
    }

  }

}
