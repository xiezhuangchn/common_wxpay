package com.hnair.pay.app.controller.common.sharing;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.enums.OrderChannelEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.sharing.CreateSharingOrderRequest;
import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import com.hnair.pay.wx.WxSharingService;
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
 * 各个渠道 统一分账入口
 */
@Controller
@RequestMapping("/commonSharing/")
@Api(value = "commonSharing", tags = "各个渠道 --分账入口")
public class SharingCommonController {

    private final Logger logger = LoggerFactory.getLogger("SharingCommonController");

    @Autowired
    private WxSharingService wxSharingService;
    @Autowired
    private ChannelCommonService channelCommonService;


    @ApiOperation(value = "创建分账订单", notes = "创建分账订单")
    @PostMapping(value = "createSharingOrder")
    @ResponseBody
    public ApiResponse<PayPlatformBaseResponse> createSharingOrder(@RequestBody
                                                  @Validated PayPlatformBaseRequest dto, BindingResult result) {
        logger.info("createSharingOrder，parm {}", JSON.toJSONString(dto));
        try {
            if (result.hasErrors()) {
                for (ObjectError error : result.getAllErrors()) {
                    return ApiResponse.paramfail(error.getDefaultMessage());
                }
            }
            if (!channelCommonService.checkSign(dto)) {
                return ApiResponse.createBusFailRespons(new PayException(ErrorCode.SIGN_ERROR));
            }

            if (OrderChannelEnum.ORDER_FROM_WECHART.getCode().equals(dto.getBusChannel())) {
                CreateSharingOrderRequest req = JSON.parseObject(dto.getData(), CreateSharingOrderRequest.class);
                return ApiResponse.success(wxSharingService.createSharingOrder(req, dto));
            } else {
                return ApiResponse.fail("目前只支持微官网 orderFrom=01");
            }
        } catch (Exception e) {
            logger.error("createSharingOrder error,param:" + JSON.toJSONString(dto), e);
            return ApiResponse.createBusFailRespons(e);
        }
    }

}
