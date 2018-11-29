package com.hnair.pay.app.controller.common.refund;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.enums.OrderChannelEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.refund.OrderRefundRequest;
import com.hnair.pay.common.models.dto.request.wx.RefundQueryRequest;
import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import com.hnair.pay.wx.WxRefundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 各个渠道 统一退款入口
 */
@Controller
@RequestMapping("/commonRefund/")
@Api(value = "commonRefund", tags = "各个渠道 --退款入口")
public class RefundCommonController {

    private final Logger logger = LoggerFactory.getLogger("RefundCommonController");

    @Autowired
    private WxRefundService refundService;
    @Autowired
    private ChannelCommonService channelCommonService;

    /**
     * 创建退款订单
     * @param dto
     * @param result
     * @return
     */
    @ApiOperation(value = "创建退款订单", notes = "创建退款订单")
    @PostMapping(value = "createRefundOrder")
    @ResponseBody
    public ApiResponse<PayPlatformBaseResponse> createRefundOrder(
            @RequestBody @Validated PayPlatformBaseRequest dto, BindingResult result) {
        try {
            logger.info("用户发起退款，请求报文信息为{}", JSON.toJSONString(dto));
            if (result.hasErrors()) { //入参基本校验
                for (ObjectError error : result.getAllErrors()) {
                    return ApiResponse.fail(error.getDefaultMessage());
                }
            }
            if (!channelCommonService.checkSign(dto)) {
                return ApiResponse.createBusFailRespons(new PayException(ErrorCode.SIGN_ERROR));
            }

            if (OrderChannelEnum.ORDER_FROM_WECHART.getCode().equals(dto.getBusChannel())) {
                OrderRefundRequest req = JSON.parseObject(dto.getData(), OrderRefundRequest.class);
                return ApiResponse.success(refundService.orderRefundInfoSave(req, dto));
            } else {
                return ApiResponse.fail("目前只支持微官网 orderFrom=01");
            }
        } catch (Exception e) {
            logger.error("refund  detail error,param:" + JSON.toJSONString(dto), e);
            return ApiResponse.fail(ErrorCode.ERR_SYSTEM, e.getMessage());
        }
    }

    /**
     * 查询退款订单
     * @param dto
     * @param result
     * @return
     */
    @ApiOperation(value = "查询退款订单", notes = "查询退款订单")
    @PostMapping("queryRefundOrder")
    @ResponseBody
    public ApiResponse<PayPlatformBaseResponse> queryRefundOrder(
            @RequestBody @Validated PayPlatformBaseRequest dto, BindingResult result) {
        try {
            logger.info("用户查询退款状态，请求报文信息为{}", JSON.toJSONString(dto));
            if (result.hasErrors()) { //入参基本校验
                for (ObjectError error : result.getAllErrors()) {
                    return ApiResponse.fail(error.getDefaultMessage());
                }
            }
            if (!channelCommonService.checkSign(dto)) {
                return ApiResponse.createBusFailRespons(new PayException(ErrorCode.SIGN_ERROR));
            }

            if (OrderChannelEnum.ORDER_FROM_WECHART.getCode().equals(dto.getBusChannel())) {
                RefundQueryRequest req = JSON.parseObject(dto.getData(), RefundQueryRequest.class);
                return ApiResponse.success(refundService.refundQuery(req, dto));
            } else {
                return ApiResponse.fail("目前只支持微官网 orderFrom=01");
            }
        } catch (Exception e) {
            logger.error("query refund detail error,param:" + JSON.toJSONString(dto), e);
            return ApiResponse.fail(ErrorCode.ERR_SYSTEM, e.getMessage());
        }

    }

}
