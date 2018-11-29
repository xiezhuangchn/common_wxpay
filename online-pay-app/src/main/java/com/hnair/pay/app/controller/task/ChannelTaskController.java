package com.hnair.pay.app.controller.task;

import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.models.dto.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 刷新signKey 定时任务
 */
@Controller
@RequestMapping("/task/channel/")
@Api(value = "channelTask", tags = "批处理 --刷新各个渠道配置")
public class ChannelTaskController {

  private final Logger logger = LoggerFactory.getLogger(ChannelTaskController.class);

  @Autowired
  private ChannelCommonService channelCommonService;

  /**
   *  定时刷新signKeyMap
   */
  @GetMapping("/refresh")
  @ResponseBody
  @ApiOperation(value = "定时刷新各个渠道配置", httpMethod = "GET", notes = "定时刷新各个渠道配置")
  public ApiResponse<Boolean> refreshAllChannelConfigMap() {
    try {
      logger.info("refreshAllChannelConfigMap star");
      channelCommonService.refreshAllChannelConfigMap();
      logger.info("refreshAllChannelConfigMap end");
      return ApiResponse.success(true);
    } catch (Exception e) {
      logger.info("refreshAllChannelConfigMap error {}", e);
      return ApiResponse.createBusFailRespons(e);
    }
  }

}
