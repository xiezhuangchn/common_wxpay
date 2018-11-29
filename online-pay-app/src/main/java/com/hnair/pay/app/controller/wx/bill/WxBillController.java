package com.hnair.pay.app.controller.wx.bill;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.agent.weixin.Response.WxPayBillResult;
import com.hnair.pay.common.models.dto.request.bill.DownloadBillRequest;
import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.wx.WxBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wxBill/")
@Api(value = "wxBill", tags = "微信 --对账单")
public class WxBillController {

    private final Logger logger = LoggerFactory.getLogger("WxBillController");

    @Autowired
    private WxBillService wxBillService;


    @ApiOperation(value = "查询对账单", notes = "查询对账单")
    @PostMapping("searchBill")
    @ResponseBody
    public ApiResponse<WxPayBillResult> searchWxPayOrder(
            @RequestBody DownloadBillRequest dto, BindingResult result) {
        try {
            logger.info("searchBill param:" + JSON.toJSONString(dto));
            if (result.hasErrors()) {
                for (ObjectError error : result.getAllErrors()) {
                    return ApiResponse.fail(ErrorCode.PARAM_ERROR,
                            ErrorCode.PARAM_ERROR.getMsg() + error.getDefaultMessage());
                }
            }
            WxPayBillResult res = wxBillService
                    .exportPayBill(dto);
            return ApiResponse.success(res);
        } catch (Exception e) {
            logger.error("searchBill error,param:" + JSON.toJSONString(dto), e);
            return ApiResponse.createBusFailRespons(e);
        }
    }
}
