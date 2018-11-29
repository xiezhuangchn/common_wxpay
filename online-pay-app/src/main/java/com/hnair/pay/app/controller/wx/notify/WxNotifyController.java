package com.hnair.pay.app.controller.wx.notify;

import com.hnair.pay.agent.weixin.Response.notify.WxPayNotifyResponse;
import com.hnair.pay.common.PayCommonService;
import com.hnair.pay.service.WxNotifyService;
import com.hnair.pay.wx.WxRefundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 微信回调
 */
@Controller
@RequestMapping("/wxNotify/")
@Api(value = "wxNotify", tags = "微信 --回调通知")
public class WxNotifyController {

  private final Logger logger = LoggerFactory.getLogger(WxNotifyController.class);

  @Autowired
  private PayCommonService payCommonService;

  @Autowired
  private WxNotifyService wxNotifyService;

  @Autowired
  private WxRefundService refundService;

  /**
   * 微信支付成功回调
   * @param httpServletRequest
   * @param httpServletResponse
   * @return
   */
  @ApiOperation(value = "微信异步支付通知接口", notes = "微信异步支付通知接口")
  @RequestMapping(value = "/notifyWeiXinPay", method = {RequestMethod.POST, RequestMethod.GET})
  public void notifyPayResult(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    String resultxml = null;
    try {
      resultxml = payCommonService.getStringFromHttpServletRequest(httpServletRequest, "notifyWeiXinPay");
      logger.info("微信支付成功回调date:{} xml报文：{}, ", LocalDateTime.now(), resultxml);

      //更新支付相关信息
      String busPayNo = wxNotifyService.notifyUpdatePayStatus(resultxml);

      // 更新推送订单通知结果信息
      if (StringUtils.isNotEmpty(busPayNo)) {
        wxNotifyService.notifyOrderPayStatus(busPayNo);
      }

      resultxml =  WxPayNotifyResponse.success("OK");
    } catch (Exception e) {
      logger.error("微信支付回调通知异常，异常信息{}", e);
      resultxml = WxPayNotifyResponse.fail("FAIL");
    }

    BufferedOutputStream out = null;
    try {
      out = new BufferedOutputStream(httpServletResponse.getOutputStream());
      out.write(resultxml.getBytes());
      out.flush();
    } catch (IOException e) {
      logger.error("处理(微信支付回调响应数据)异常，异常信息{}", e);
    } finally {
      try {
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 微信退款成功异步回调
   * @param httpServletRequest
   * @return
   */
  @ResponseBody
  @ApiOperation(value = "微信退款成功异步回调接口", notes = "微信退款成功异步回调接口")
  @RequestMapping(value = "notifyWxRefund", method = {RequestMethod.POST, RequestMethod.GET})
  public void wxNotifyRefundResult(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    String resultxml = null;
    try {
      //更新退款表相关信息
      String busRefundOrderNo = refundService.wxNotifyRefundResult(httpServletRequest);
      //微信回调同步更新订单系统 以后有需要改成全部异步也是可以的
      if (StringUtils.isNotEmpty(busRefundOrderNo)) {
        //通知订单退款成功 如果失败 异步在通知订单系统
        refundService.notifyRefundOrderStatus(busRefundOrderNo);
      }
      resultxml =  WxPayNotifyResponse.success("OK");
    } catch (Exception e) {
      logger.error("微信退款回调通知异常，异常信息{}", e);
      resultxml =  WxPayNotifyResponse.fail("FAIL");
    }
    BufferedOutputStream out = null;
    try {
      out = new BufferedOutputStream(httpServletResponse.getOutputStream());
      out.write(resultxml.getBytes());
      out.flush();
    } catch (IOException e) {
      logger.error("处理(微信退款回调响应数据)异常，异常信息{}", e);
    } finally {
      try {
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
