package com.hnair.pay.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 签名验证或者构建
 */
public class PayCoreSignUtil {

    /**
     * 校验签名是否正确.
     *
     * @param params   需要校验的参数Map
     * @param signKey  校验的签名Key
     * @return true - 签名校验成功，false - 签名校验失败
     */
    public static boolean checkMD5Sign(Map<String, String> params, String signKey) {
        String sign = createMD5Sign(params, signKey);
        return sign.equals(params.get("sign"));
    }

    /**
     * MD5签名生成
     * @param params
     * @param signKey
     * @return
     */
    public static String createMD5Sign(Map<String, String> params, String signKey) {
        SortedMap<String, String> sortedMap = new TreeMap<>(params);
        StringBuilder toSign = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            if(!"sign".equals(key)){
                String value = params.get(key);
                toSign.append(key).append("=").append(value).append("&");
            }
        }
        toSign.append("key=").append(signKey);
        return DigestUtils.md5Hex(toSign.toString()).toUpperCase();
    }

}
