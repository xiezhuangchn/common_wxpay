package com.hnair.pay.agent.weixin.config;

/**
 * <pre>
 * 微信支付接口请求数据封装对象
 * </pre>
 *
 */
public class WxPayApiData {
  /**
   * 接口请求地址
   */
  private String url;

  /**
   * 请求数据
   */
  private String requestData;

  /**
   * 响应数据
   */
  private String responseData;

  /**
   * 接口请求异常信息
   */
  private String exceptionMsg;

  /**
   * @param url          接口请求地址
   * @param requestData  请求数据
   * @param responseData 响应数据
   * @param exceptionMsg 接口请求异常信息
   */
  public WxPayApiData(String url, String requestData, String responseData, String exceptionMsg) {
    this.url = url;
    this.requestData = requestData;
    this.responseData = responseData;
    this.exceptionMsg = exceptionMsg;
  }

  @Override
  public String toString() {
    if (this.exceptionMsg != null) {
      return String.format("\n【请求地址】：%s\n【请求数据】：%s\n【异常信息】：%s",
        this, url, this.requestData, this.exceptionMsg);
    }

    return String.format("\n【请求地址】：%s\n【请求数据】：%s\n【响应数据】：%s",
      this.url, this.requestData, this.responseData);
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getRequestData() {
    return requestData;
  }

  public void setRequestData(String requestData) {
    this.requestData = requestData;
  }

  public String getResponseData() {
    return responseData;
  }

  public void setResponseData(String responseData) {
    this.responseData = responseData;
  }

  public String getExceptionMsg() {
    return exceptionMsg;
  }

  public void setExceptionMsg(String exceptionMsg) {
    this.exceptionMsg = exceptionMsg;
  }
}
