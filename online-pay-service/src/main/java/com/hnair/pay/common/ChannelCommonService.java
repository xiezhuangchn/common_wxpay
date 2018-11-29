package com.hnair.pay.common;

import com.hnair.pay.common.enums.EnvConfigEnum;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.response.PayPlatformBaseResponse;
import com.hnair.pay.common.utils.IPUtil;
import com.hnair.pay.common.utils.PayCoreSignUtil;
import com.hnair.pay.db.dao.mapper.ProductChannelConfigMapper;
import com.hnair.pay.db.entity.ProductChannelConfig;
import com.hnair.pay.db.entity.ProductChannelConfigExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有service公用
 */
@Service
public class ChannelCommonService {

    private final Logger logger = LoggerFactory.getLogger(ChannelCommonService.class);

    @Value("${env}")
    private String env;

    @Autowired
    private ProductChannelConfigMapper productChannelConfigMapper;

    private final static Map<String,String> SIGN_KEY_MAP = new HashMap<>();

    private final static Map<String,String> PAY_NOTIFY_URL_MAP = new HashMap<>();

    private final static Map<String,String> REFUND_NOTIFY_URL_MAP = new HashMap<>();

    private final static Map<String,String> SHARING_NOTIFY_URL_MAP = new HashMap<>();

    /**
     * 创建支付平台公共响应
     * @param resp
     * @param baseDto
     * @return
     */
    public PayPlatformBaseResponse createPayPlatformCommonResponse(PayPlatformBaseResponse resp, PayPlatformBaseRequest baseDto){
        resp.setProductAppId(baseDto.getProductAppId());
        resp.setBusChannel(baseDto.getBusChannel());
        resp.setPayChannelType(baseDto.getPayChannelType());
        resp.setServerIp(IPUtil.getServerIP());
        resp.setResTimeStamp(String.valueOf(System.currentTimeMillis()));
        resp.setSign(this.getSign(resp));
        return resp;
    }

    /**
     * 校验sign
     * @param dto
     */
    public boolean checkSign(PayPlatformBaseRequest dto) {
        Map<String, String> params = new HashMap<>();
        params.put("productAppId",dto.getProductAppId());
        params.put("busChannel",dto.getBusChannel());
        params.put("payChannelType",dto.getPayChannelType());
        params.put("timeStamp",dto.getTimeStamp());
        params.put("serverIp",dto.getServerIp());
        params.put("sign",dto.getSign());

        return PayCoreSignUtil.checkMD5Sign(params, this.getSignKeyByProAppId(dto.getProductAppId()));
    }

    /**
     * 获取sign
     * @param baseResp
     * @return
     */
    public String getSign(PayPlatformBaseResponse baseResp){
        Map<String, String> params = new HashMap<>();
        params.put("productAppId",baseResp.getProductAppId());
        params.put("busChannel",baseResp.getBusChannel());
        params.put("payChannelType",baseResp.getPayChannelType());
        params.put("serverIp",baseResp.getServerIp());
        params.put("resTimeStamp",baseResp.getResTimeStamp());

        return PayCoreSignUtil.createMD5Sign(params, this.getSignKeyByProAppId(baseResp.getProductAppId()));
    }

    /**
     *通过产品线获取signKey
     */
    public String getSignKeyByProAppId(String productAppId) {
        String signKey = SIGN_KEY_MAP.get(productAppId);

        if(StringUtils.isEmpty(signKey)){
            refreshAllChannelConfigMap();
        }

        return SIGN_KEY_MAP.get(productAppId);
    }

    /**
     *通过产品渠道获取 payNotifyUrl
     */
    public String getPayNotifyUrlByChannel(String busChannel) {
        String payNotifyUrl = PAY_NOTIFY_URL_MAP.get(busChannel);

        if(StringUtils.isEmpty(payNotifyUrl)){
            refreshAllChannelConfigMap();
        }

        return PAY_NOTIFY_URL_MAP.get(busChannel);
    }

    /**
     *通过产品渠道获取 refundNotifyUrl
     */
    public String getRefundNotifyUrlByChannel(String busChannel) {
        String refundNotifyUrl = REFUND_NOTIFY_URL_MAP.get(busChannel);

        if(StringUtils.isEmpty(refundNotifyUrl)){
            refreshAllChannelConfigMap();
        }

        return REFUND_NOTIFY_URL_MAP.get(busChannel);
    }

    /**
     *通过产品渠道获取 sharingNotifyUrl
     */
    public String getSharingNotifyUrlByChannel(String busChannel) {
        String sharingNotifyUrl = SHARING_NOTIFY_URL_MAP.get(busChannel);

        if(StringUtils.isEmpty(sharingNotifyUrl)){
            refreshAllChannelConfigMap();
        }

        return SHARING_NOTIFY_URL_MAP.get(busChannel);
    }

    /**
     *刷新所有的配置
     */
    public void refreshAllChannelConfigMap() {
        ProductChannelConfigExample example = new ProductChannelConfigExample();
        List<ProductChannelConfig> productLineSignKeys = productChannelConfigMapper.selectByExample(example);
        if(CollectionUtils.isNotEmpty(productLineSignKeys)){
            for (ProductChannelConfig productChannelConfig : productLineSignKeys) {
                SIGN_KEY_MAP.put(productChannelConfig.getProductAppId(),productChannelConfig.getSignKey());
                if(env.equalsIgnoreCase(EnvConfigEnum.HUIDU.getCode())){
                    PAY_NOTIFY_URL_MAP.put(productChannelConfig.getBusChannel(),productChannelConfig.getHuiduPayNotifyUrl());
                    REFUND_NOTIFY_URL_MAP.put(productChannelConfig.getBusChannel(),productChannelConfig.getHuiduRefundNotifyUrl());
                    SHARING_NOTIFY_URL_MAP.put(productChannelConfig.getBusChannel(),productChannelConfig.getHuiduSharingNotifyUrl());
                }else{
                    PAY_NOTIFY_URL_MAP.put(productChannelConfig.getBusChannel(),productChannelConfig.getPayNotifyUrl());
                    REFUND_NOTIFY_URL_MAP.put(productChannelConfig.getBusChannel(),productChannelConfig.getRefundNotifyUrl());
                    SHARING_NOTIFY_URL_MAP.put(productChannelConfig.getBusChannel(),productChannelConfig.getSharingNotifyUrl());
                }
            }
        }
    }

}
