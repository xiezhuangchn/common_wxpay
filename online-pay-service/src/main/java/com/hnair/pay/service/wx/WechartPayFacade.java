package com.hnair.pay.service.wx;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.agent.weixin.constant.WxPayConstants;
import com.hnair.pay.common.models.dto.exception.PayException;
import com.hnair.pay.common.models.dto.request.PayPlatformBaseRequest;
import com.hnair.pay.common.models.dto.request.pay.BasePreCreateOrderRequest;
import com.hnair.pay.common.models.dto.request.pay.wx.CreateWechartWxJSAPIPayOrderRequest;
import com.hnair.pay.common.models.dto.response.ErrorCode;
import com.hnair.pay.common.models.dto.response.ValidationResult;
import com.hnair.pay.common.models.dto.response.pay.BasePreCreateOrderResponse;
import com.hnair.pay.common.utils.ValidationUtils;
import com.hnair.pay.service.wx.wechart.WeChartH5PayImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微官网支付门面service
 */
@Service
public class WechartPayFacade {

    @Autowired
    private WeChartH5PayImpl weChartH5PayImpl;

    /**
     * 微官网支付路由选择
     * @param dto
     * @return
     */
    public BasePreCreateOrderResponse createWechartWxPayOrder(PayPlatformBaseRequest dto) throws Exception{
        BasePreCreateOrderRequest tempReq = JSON.parseObject(dto.getData(), BasePreCreateOrderRequest.class);

        // 微信支付方式不一样（H5、APP、小程序）
        if (WxPayConstants.TradeType.JSAPI.equals(tempReq.getPayTradeType())) {
            //微官网支付 采用服务商支付模式
            CreateWechartWxJSAPIPayOrderRequest req = JSON.parseObject(dto.getData(), CreateWechartWxJSAPIPayOrderRequest.class);
            ValidationResult validResult = ValidationUtils.validateEntity(req);
            if(validResult.isHasErrors()){
                throw new RuntimeException(validResult.getErrorMsg().toString());
            }
            return weChartH5PayImpl.createWechartWxPayOrder(req, dto);
        } else {
            throw new PayException(ErrorCode.WX_PAY_TRADE_TYPE_NOT_SUPPORT);
        }
    }
}
