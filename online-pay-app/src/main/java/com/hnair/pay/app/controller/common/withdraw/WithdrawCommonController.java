package com.hnair.pay.app.controller.common.withdraw;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.enums.OrderChannelEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.wx.CreateWxEntPayOrderRequest;
import com.hnair.pay.common.models.dto.request.wx.QueryWxEntPayBankOrderRequest;
import com.hnair.pay.common.models.dto.request.wx.QueryWxEntPayOrderRequest;
import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import com.hnair.pay.common.models.dto.response.wx.QueryWxEntPayBankOrderResponse;
import com.hnair.pay.common.utils.IPUtil;
import com.hnair.pay.wx.WxEntPayService;
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

import javax.servlet.http.HttpServletRequest;

/**
 * 各个渠道 统一提现入口
 */
@Controller
@RequestMapping("/commonWithdraw/")
@Api(value = "commonWithdraw", tags = "各个渠道 --提现入口")
public class WithdrawCommonController {

    private final Logger logger = LoggerFactory.getLogger("WithdrawCommonController");

    @Autowired
    private WxEntPayService wxEntPayService;
    @Autowired
    private ChannelCommonService channelCommonService;

    /**
     * 企业付款
     */
    @ApiOperation(value = "创建企业付款订单", notes = "创建企业付款订单")
    @PostMapping("createEntPayOrder")
    @ResponseBody
    public ApiResponse<PayPlatformBaseResponse> createEntPayOrder(HttpServletRequest request,
                                                                  @RequestBody @Validated PayPlatformBaseRequest dto, BindingResult result) {
        try {
            logger.info("createEntPayOrder param:" + JSON.toJSONString(dto));
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
                CreateWxEntPayOrderRequest req = JSON.parseObject(dto.getData(), CreateWxEntPayOrderRequest.class);
                return ApiResponse.success(wxEntPayService.createWxEntPayOrder(req, dto, IPUtil.getIpAddr(request)));
            } else {
                return ApiResponse.fail("目前只支持微官网 orderFrom=01");
            }
        } catch (Exception e) {
            logger.error("createEntPayOrder error,param:" + JSON.toJSONString(dto), e);
            return ApiResponse.createBusFailRespons(e);
        }

    }

    /**
     * 查询企业付款订单
     */
    @ApiOperation(value = "查询企业付款订单", notes = "查询企业付款订单")
    @PostMapping("queryEntPayOrder")
    @ResponseBody
    public ApiResponse<PayPlatformBaseResponse> queryEntPayOrder(
            @RequestBody @Validated PayPlatformBaseRequest dto, BindingResult result) {
        try {
            logger.info("queryEntPayOrder param:" + JSON.toJSONString(dto));
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
                QueryWxEntPayOrderRequest req = JSON.parseObject(dto.getData(), QueryWxEntPayOrderRequest.class);
                return ApiResponse.success(wxEntPayService.queryWxEntPayOrder(req, dto));
            } else {
                return ApiResponse.fail("目前只支持微官网 orderFrom=01");
            }
        } catch (Exception e) {
            logger.error("queryEntPayOrder error,param:" + JSON.toJSONString(dto), e);
            return ApiResponse.createBusFailRespons(e);
        }

    }

    /**
     * 企业付款到银行卡
     */
    //@ApiOperation(value = "创建企业付款到银行卡订单", notes = "创建企业付款到银行卡订单")
    //@PostMapping("createEntPayBankOrder")
    //@ResponseBody
    //public ApiResponse<PayPlatformBaseResponse> createEntPayBankOrder(HttpServletRequest request,
    //                                                                  @RequestBody @Validated CreateWxEntPayBankOrderRequest dto, BindingResult result) {
    //    try {
    //        logger.info("createEntPayBankOrder param:" + JSON.toJSONString(dto));
    //        if (result.hasErrors()) {
    //            for (ObjectError error : result.getAllErrors()) {
    //                return ApiResponse.fail(ErrorCode.PARAM_ERROR,
    //                        ErrorCode.PARAM_ERROR.getMsg() + error.getDefaultMessage());
    //            }
    //        }
    //
    //        wxEntPayService.createWxEntPayBankOrderTest(dto);
            //if (!channelCommonService.checkSign(dto)) {
            //    return ApiResponse.createBusFailRespons(new PayException(ErrorCode.SIGN_ERROR));
            //}

            //if (OrderChannelEnum.ORDER_FROM_WECHART.getCode().equals(dto.getBusChannel())) {
            //    CreateWxEntPayBankOrderRequest req = JSON.parseObject(dto.getData(), CreateWxEntPayBankOrderRequest.class);
            //    return ApiResponse.success(wxEntPayService.createWxEntPayBankOrder(req, dto, IPUtil.getIpAddr(request)));
            //} else {
            //    return ApiResponse.fail("目前只支持微官网 orderFrom=01");
            //}
    //        return null;
    //    } catch (Exception e) {
    //        logger.error("createEntPayBankOrder error,param:" + JSON.toJSONString(dto), e);
    //        return ApiResponse.createBusFailRespons(e);
    //    }
    //
    //}

    /**
     * 查询企业付款银行订单
     */
    @ApiOperation(value = "查询企业付款银行订单", notes = "查询企业付款银行订单")
    @PostMapping("queryEntPayBankOrder")
    @ResponseBody
    public ApiResponse<QueryWxEntPayBankOrderResponse> queryEntPayBankOrder(
            @RequestBody @Validated QueryWxEntPayBankOrderRequest dto, BindingResult result) {
        try {
            logger.info("queryEntPayBankOrder param:" + JSON.toJSONString(dto));
            if (result.hasErrors()) {
                for (ObjectError error : result.getAllErrors()) {
                    return ApiResponse.fail(ErrorCode.PARAM_ERROR,
                            ErrorCode.PARAM_ERROR.getMsg() + error.getDefaultMessage());
                }
            }

            return ApiResponse.success(wxEntPayService.queryWxEntPayBankOrder(dto));

        } catch (Exception e) {
            logger.error("queryEntPayBankOrder error,param:" + JSON.toJSONString(dto), e);
            return ApiResponse.createBusFailRespons(e);
        }

    }
}
