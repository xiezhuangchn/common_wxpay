package com.hnair.pay.app.controller.task;

import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.pay.task.sharing.SharingOrderTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;


/**
 * 微信分账 定时任务
 */
@Controller
@RequestMapping("/task/sharing/")
@Api(value = "sharingTask", tags = "批处理 --分账")
public class SharingTaskController {

  private final Logger logger = LoggerFactory.getLogger(SharingTaskController.class);

  @Autowired
  private SharingOrderTaskService sharingOrderTaskService;

  /**
   * 分账批处理发起
   */
  @GetMapping("/sharingOrder/{num}/{status}")
  @ResponseBody
  @ApiOperation(value = "分账发起批处理--num为一次执行条数 limit num status:状态：0，待处理，1，处理中，2，处理成功，-1处理失败", httpMethod = "GET", notes = "分账发起批处理")
  public ApiResponse<Boolean> sharingOrder(@PathVariable Integer num, @PathVariable Integer status) {
    try {
      sharingOrderTaskService.sharingOrder(num, status);
      return ApiResponse.success(true);
    } catch (Exception e) {
      logger.error("sharingOrder error", e);
      return ApiResponse.fail(ErrorCode.ERR_SYSTEM, e.getMessage());
    }
  }

  /**
   *  异步发起 分账发送成功 回调订单失败的分账单子
   * @param num
   * @return
   */
  @GetMapping("/pushSharingStatusTask/{num}")
  @ResponseBody
  @ApiOperation(value = "分账发送成功,回调订单失败的分账单子-num为一次执行条数 limit num", httpMethod = "GET", notes = "推送分账状态")
  public ApiResponse<Boolean> pushSharingStatusTask(@PathVariable Integer num) {
    try {
      logger.info("时间{}，开始分账发送成功,回调订单失败的分账单子任务操作", LocalDateTime.now());
      sharingOrderTaskService.pushSharingStatusTask(num);
      return ApiResponse.success(true);
    } catch (Exception e) {
      logger.info("时间{}，分账发送成功,回调订单失败的分账单子操作失败，异常信息{}", LocalDateTime.now(), e);
      return ApiResponse.createBusFailRespons(e);
    }
  }

}
