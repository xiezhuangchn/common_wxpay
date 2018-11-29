package com.hnair.pay.common;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.db.entity.PayOrder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * 所有service公用
 */
@Service
public class PayCommonService {

    private final Logger logger = LoggerFactory.getLogger("PayCommonService");

    @Autowired
    private OrderSequeneService orderSequeneService;

    /**
     * 根据payinfo信息构造相关号
     * @param payOrder
     * @param pre
     * @return
     */
    public String getNoByPayOrderInfo(PayOrder payOrder, String pre) {
        if (null == payOrder || StringUtils.isEmpty(payOrder.getBusChannel())
                || StringUtils.isEmpty(payOrder.getBusType())) {
            throw new RuntimeException("payOrder info error" + JSON.toJSONString(payOrder));
        }
        StringBuilder str = new StringBuilder();
        str.append(payOrder.getBusChannel());
        str.append(pre);
        str.append(payOrder.getBusType());

        str.append(payOrder.getBusPayNo());
        return str.toString();
    }

    /**
     * 获取HttpServletRequest的请求数据
     * @param request
     * @param from 哪一个接口名称
     * @return
     * @throws Exception
     */
    public String getStringFromHttpServletRequest(HttpServletRequest request, String from) throws Exception{
        BufferedReader reader = null;
        try {
            String reStr = null;
            String line = "";
            StringBuilder inputString = new StringBuilder();

            reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                inputString.append(line);
            }
            reStr = inputString.toString();
            return reStr;
        } catch (Exception e) {
            logger.error("getStringFromHttpServletRequest from request error,From：" + from, e);
            throw e;
        } finally {
            reader.close();
        }
    }

    /**
     * 获取唯一订单号
     * @return
     */
    public String getOrderNo() {
        String orderNo = null;
        try {
            orderNo = orderSequeneService.querySeqId();
        } catch (Exception e) {
            logger.error("getOrderNo error", e);
        }
        return orderNo;
    }


}
