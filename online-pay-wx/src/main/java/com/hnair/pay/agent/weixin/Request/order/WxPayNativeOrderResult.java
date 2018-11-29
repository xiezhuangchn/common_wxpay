package com.hnair.pay.agent.weixin.Request.order;

/**
 * <pre>
 * 微信扫码支付统一下单后发起支付拼接所需参数实现类
 * </pre>
 *
 */
public class WxPayNativeOrderResult {
    private String codeUrl;

    public WxPayNativeOrderResult(String codeURL) {
      this.codeUrl = codeUrl;
    }

    public String getCodeUrl() {
    return codeUrl;
  }

   public void setCodeUrl(String codeUrl) {
    this.codeUrl = codeUrl;
  }
}
