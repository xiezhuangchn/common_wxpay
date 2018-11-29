package com.hnair.pay.app.controller.task;

import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.pay.task.refund.RefundTaskService;
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
 * 退款相关批处理
 */
@Controller
@Api(value = "refundTask", tags = "批处理 --退款")
@RequestMapping("/task/refund/")
public class RefundTaskController {

    private final Logger logger = LoggerFactory.getLogger(RefundTaskController.class);

    @Autowired
    private RefundTaskService refundTaskService;

    /**
     * 异步发起退款批处理
     * @param status
     * @return
     */
    @GetMapping("/compesantRefundTask/{num}/{status}")
    @ResponseBody
    @ApiOperation(value = "异步发起退款-num为一次执行条数 limit num status:状态：0 待处理，1 处理中, -1 处理失败", httpMethod = "GET", notes = "发送退款请求发起")
    public ApiResponse<Boolean> compesantRefundTask(@PathVariable Integer num, @PathVariable Integer status) {
        try {
            refundTaskService.sendRefundTask(num, status);
            return ApiResponse.success(true);
        } catch (Exception e) {
            logger.info("补偿退款的任务操作失败，异常信息{}", e);
            return ApiResponse.createBusFailRespons(e);
        }
    }

    /**
     *  异步发起 退款发送成功 微信回调失败的退款单子
     * @param num
     * @return
     */
    @GetMapping("/queryRefundStatusTask/{num}")
    @ResponseBody
    @ApiOperation(value = "微信回调失败的退款单子-num为一次执行条数 limit num", httpMethod = "GET", notes = "查询退款状态任务发起")
    public ApiResponse<Boolean> queryRefundStatusTask(@PathVariable Integer num) {
        try {
            logger.info("时间{}，开始退款发送成功,微信回调失败的退款单子任务操作", LocalDateTime.now());
            refundTaskService.queryRefundStatusTask(num);
            return ApiResponse.success(true);
        } catch (Exception e) {
            logger.info("时间{}，退款发送成功,微信回调失败的退款单子操作失败，异常信息{}", LocalDateTime.now(), e);
            return ApiResponse.createBusFailRespons(e);
        }
    }


    /**
     *  查询处理30次扔未退款成功订单
     * @param num
     * @return
     */
    @GetMapping("/queryHandleTimesThan30/{num}")
    @ResponseBody
    @ApiOperation(value = "查询处理30次扔未退款成功订单-num为一次执行条数 limit num", httpMethod = "GET", notes = "查询处理31次还失败的退款订单")
    public ApiResponse<Boolean> queryHandleTimesThan31(@PathVariable Integer num) {
        try {
            logger.info("时间{}，开始查询处理30次扔未退款成功订单任务操作", LocalDateTime.now());
            refundTaskService.queryHandleTimesThan30(num);
            return ApiResponse.success(true);
        } catch (Exception e) {
            logger.info("时间{}，查询处理30次扔未退款成功订单操作失败，异常信息{}", LocalDateTime.now(), e);
            return ApiResponse.createBusFailRespons(e);
        }
    }



}