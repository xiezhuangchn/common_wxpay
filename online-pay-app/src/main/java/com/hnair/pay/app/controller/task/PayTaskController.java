package com.hnair.pay.app.controller.task;

import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.pay.task.pay.CompesantPayTaskService;
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
 * @Author:chaoqiang.zhou
 * @Date:Create in 上午10:45 2018/7/24
 */

@Controller
@Api(value = "payTask", tags = "批处理 --推送支付状态到订单")
@RequestMapping("/task/pay/")
public class PayTaskController {

  private final Logger logger = LoggerFactory.getLogger(RefundTaskController.class);

  @Autowired
  private CompesantPayTaskService compesantPayTaskService;

  @GetMapping("/compesantPayTask")
  @ResponseBody
  @ApiOperation(value = "补偿订单支付状态到订单平台", httpMethod = "GET", notes = "微信支付状态同步操作")
  public ApiResponse<Boolean> compesantPushPayOrderStatus() {
    try {
      compesantPayTaskService.compesantPushPayOrderStatus();
      return ApiResponse.success(true);
    } catch (Exception e) {
      logger.info("compesantPushPayOrderStatus error {}", e);
      return ApiResponse.createBusFailRespons(e);
    }
  }

}
