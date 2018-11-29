package com.hnair.pay.wx;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.agent.weixin.Request.entpay.EntPayBankRequest;
import com.hnair.pay.agent.weixin.Request.entpay.EntPayRequest;
import com.hnair.pay.agent.weixin.Response.entpay.EntPayBankQueryResult;
import com.hnair.pay.agent.weixin.Response.entpay.EntPayBankResult;
import com.hnair.pay.agent.weixin.Response.entpay.EntPayQueryResult;
import com.hnair.pay.agent.weixin.Response.entpay.EntPayResult;
import com.hnair.pay.agent.weixin.constant.WxPayConstants;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.IWxEntPay;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.enums.withdraw.WithdrawStatusEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.wx.CreateWxEntPayBankOrderRequest;
import com.hnair.pay.common.models.dto.request.wx.CreateWxEntPayOrderRequest;
import com.hnair.pay.common.models.dto.request.wx.QueryWxEntPayBankOrderRequest;
import com.hnair.pay.common.models.dto.request.wx.QueryWxEntPayOrderRequest;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import com.hnair.pay.common.models.dto.response.wx.CreateWxEntPayBankOrderResponse;
import com.hnair.pay.common.models.dto.response.wx.CreateWxEntPayOrderResponse;
import com.hnair.pay.common.models.dto.response.wx.QueryWxEntPayBankOrderResponse;
import com.hnair.pay.common.models.dto.response.wx.QueryWxEntPayOrderResponse;
import com.hnair.pay.common.utils.TimeUtil;
import com.hnair.pay.db.dao.mapper.WithdrawOrderMapper;
import com.hnair.pay.db.entity.WithdrawOrder;
import com.hnair.pay.db.entity.WithdrawOrderExample;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 微信企业付款
 */
@Service
public class WxEntPayService {

  private final Logger logger = LoggerFactory.getLogger("WxEntPayService");

  @Autowired
  private IWxEntPay entPayService;
  @Autowired
  private ChannelCommonService channelCommonService;

  @Autowired
  protected WithdrawOrderMapper withdrawOrderMapper;

  /**
   * 企业付款
   */
  @Transactional
  public PayPlatformBaseResponse createWxEntPayOrder(CreateWxEntPayOrderRequest req, PayPlatformBaseRequest dto, String clientIP) throws Exception {
    CreateWxEntPayOrderResponse resp = new CreateWxEntPayOrderResponse();

    // 查询本地是否有记录流水
    WithdrawOrder withdrawOrder = queryWithdrawOrder(req.getWithdrawOrderNo());
    if(null == withdrawOrder){
      saveWithdrawOrder(req, dto);
    }else if(WithdrawStatusEnum.SUCCESSFUL_PAYMENT.getCode().byteValue() == withdrawOrder.getStatus()){
      createEntPayResponseNoReqWx(resp, withdrawOrder);
      return resp;
    }

    EntPayRequest request = new EntPayRequest();
    createEntPayRequest(req, request, clientIP);

    EntPayResult result = null;
    try {
      result = entPayService.entPay(request);
    } catch (WxPayException e) {
      logger.error("createWxEntPayOrder error,param:" + JSON.toJSONString(req), e);
      throw new PayException(ErrorCode.REQUEST_WX_RESPONSE_ERROR.getCode(),e.getMessage());
    }

    // 更新本地流水记录
    updateWithdrawOrder(req.getWithdrawOrderNo(), result);

    createEntPayResponse(resp, result);
    return channelCommonService.createPayPlatformCommonResponse(resp, dto);
  }

  private void createEntPayResponseNoReqWx(CreateWxEntPayOrderResponse resp, WithdrawOrder withdrawOrder){

    resp.setBusPayNo(withdrawOrder.getWithdrawOrderNo());
    resp.setPaymentNo(withdrawOrder.getWithdrawTradeNo());
    resp.setPaymentTime(TimeUtil.format_yyyy_MM_dd_HH_mm_ss(withdrawOrder.getUpdateTime()));

  }

  private void updateWithdrawOrder(String withdrawOrderNo, EntPayResult result){
    WithdrawOrder record = new WithdrawOrder();
    record.setUpdateTime(new Date());
    record.setStatus(WithdrawStatusEnum.SEND_ENTERPRISE_PAYMENT_SUCCESSFULLY.getCode().byteValue());
    record.setWithdrawTradeNo(result.getPaymentNo());

    WithdrawOrderExample example = new WithdrawOrderExample();
    example.createCriteria().andWithdrawOrderNoEqualTo(withdrawOrderNo);
    withdrawOrderMapper.updateByExampleSelective(record, example);
  }

  private void saveWithdrawOrder(CreateWxEntPayOrderRequest req, PayPlatformBaseRequest dto){
    Date curTime = new Date();

    WithdrawOrder withdrawOrder = new WithdrawOrder();

    withdrawOrder.setWithdrawOrderNo(req.getWithdrawOrderNo());
    withdrawOrder.setMarketingPersonId(req.getMarketingPersonId());
    withdrawOrder.setWithdrawFee(req.getAmount());
    withdrawOrder.setFeeType(req.getFeeType());
    withdrawOrder.setBusChannel(dto.getBusChannel());
    withdrawOrder.setPayChannelType(dto.getPayChannelType());
    withdrawOrder.setStatus(WithdrawStatusEnum.IN_HAND.getCode().byteValue());
    withdrawOrder.setUpdateTime(curTime);
    withdrawOrder.setCreateTime(curTime);

    withdrawOrderMapper.insertSelective(withdrawOrder);
  }

  private WithdrawOrder queryWithdrawOrder(String withdrawOrderNo){
    WithdrawOrderExample example = new WithdrawOrderExample();
    example.createCriteria().andWithdrawOrderNoEqualTo(withdrawOrderNo);
    List<WithdrawOrder> withdrawOrders = withdrawOrderMapper.selectByExample(example);

    if(CollectionUtils.isEmpty(withdrawOrders)){
      return null;
    }

    return withdrawOrders.get(0);
  }

  /**
   * 查询企业付款
   */
  @Transactional
  public PayPlatformBaseResponse queryWxEntPayOrder(QueryWxEntPayOrderRequest req, PayPlatformBaseRequest dto) throws Exception {
    QueryWxEntPayOrderResponse resp = new QueryWxEntPayOrderResponse();
    resp.setStatus(Boolean.TRUE);

    EntPayQueryResult result = null;
    try {
      result = entPayService.queryEntPay(req.getWithdrawOrderNo());
    } catch (WxPayException e) {
      logger.error("queryWxEntPayOrder error,param:" + JSON.toJSONString(req), e);
      resp.setStatus(Boolean.FALSE);
      resp.setErrorMsg(e.getMessage());
      return resp;
    }

    if(null == result){
      resp.setStatus(Boolean.FALSE);
      return resp;
    }
    if(!WxPayConstants.ResultCode.SUCCESS.equalsIgnoreCase(result.getStatus())){
      resp.setStatus(Boolean.FALSE);
      resp.setErrorMsg(result.getReason());
    }

    return channelCommonService.createPayPlatformCommonResponse(resp, dto);
  }


  private void createEntPayResponse(CreateWxEntPayOrderResponse resp, EntPayResult result){

    resp.setBusPayNo(result.getPartnerTradeNo());
    resp.setPaymentNo(result.getPaymentNo());
    resp.setPaymentTime(result.getPaymentTime());

  }

  private void createEntPayRequest(CreateWxEntPayOrderRequest dto, EntPayRequest request, String clientIP){

    request.setPartnerTradeNo(dto.getWithdrawOrderNo());
    request.setOpenid(dto.getOpenid());
    request.setCheckName(WxPayConstants.CheckNameOption.NO_CHECK);
    request.setAmount(dto.getAmount());
    request.setDescription("营销奖励金");
    request.setSpbillCreateIp(clientIP);

  }

  /**
   * 企业付款到银行卡
   * @param req
   * @param dto
   * @param ipAddr
   * @return
   * @throws WxPayException
   */
  public PayPlatformBaseResponse createWxEntPayBankOrder(CreateWxEntPayBankOrderRequest req, PayPlatformBaseRequest dto, String ipAddr) throws WxPayException {
    CreateWxEntPayBankOrderResponse resp = new CreateWxEntPayBankOrderResponse();
    EntPayBankRequest wxRequest = new EntPayBankRequest();
    createEntPayBankRequest(req,wxRequest,ipAddr);
    EntPayBankResult result =null;
    try {
      result =  entPayService.payBank(wxRequest);
    } catch (WxPayException e) {
      logger.error("createWxEntPayBankOrder error,param:" + JSON.toJSONString(req), e);
      throw new PayException(ErrorCode.REQUEST_WX_RESPONSE_ERROR.getCode(),e.getMessage());
    }
    createEntPayBankResponse(resp, result);
    return channelCommonService.createPayPlatformCommonResponse(resp, dto);
  }

  private void createEntPayBankResponse(CreateWxEntPayBankOrderResponse resp, EntPayBankResult result) {
      resp.setAmount(result.getAmount());
      resp.setCmmsAmount(result.getCmmsAmount());
      resp.setPartnerTradeNo(result.getPartnerTradeNo());
      resp.setPaymentNo(result.getPaymentNo());
  }

  private void createEntPayBankRequest(CreateWxEntPayBankOrderRequest dto, EntPayBankRequest request, String ipAddr){
      request.setEncBankNo(dto.getEncBankNo());
      request.setEncTrueName(dto.getEncTrueName());
      request.setAmount(dto.getAmount());
      request.setBankCode(dto.getBankCode());
      request.setPartnerTradeNo(dto.getPartnerTradeNo());
      request.setDescription("企业付款到银行");

  }

  /**
   * 企业打款到银行卡(测试)
   * @param dto
   * @throws WxPayException
   */
  public void createWxEntPayBankOrderTest(CreateWxEntPayBankOrderRequest dto) throws WxPayException {
    EntPayBankRequest wxRequest = new EntPayBankRequest();
    wxRequest.setDescription(dto.getDescription());
    wxRequest.setPartnerTradeNo(dto.getPartnerTradeNo());
    wxRequest.setBankCode(dto.getBankCode());
    wxRequest.setAmount(dto.getAmount());
    wxRequest.setEncTrueName(dto.getEncTrueName());
    wxRequest.setEncBankNo(dto.getEncBankNo());
    EntPayBankResult result  =  entPayService.payBank(wxRequest);

    System.out.println(JSON.toJSONString(result));


  }


  /**
   *企业打款到银行卡结果查询(测试)
   * @param dto
   * @return
   * @throws WxPayException
   */
  public QueryWxEntPayBankOrderResponse queryWxEntPayBankOrder(QueryWxEntPayBankOrderRequest dto) throws WxPayException {
    QueryWxEntPayBankOrderResponse res = new QueryWxEntPayBankOrderResponse();
    EntPayBankQueryResult result = entPayService.queryPayBank(dto.getPartnerTradeNo());
    res.setAmount(result.getAmount());
    res.setCmmsAmount(result.getCmmsAmount());
    res.setCreateTime(result.getCreateTime());
    res.setFailReason(result.getFailReason());
    res.setPartnerTradeNo(result.getPartnerTradeNo());
    res.setPaySuccessTime(result.getPaySuccessTime());
    res.setPaymentNo(result.getPaymentNo());
    res.setStatus(result.getStatus());
    res.setTrueName(result.getTrueNameMd5());
    res.setBankNo(result.getBankNoMd5());

    return  res;
  }
}
