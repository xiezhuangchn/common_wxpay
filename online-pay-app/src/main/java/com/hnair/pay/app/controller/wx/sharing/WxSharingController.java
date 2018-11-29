package com.hnair.pay.app.controller.wx.sharing;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.models.dto.request.sharing.ProfitSharingAddReceiverRequest;
import com.hnair.pay.common.models.dto.request.sharing.ReceiverVo;
import com.hnair.pay.common.models.dto.response.ApiResponse;
import com.hnair.pay.common.models.dto.response.sharing.ProfitSharingAddReceiverResponse;
import com.hnair.pay.wx.WxSharingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 微信分账
 */
@Controller
@RequestMapping("/wxSharing/")
@Api(value = "wxSharing", tags = "微信 --分账相关")
public class WxSharingController {

  private final Logger logger = LoggerFactory.getLogger("WxSharingController");

  @Autowired
  private WxSharingService wxSharingService;

  /**
   * 綁定分账关系
   * @param request
   * @param result
   * @return
   */
  @ApiOperation(value = "綁定分账关系", notes = "綁定分账关系")
  @PostMapping("profitSharingAddReceiver")
  @ResponseBody
  public ApiResponse<ProfitSharingAddReceiverResponse> profitSharingAddReceiver (
          @RequestBody @Validated ProfitSharingAddReceiverRequest request, BindingResult result) {
    ProfitSharingAddReceiverResponse response = new ProfitSharingAddReceiverResponse();
    try {
      response = wxSharingService.profitSharingAddReceiver(request);
    } catch (Exception e) {
      response.setStatus(Boolean.FALSE);
      logger.error("綁定分账关系异常,请求报文{}" +  JSON.toJSONString(request), e);
    }
    return ApiResponse.success(response);
  }

  /**
   * 綁定分账关系 -- 分账接收方为我们平台自己,只需要传子商户信息
   * @return
   */
  @ApiOperation(value = "綁定分账关系(1 平台下的酒店的商户Id / 2 分账接收方,平台自己商户Id)", notes = "綁定分账关系(1 平台下的酒店的商户Id / 2 分账接收方,平台自己商户Id)")
  @GetMapping("/pushSharingStatusTask/{subMchId}/{recMchId}")
  @ResponseBody
  public ApiResponse<String> addOwnReceiverBySubMchMsg (
          @PathVariable String subMchId, @PathVariable String recMchId) {
    ProfitSharingAddReceiverResponse response = new ProfitSharingAddReceiverResponse();
    try {
      ProfitSharingAddReceiverRequest req = new ProfitSharingAddReceiverRequest();
      req.setSubMchId(subMchId);
      ReceiverVo receiver = new ReceiverVo();
      receiver.setType("MERCHANT_ID");
      receiver.setAccount(recMchId);
      receiver.setName("嗨途网络科技(深圳)有限公司");
      req.setReceiver(receiver);
      response = wxSharingService.profitSharingAddReceiver(req);
    } catch (Exception e) {
      logger.error("綁定分账关系异常,请求报文{}", e);
      return ApiResponse.fail("绑定失败");
    }
    if(response.getStatus()){
      return ApiResponse.success("绑定成功");
    }else{
      return ApiResponse.fail("绑定失败 微信返回错误信息:"+response.getErrorMsg());
    }

  }

}
