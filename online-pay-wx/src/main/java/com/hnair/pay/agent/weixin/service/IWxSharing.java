package com.hnair.pay.agent.weixin.service;

import com.hnair.pay.agent.weixin.Request.WxProfitsharingaddreceiverRequest;
import com.hnair.pay.agent.weixin.Request.WxSharingAccountStatusRequest;
import com.hnair.pay.agent.weixin.Request.WxSharingRequest;
import com.hnair.pay.agent.weixin.Response.WxProfitsharingaddreceiverResponse;
import com.hnair.pay.agent.weixin.Response.WxSharingAccountStatusResponse;
import com.hnair.pay.agent.weixin.Response.WxSharingResult;
import com.hnair.pay.agent.weixin.exception.WxPayException;

/**
 * 微信分账相关接口.
 * bing.cheng
 */
public interface IWxSharing {

  /**
   * 发起分账请求
   * @param wxSharingRequest
   * @return
   * @throws WxPayException
   */
  WxSharingResult profitsharing(WxSharingRequest wxSharingRequest) throws WxPayException;

  /**
   * 查询微信分账处理的状态操作
   * @param request
   * @return
   * @throws WxPayException
   */
  WxSharingAccountStatusResponse queryShareAccountStatus(WxSharingAccountStatusRequest request) throws WxPayException;

  /**
   * 绑定分账关系
   * @param request
   * @return
   * @throws WxPayException
   */
  WxProfitsharingaddreceiverResponse wxProfitsharingaddreceiver(WxProfitsharingaddreceiverRequest request) throws WxPayException;


}
