package com.hnair.pay.wx;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.agent.weixin.Request.ReceiversVo;
import com.hnair.pay.agent.weixin.Request.WxProfitsharingaddreceiverRequest;
import com.hnair.pay.agent.weixin.Request.WxSharingAccountStatusRequest;
import com.hnair.pay.agent.weixin.Request.WxSharingRequest;
import com.hnair.pay.agent.weixin.Response.WxProfitsharingaddreceiverResponse;
import com.hnair.pay.agent.weixin.Response.WxSharingAccountStatusResponse;
import com.hnair.pay.agent.weixin.Response.WxSharingResult;
import com.hnair.pay.agent.weixin.constant.WxPayConstants;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.impl.WxSharingImpl;
import com.hnair.pay.common.ChannelCommonService;
import com.hnair.pay.common.PayCommonService;
import com.hnair.pay.common.enums.CallOrderStatusEnum;
import com.hnair.pay.common.enums.NoPreNoEnum;
import com.hnair.pay.common.enums.pay.PayStatusEnum;
import com.hnair.pay.common.enums.sharing.SharingBindingInfoStatusEnum;
import com.hnair.pay.common.enums.sharing.SharingStatusEnum;
import com.hnair.pay.common.enums.sharing.SharingTypeEnum;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.sharing.CreateSharingOrderRequest;
import com.hnair.pay.common.models.dto.request.sharing.ProfitSharingAddReceiverRequest;
import com.hnair.pay.common.models.dto.request.sharing.ReceiverVo;
import com.hnair.pay.common.models.dto.request.sharing.WechatSharingRequest;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import com.hnair.pay.common.models.dto.response.sharing.CreateSharingOrderResponse;
import com.hnair.pay.common.models.dto.response.sharing.ProfitSharingAddReceiverResponse;
import com.hnair.pay.common.models.dto.response.sharing.WechatSharingResponse;
import com.hnair.pay.db.dao.mapper.PayOrderMapper;
import com.hnair.pay.db.dao.mapper.ProfitsharingOrderMapper;
import com.hnair.pay.db.dao.mapper.SharingBindingInfoMapper;
import com.hnair.pay.db.entity.*;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WxSharingService {

  private final Logger logger = LoggerFactory.getLogger("WxSharingService");

  @Autowired
  private ProfitsharingOrderMapper profitsharingOrderMapper;
  @Autowired
  private PayOrderMapper payOrderMapper;
  @Autowired
  private SharingBindingInfoMapper sharingBindingInfoMapper;

  @Autowired
  private PayCommonService payCommonService;
  @Autowired
  private WxSharingImpl wxSharingImpl;
  @Autowired
  private ChannelCommonService channelCommonService;

  /**
   * 创建微信分账订单
   */
  public WechatSharingResponse createSharingOrder(WechatSharingRequest req) throws WxPayException {
    WechatSharingResponse res = new WechatSharingResponse();
    //0元 不需要发起微信分账请求
    if (req.getSharingFee().intValue() == 0) {
      res.setBusPayNo(req.getBusPayNo());
      res.setSharingOrderNo(req.getSharingOrderNo());
      res.setSharingTradeNo("NO" + req.getSharingOrderNo());
      res.setStatus(true);
      return res;
    }

    WxSharingResult result = new WxSharingResult();
    PayOrder payOrder = getPayOrder(req.getBusPayNo());
    WxSharingRequest wxSharingRequest = createWxSharingRequest(payOrder, req);
    logger.info("createSharingOrder busOrderId = {}, req:{}", req.getBusPayNo(),
            JSON.toJSONString(wxSharingRequest));
    try {
      result = wxSharingImpl.profitsharing(wxSharingRequest);
    } catch (Exception e) {
      logger.error("创建微信分账订单失败", e);
      throw new PayException(ErrorCode.CREATE_WX_SHARING_ORDER_FAIL);
    }

    createWechatSharingRespResult(res, req, result);

    return res;
  }

  private void createWechatSharingRespResult(WechatSharingResponse res, WechatSharingRequest req, WxSharingResult result){

    res.setBusPayNo(req.getBusPayNo());
    res.setSharingOrderNo(req.getSharingOrderNo());
    res.setSharingTradeNo(result.getOrderId());
    res.setFailureReason(result.getErrCodeDes());
    if(WxPayConstants.ResultCode.SUCCESS.equals(result.getResultCode())){
      res.setStatus(true);
    }else{
      res.setStatus(false);
    }

  }

  public WxSharingAccountStatusResponse queryShareAccountStatus(
          WxSharingAccountStatusRequest request) {
    WxSharingAccountStatusResponse response = new WxSharingAccountStatusResponse();
    try {

      response = wxSharingImpl.queryShareAccountStatus(request);
    } catch (Exception e) {
      logger.error("查询微信分账状态失败，异常{}", e);
    }
    return response;

  }

  private PayOrder getPayOrder(String busPayNo) {
    PayOrderExample example = new PayOrderExample();
    /**
     * 微信支付订单号
     */
    example.createCriteria().andBusPayNoEqualTo(busPayNo);
    List<PayOrder> payOrders = payOrderMapper.selectByExample(example);
    if (CollectionUtils.isEmpty(payOrders)) {
      throw new PayException(ErrorCode.ORDER_IS_NOT_EXST);
    }
    return payOrders.get(0);
  }

  private WxSharingRequest createWxSharingRequest(PayOrder payOrder,  WechatSharingRequest dto) {
    WxSharingRequest req = new WxSharingRequest();
    req.setSubMchId(payOrder.getSubMchId());
    req.setSubAppId(payOrder.getSubAppId());
    req.setTransactionId(payOrder.getTradePayNo());
    req.setOutOrderNo(dto.getSharingOrderNo());

    List<ReceiversVo> receiversList = new ArrayList<>();
    ReceiversVo vo = new ReceiversVo();
    vo.setType(dto.getSharingAccountType());
    vo.setAccount(dto.getSharingAccount());
    vo.setDescription(dto.getSharingDesc());

    // 根据分账类型,构建微信分账请求参数
    if(SharingTypeEnum.NO_MARKETING_SHARING.getCode().byteValue() == dto.getSharingType()){
      vo.setAmount(dto.getSharingFee());
      receiversList.add(vo);
    }else if(SharingTypeEnum.HAVE_MARKETING_SHARING_THAN_REMITTANCE.getCode().byteValue() == dto.getSharingType()){
      vo.setAmount(dto.getSharingFee());
      receiversList.add(vo);
    }else if(SharingTypeEnum.HAVE_MARKETING_AUTO_SHARING.getCode().byteValue() == dto.getSharingType()){
      vo.setAmount(dto.getPlatformSharingFee());
      receiversList.add(vo);

      List<ReceiversVo> receiversVos = JSON.parseArray(dto.getSharingReceivers(), ReceiversVo.class);
      Boolean tag = Boolean.TRUE;
      ProfitSharingAddReceiverResponse errorResp = new ProfitSharingAddReceiverResponse();
      ReceiversVo errorReceivers = new ReceiversVo();
      if(CollectionUtils.isNotEmpty(receiversVos)){
        for (ReceiversVo receiversVo : receiversVos) {
          // 调用微信分账绑定接口,进行分账关系绑定
          ProfitSharingAddReceiverRequest addReceiverReq = new ProfitSharingAddReceiverRequest();
          buildAddReceiverReq(addReceiverReq, payOrder, receiversVo);
          ProfitSharingAddReceiverResponse addReceiverResp = profitSharingAddReceiver(addReceiverReq);

          if(!addReceiverResp.getStatus()){
            tag = Boolean.FALSE;
            errorResp = addReceiverResp;
            errorReceivers = receiversVo;
          }
        }

      }

      if(!tag){
        throw new PayException("调用微信分账绑定接口,进行分账关系绑定失败,失败者 openId : {"+errorReceivers.getAccount()
                +"} 微信返回错误信息 : {"+errorResp.getErrorMsg()+"}");
      }

      receiversList.addAll(receiversVos);
    }

    req.setReceivers(JSON.toJSONString(receiversList));
    return req;
  }

  private void buildAddReceiverReq(ProfitSharingAddReceiverRequest addReceiverReq,
                                   PayOrder payOrder, ReceiversVo receiversVo){
    addReceiverReq.setSubMchId(payOrder.getSubMchId());
    addReceiverReq.setSubAppid(payOrder.getSubAppId());

    ReceiverVo receiver = new ReceiverVo();
    receiver.setType(receiversVo.getType());
    receiver.setAccount(receiversVo.getAccount());
    addReceiverReq.setReceiver(receiver);

  }

  /**
   * 分账信息存储
   */
  public PayPlatformBaseResponse createSharingOrder(CreateSharingOrderRequest req, PayPlatformBaseRequest baseDto)
      throws WxPayException {

    PayOrderExample payOrderExample = new PayOrderExample();
    payOrderExample.createCriteria().andBusPayNoEqualTo(req.getBusPayNo());
    List<PayOrder> payOrders = payOrderMapper.selectByExample(payOrderExample);
    if (CollectionUtils.isEmpty(payOrders)) {
      throw new PayException(ErrorCode.ORDER_IS_NOT_EXST);
    }

    ProfitsharingOrderExample sharingExample = new ProfitsharingOrderExample();
    sharingExample.createCriteria().andBusPayNoEqualTo(req.getBusPayNo());
    List<ProfitsharingOrder> profitsharingOrders = profitsharingOrderMapper.selectByExample(sharingExample);
    if(CollectionUtils.isNotEmpty(profitsharingOrders)){
      return createBusSendSharingInfo(profitsharingOrders.get(0), baseDto);
    }

    PayOrder payOrder = payOrders.get(0);
    if (payOrder.getPayStatus() != PayStatusEnum.PAY_SUCCESS.getCode().byteValue()) {
      throw new PayException(ErrorCode.ORDER_IS_NO_PAY_SUCCESS_NO_SHARING);
    }
    if (req.getSharingFee() > payOrder.getTotalFee()) {
      throw new PayException(ErrorCode.ORDER_SHARING_PRICE_LG_PAY_PRICE);
    }

    ProfitsharingOrder sharing = new ProfitsharingOrder();
    createProfitSharingOrder(sharing, req, payOrder);

    return createBusSendSharingInfo(sharing, baseDto);
  }

  private CreateSharingOrderResponse createBusSendSharingInfo(ProfitsharingOrder sharingOrder, PayPlatformBaseRequest baseDto){

    CreateSharingOrderResponse res = new CreateSharingOrderResponse();
    res.setBusOrderNo(sharingOrder.getBusOrderNo());
    res.setOrderType(sharingOrder.getBusType());
    res.setBusPayNo(sharingOrder.getBusPayNo());
    res.setSharingOrderNo(sharingOrder.getSharingOrderNo());
    res.setSharingStatus(sharingOrder.getSharingStatus().intValue());

    channelCommonService.createPayPlatformCommonResponse(res, baseDto);

    return res;
  }

  private void createProfitSharingOrder(ProfitsharingOrder profitsharingOrder,
                                        CreateSharingOrderRequest req, PayOrder payOrder) {
    Date curTime = new Date();

    profitsharingOrder.setSharingOrderNo(payCommonService.getNoByPayOrderInfo(payOrder, NoPreNoEnum.SHARING_NO_PREX.getCode()));
    profitsharingOrder.setBusChannel(req.getBusChannel());
    profitsharingOrder.setHotelId(payOrder.getHotelId());
    profitsharingOrder.setTradePayNo(payOrder.getTradePayNo());
    profitsharingOrder.setBusOrderNo(payOrder.getBusOrderNo());
    profitsharingOrder.setBusPayNo(payOrder.getBusPayNo());
    profitsharingOrder.setTotalFee(payOrder.getTotalFee());
    profitsharingOrder.setSharingAccountType(req.getSharingAccountType());
    profitsharingOrder.setSharingAccount(req.getSharingAccount());
    profitsharingOrder.setSharingFee(req.getSharingFee());
    profitsharingOrder.setSharingFeeType(req.getSharingFeeType());
    profitsharingOrder.setSharingDesc(req.getSharingDesc());
    profitsharingOrder.setSharingSendTime(curTime);
    //操作员帐号, 默认为商户号(退款发起者)
    profitsharingOrder.setOpUserId(payOrder.getHotelId());
    profitsharingOrder.setSharingStatus((byte) SharingStatusEnum.INIT.getCode());
    //发送状态（0 初始化  1:发送成功)
    profitsharingOrder.setSendStatus(CallOrderStatusEnum.INIT.getCode().byteValue());
    profitsharingOrder.setSubMchId(req.getSubMchId());
    profitsharingOrder.setBusType(req.getOrderType());
    profitsharingOrder.setUpdateTime(curTime);
    profitsharingOrder.setCreateTime(curTime);
    profitsharingOrder.setSharingType(req.getSharingType().byteValue());
    profitsharingOrder.setSharingReceivers(req.getSharingReceivers());
    profitsharingOrder.setPlatformSharingFee(req.getPlatformSharingFee());
    profitsharingOrder.setOtherSharingFee(req.getOtherSharingFee());
    profitsharingOrderMapper.insertSelective(profitsharingOrder);
  }

  /**
   * 调用微信model接口发起绑定
   * @param req
   * @return
   */
  public ProfitSharingAddReceiverResponse profitSharingAddReceiver(ProfitSharingAddReceiverRequest req) {
    ProfitSharingAddReceiverResponse res = new ProfitSharingAddReceiverResponse();

    // 查询DB是否已经存在绑定成功记录,如果有直接返回成功
    SharingBindingInfoExample queryExample = new SharingBindingInfoExample();
    queryExample.createCriteria().andHotelMchIdEqualTo(req.getSubMchId()).andReceiverMchIdEqualTo(req.getReceiver().getAccount())
            .andStatusEqualTo(SharingBindingInfoStatusEnum.SUCCESS.getCode());
    List<SharingBindingInfo> sharingBindingInfos = sharingBindingInfoMapper.selectByExample(queryExample);
    if(CollectionUtils.isNotEmpty(sharingBindingInfos)){
      res.setStatus(Boolean.TRUE);
      return res;
    }

    WxProfitsharingaddreceiverRequest wxreq = new WxProfitsharingaddreceiverRequest();
    wxreq.setReceiver(JSON.toJSONString(req.getReceiver()));
    wxreq.setSub_appid(req.getSubAppid());
    wxreq.setSub_mch_id(req.getSubMchId());
    WxProfitsharingaddreceiverResponse wxRes = null;
    try {
      wxRes = wxSharingImpl.wxProfitsharingaddreceiver(wxreq);
    } catch (Exception e) {
      logger.error("调用微信model接口发起绑定失败", e);
      res.setStatus(Boolean.FALSE);
      res.setErrorMsg(e.getMessage());
      return res;
    }

    if(wxRes != null && WxPayConstants.ResultCode.SUCCESS.equals(wxRes.getResultCode())){
      res.setStatus(Boolean.TRUE);
      res.setMchId(wxRes.getMchId());
      res.setSubMchId(wxRes.getSubMchId());
      res.setSubAppid(wxRes.getSubAppId());
      String receiver = wxRes.getReceiver();
      ReceiverVo receiverVo = JSON.parseObject(receiver, ReceiverVo.class);
      res.setAccount(receiverVo.getAccount());
      res.setType(receiverVo.getType());

      saveSharingBindingInfo(req);
    }else{
      res.setStatus(Boolean.FALSE);
    }

    return res;
  }

  private void saveSharingBindingInfo(ProfitSharingAddReceiverRequest req){
    Date cutTime = new Date();
    SharingBindingInfo info = new SharingBindingInfo();
    info.setHotelMchId(req.getSubMchId());
    info.setReceiverMchId(req.getReceiver().getAccount());
    info.setStatus(SharingBindingInfoStatusEnum.SUCCESS.getCode());
    info.setUpdateTime(cutTime);
    info.setCreateTime(cutTime);

    sharingBindingInfoMapper.insertSelective(info);
  }

}
