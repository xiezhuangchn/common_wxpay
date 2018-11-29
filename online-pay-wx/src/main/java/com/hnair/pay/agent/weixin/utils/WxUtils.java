package com.hnair.pay.agent.weixin.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hnair.pay.agent.weixin.Response.BaseWxPayResult;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 檢查微信返回
 */
public class WxUtils {

    /**
     * 从xml字符串创建bean对象.
     */
    public static <T extends BaseWxPayResult> T fromXML(String xmlString, Class<T> clz) {
        XStream xstream = XStreamInitializer.getInstance();
        xstream.processAnnotations(clz);
        T result = (T) xstream.fromXML(xmlString);
        result.setXmlString(xmlString);
        return result;
    }

    /**
     * 校验返回结果签名.
     *
     * @param signType        签名类型
     * @param checkSuccess    是否同时检查结果是否成功
     * @param mchKey
     * @throws WxPayException
     */
    public static void checkResult(String signType,
                                   boolean checkSuccess, BaseWxPayResult result, String mchKey) throws WxPayException {
        //校验返回结果签名
        Map<String, String> map = toMap(result);
        if (result.getSign() != null && !SignUtils.checkSign(map, signType, mchKey)) {
            throw new WxPayException("参数格式校验错误！");
        }
        //校验结果是否成功
        if (checkSuccess) {
            List<String> successStrings = Lists.newArrayList("SUCCESS", "");
            if (!successStrings.contains(StringUtils.trimToEmpty(result.getReturnCode()).toUpperCase())
                    || !successStrings.contains(StringUtils.trimToEmpty(result.getResultCode()).toUpperCase())) {
                StringBuilder errorMsg = new StringBuilder();
                if (result.getReturnCode() != null) {
                    errorMsg.append("返回代码：").append(result.getReturnCode());
                }
                if (result.getReturnMsg() != null) {
                    errorMsg.append("，返回信息：").append(result.getReturnMsg());
                }
                if (result.getResultCode() != null) {
                    errorMsg.append("，结果代码：").append(result.getResultCode());
                }
                if (result.getErrCode() != null) {
                    errorMsg.append("，错误代码：").append(result.getErrCode());
                }
                if (result.getErrCodeDes() != null) {
                    errorMsg.append("，错误详情：").append(result.getErrCodeDes());
                }
                throw WxPayException.from(result);
            } else {
                //nothing
            }
        }
    }

    /**
     * 将bean通过保存的xml字符串转换成map.
     */
    public static Map<String, String> toMap(BaseWxPayResult baseWxPayResult) {
        String xmlString = baseWxPayResult.getXmlString();
        if (StringUtils.isBlank(xmlString)) {
            throw new RuntimeException("xml為null，请核实！");
        }
        Map<String, String> result = Maps.newHashMap();
        Document doc = getXmlDoc(xmlString);
//        baseWxPayResult.setXmlDoc(doc); //返回結果
        try {
            NodeList list = (NodeList) XPathFactory
                    .newInstance()
                    .newXPath()
                    .compile("/xml/*")
                    .evaluate(doc, XPathConstants.NODESET);
            int len = list.getLength();
            for (int i = 0; i < len; i++) {
                result.put(list.item(i).getNodeName(), list.item(i).getTextContent());
            }
        } catch (XPathExpressionException e) {
            throw new RuntimeException("非法的xml文本内容：" + xmlString);
        }
        return result;
    }

    /**
     * 将xml字符串转换成Document对象，以便读取其元素值.
     *
     * @param xmlString
     * @return
     */
    private static Document getXmlDoc(String xmlString) {
        try {
            Document xmlDoc = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
            return xmlDoc;
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new RuntimeException("非法的xml文本内容：" + xmlString);
        }
    }

}
