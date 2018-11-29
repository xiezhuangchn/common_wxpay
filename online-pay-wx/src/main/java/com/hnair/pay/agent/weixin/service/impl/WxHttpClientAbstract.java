package com.hnair.pay.agent.weixin.service.impl;

import com.hnair.pay.agent.weixin.config.WxBaseConfig;
import com.hnair.pay.agent.weixin.exception.WxPayException;
import com.hnair.pay.agent.weixin.service.IWxHttpClient;
import jodd.util.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;

/**
 * <pre>
 * 微信支付请求实现类，apache httpclient实现.
 * </pre>
 *
 */
public class WxHttpClientAbstract implements IWxHttpClient {

  public final Logger log = LoggerFactory.getLogger(this.getClass());

  public WxBaseConfig wxBaseConfig;

  /**
   * 初始化sslContxt
   * @throws Exception
   */
  WxHttpClientAbstract(WxBaseConfig wxBaseConfig) throws Exception{
      this.wxBaseConfig = wxBaseConfig;
      this.initSSLContext();
  }

  /**
   * http请求连接超时时间.
   */
  private static final int httpConnectionTimeout = 5000;

  /**
   * http请求数据读取等待时间.
   */
  private static final int httpTimeout = 10000;

  @Override
  public byte[] postForBytes(String url, String requestStr, boolean useKey) throws WxPayException {
    try {
      HttpClientBuilder httpClientBuilder = createHttpClientBuilder(useKey);
      HttpPost httpPost = this.createHttpPost(url, requestStr);
      try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
          final byte[] bytes = EntityUtils.toByteArray(response.getEntity());
          final String responseData = Base64.encodeToString(bytes);
          this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据(Base64编码后)】：{}", url, requestStr, responseData);
          return bytes;
        }
      } finally {
        httpPost.releaseConnection();
      }
    } catch (Exception e) {
      this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
//      wxApiData.set(new WxPayApiData(url, requestStr, null, e.getMessage()));
      throw new WxPayException(e.getMessage(), e);
    }
  }

  @Override
  public String post(String url, String requestStr, boolean useKey) throws WxPayException {
    try {
      HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder(useKey);
      HttpPost httpPost = this.createHttpPost(url, requestStr);
      try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
          String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
          this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);
          return responseString;
        }
      } finally {
        httpPost.releaseConnection();
      }
    } catch (Exception e) {
      log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
      throw new WxPayException(e.getMessage(), e);
    }
  }

  private StringEntity createEntry(String requestStr) {
    try {
      return new StringEntity(new String(requestStr.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
    } catch (UnsupportedEncodingException e) {
      //cannot happen
      this.log.error(e.getMessage(),e);
      return null;
    }
  }

  private HttpClientBuilder createHttpClientBuilder(boolean useKey) throws WxPayException {
    HttpClientBuilder httpClientBuilder = HttpClients.custom();
    if (useKey) {
      this.initSSLContext(httpClientBuilder);
    }

    if (StringUtils.isNotBlank(wxBaseConfig.getHttpProxyHost())
      && wxBaseConfig.getHttpProxyPort() > 0) {
      // 使用代理服务器 需要用户认证的代理服务器
      CredentialsProvider provider = new BasicCredentialsProvider();
      provider.setCredentials(
        new AuthScope(wxBaseConfig.getHttpProxyHost(), wxBaseConfig.getHttpProxyPort()),
        new UsernamePasswordCredentials(wxBaseConfig.getHttpProxyUsername(), wxBaseConfig.getHttpProxyPassword()));
      httpClientBuilder.setDefaultCredentialsProvider(provider);
    }
    return httpClientBuilder;
  }

  private HttpPost createHttpPost(String url, String requestStr) {
    HttpPost httpPost = new HttpPost(url);
    httpPost.setEntity(this.createEntry(requestStr));
    httpPost.setConfig(RequestConfig.custom()
      .setConnectionRequestTimeout(this.httpConnectionTimeout)
      .setConnectTimeout(this.httpConnectionTimeout)
      .setSocketTimeout(this.httpTimeout)
      .build());
    return httpPost;
  }

  private void initSSLContext(HttpClientBuilder httpClientBuilder) throws WxPayException {
    SSLContext sslContext = wxBaseConfig.getSslContext();
    SSLConnectionSocketFactory connectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
      new String[]{"TLSv1"}, null, new DefaultHostnameVerifier());
    httpClientBuilder.setSSLSocketFactory(connectionSocketFactory);
  }

  /**
   * 初始化ssl.
   */
  public void initSSLContext() throws WxPayException {
    if (StringUtils.isBlank(wxBaseConfig.getMchId())) {
      throw new WxPayException("请确保商户号mchId已设置");
    }

    InputStream inputStream;
    if (StringUtils.isBlank(wxBaseConfig.getKeyPath())) {
      throw new WxPayException("请确保证书文件地址keyPath已配置");
    }

    String prefix = "classpath:";
    String fileHasProblemMsg = "证书文件【" + wxBaseConfig.getKeyPath() + "】有问题，请核实！";
    String fileNotFoundMsg = "证书文件【" + wxBaseConfig.getKeyPath() + "】不存在，请核实！";
    if (wxBaseConfig.getKeyPath().startsWith(prefix)) {
      String path = StringUtils.removePattern(wxBaseConfig.getKeyPath(), prefix);
      if (!path.startsWith("/")) {
        path = "/" + path;
      }
      inputStream = WxBaseConfig.class.getResourceAsStream(path);
      if (inputStream == null) {
        throw new WxPayException(fileNotFoundMsg);
      }
    } else {
      try {
        File file = new File(wxBaseConfig.getKeyPath());
        if (!file.exists()) {
          throw new WxPayException(fileNotFoundMsg);
        }
        inputStream = new FileInputStream(file);
      } catch (IOException e) {
        throw new WxPayException(fileHasProblemMsg, e);
      }
    }

    try {
      KeyStore keystore = KeyStore.getInstance("PKCS12");
      char[] partnerId2charArray = wxBaseConfig.getMchId().toCharArray();
      keystore.load(inputStream, partnerId2charArray);
      wxBaseConfig.setSslContext(SSLContexts.custom().loadKeyMaterial(keystore, partnerId2charArray).build());
    } catch (Exception e) {
      throw new WxPayException("证书文件有问题，请核实！", e);
    } finally {
      IOUtils.closeQuietly(inputStream);
    }
  }

}
