package com.hnair.pay.app.controller.common.pay;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.enums.OrderChannelEnum;
import com.hnair.pay.common.enums.pay.PayChannelTypeEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.wx.NoNeedPayOrderCreatePayOrderRequest;
import com.hnair.pay.common.models.dto.request.wx.OrderCloseRequest;
import com.hnair.pay.common.models.dto.request.wx.OrderPayStatusSearchRequest;
import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import com.hnair.pay.service.IWxPayBus;
import com.hnair.pay.service.NeedPayOrderService;
import com.hnair.pay.wx.WxCloseService;
import com.hnair.pay.wx.WxSearchService;
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
 * 各个渠道 统一支付入口
 */
@Controller
@RequestMapping("/commonPay/")
@Api(value = "commonPay", tags = "各个渠道 --支付入口")
public class PayCommonController {

    private final Logger logger = LoggerFactory.getLogger(PayCommonController.class);

    @Autowired
    private IWxPayBus iWxPayBus;

    @Autowired
    private NeedPayOrderService needPayOrderService;

    @Autowired
    private WxSearchService wxSearchService;

    @Autowired
    private WxCloseService wxCloseService;

    @Autowired
    private ChannelCommonService channelCommonService;

    /**
     * 支付预下单
     */
    @ApiOperation(value = "支付预下单", notes = "支付预下单")
    @PostMapping("createPrePayOrder")
    @ResponseBody
    public ApiResponse<PayPlatformBaseResponse> createPrePayOrder(
            @RequestBody @Validated PayPlatformBaseRequest dto, BindingResult result){
        try {
            logger.info("createPrePayOrder param:" + JSON.toJSONString(dto));
            if (result.hasErrors()) {
                for (ObjectError error : result.getAllErrors()) {
                    return ApiResponse.fail(ErrorCode.PARAM_ERROR, ErrorCode.PARAM_ERROR.getMsg() + error.getDefaultMessage());
                }
            }
            if (!channelCommonService.checkSign(dto)) {
                return ApiResponse.createBusFailRespons(new PayException(ErrorCode.SIGN_ERROR));
            }

            //支付渠道判断 以后扩展支付渠道 目前只支持微信支付
            if (PayChannelTypeEnum.WX.getCode().equals(dto.getPayChannelType())) {
                return ApiResponse.success(iWxPayBus.preCreateOrder(dto));
            }
            else {
                return ApiResponse.fail("目前只支持微信支付");
            }
        } catch (Exception e) {
            logger.error("createPrePayOrder error,param:" + JSON.toJSONString(dto), e);
            return ApiResponse.createBusFailRespons(e);
        }
    }

    /**
     * 创建0元支付订单
     */
    @PostMapping("createNoNeedPayOrder")
    @ResponseBody
    @ApiOperation(value = "创建0元支付订单", httpMethod = "POST", notes = "创建0元支付订单")
    public ApiResponse<PayPlatformBaseResponse> createNoNeedPayOrder(
            @RequestBody @Validated PayPlatformBaseRequest dto, BindingResult result) {
        try {
            logger.info("createNoNeedPayOrder param:" + JSON.toJSONString(dto));
            if (result.hasErrors()) { //入参基本校验
                for (ObjectError error : result.getAllErrors()) {
                    return ApiResponse.fail(ErrorCode.PARAM_ERROR,
                            ErrorCode.PARAM_ERROR.getMsg() + error.getDefaultMessage());
                }
            }
            if (!channelCommonService.checkSign(dto)) {
                return ApiResponse.createBusFailRespons(new PayException(ErrorCode.SIGN_ERROR));
            }


            if (OrderChannelEnum.ORDER_FROM_WECHART.getCode().equals(dto.getBusChannel())) {
                NoNeedPayOrderCreatePayOrderRequest req = JSON.parseObject(dto.getData(), NoNeedPayOrderCreatePayOrderRequest.class);
                return ApiResponse.success(needPayOrderService.createNoNeedPayOrder(req, dto));
            } else {
                return ApiResponse.fail("目前只支持微官网 orderFrom=01");
            }
        } catch (Exception e) {
            logger.error("createNoNeedPayOrder error,param:" + JSON.toJSONString(dto), e);
            return ApiResponse.createBusFailRespons(e);
        }
    }

    /**
     * 查询订单支付状态
     */
    @ApiOperation(value = "查询订单支付状态", notes = "查询订单支付状态")
    @PostMapping("queryPayOrder")
    @ResponseBody
    public ApiResponse<PayPlatformBaseResponse> queryPayOrder(
            @RequestBody PayPlatformBaseRequest dto, BindingResult result) {
        try {
            logger.info("searchPayOrder param:" + JSON.toJSONString(dto));
            if (result.hasErrors()) {
                for (ObjectError error : result.getAllErrors()) {
                    return ApiResponse.fail(ErrorCode.PARAM_ERROR,
                            ErrorCode.PARAM_ERROR.getMsg() + error.getDefaultMessage());
                }
            }
            if (!channelCommonService.checkSign(dto)) {
                return ApiResponse.createBusFailRespons(new PayException(ErrorCode.SIGN_ERROR));
            }

            if (OrderChannelEnum.ORDER_FROM_WECHART.getCode().equals(dto.getBusChannel())) {
                OrderPayStatusSearchRequest req = JSON.parseObject(dto.getData(), OrderPayStatusSearchRequest.class);
                return ApiResponse.success(wxSearchService.queryOrderPayStatus(req, dto));
            } else {
                return ApiResponse.fail("目前只支持微官网 orderFrom=01");
            }
        } catch (Exception e) {
            logger.error("searchPayOrder error,param:" + JSON.toJSONString(dto), e);
            return ApiResponse.createBusFailRespons(e);
        }
    }

    /**
     * 关闭支付订单
     */
    @ApiOperation(value = "关闭支付订单", notes = "关闭支付订单")
    @PostMapping("closePayOrder")
    @ResponseBody
    public ApiResponse<PayPlatformBaseResponse> closePayOrder(
            @RequestBody PayPlatformBaseRequest dto, BindingResult result) {
        try {
            logger.info("closePayOrder param:" + JSON.toJSONString(dto));
            if (result.hasErrors()) {
                for (ObjectError error : result.getAllErrors()) {
                    return ApiResponse.fail(ErrorCode.PARAM_ERROR,
                            ErrorCode.PARAM_ERROR.getMsg() + error.getDefaultMessage());
                }
            }
            if (!channelCommonService.checkSign(dto)) {
                return ApiResponse.createBusFailRespons(new PayException(ErrorCode.SIGN_ERROR));
            }

            if (OrderChannelEnum.ORDER_FROM_WECHART.getCode().equals(dto.getBusChannel())) {
                OrderCloseRequest req = JSON.parseObject(dto.getData(), OrderCloseRequest.class);
                return ApiResponse.success(wxCloseService.closeWxPayOrder(req, dto));
            } else {
                return ApiResponse.fail("目前只支持微官网 orderFrom=01");
            }
        } catch (Exception e) {
            logger.error("closePayOrder error,param:" + JSON.toJSONString(dto), e);
            return ApiResponse.createBusFailRespons(e);
        }
    }

}
