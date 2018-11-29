package com.hnair.pay.rpc;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.http.converter.xml.XmlAwareFormHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bing.cheng RestTemplate业务封装 打日志用
 */
@Service
public class HttpRestService extends RestTemplate {

  private final static Logger logger = LoggerFactory.getLogger(HttpRestService.class);

  public HttpRestService() {
    super();
  }

  public HttpRestService(RestTemplate restTemplate) {
    this.setErrorHandler(restTemplate.getErrorHandler());
    this.setInterceptors(restTemplate.getInterceptors());
    this.setMessageConverters(restTemplate.getMessageConverters());
    this.setRequestFactory(restTemplate.getRequestFactory());
  }

  public HttpRestService(ClientHttpRequestFactory requestFactory) {
    super(requestFactory);
  }

  public HttpRestService(int connectTimeout, int readTimeout) {
    super();
    // 设置requestFactory
    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    requestFactory.setConnectTimeout(connectTimeout);
    requestFactory.setReadTimeout(readTimeout);
    this.setRequestFactory(requestFactory);

    // 设置messageConverters对象
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    messageConverters.add(new ByteArrayHttpMessageConverter());
    messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
    messageConverters.add(new ResourceHttpMessageConverter());
    messageConverters.add(new SourceHttpMessageConverter());
    messageConverters.add(new XmlAwareFormHttpMessageConverter());
    messageConverters.add(new Jaxb2RootElementHttpMessageConverter());
    messageConverters.add(new MappingJackson2HttpMessageConverter());

    this.setMessageConverters(messageConverters);
  }

  /**
   * http request form by post method.
   */
  public <T> ResponseEntity<T> httpPostForm(String url,
      MultiValueMap<Object, Object> requestMultiMap, Class<T> responseType)
      throws RestClientException {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(
        MediaType.valueOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8"));
    HttpEntity<MultiValueMap<Object, Object>> entity = new HttpEntity<MultiValueMap<Object, Object>>(
        requestMultiMap, headers);
    try {
      Long beginTime = System.currentTimeMillis();
      ResponseEntity<T> responseEntity = super.postForEntity(url, entity, responseType);
      elkHttpResponseEntity(url, responseEntity, beginTime);
      return responseEntity;
    } catch (RestClientException e) {
      String errInfo = String.format(
          "HttpRestService call for httpPostForm error, target Uri: {%s}, responseType:{%s}, Params:{%s}",
          url, responseType, requestMultiMap == null ? "null" : requestMultiMap.toString());
      logger.error(errInfo, e);
      throw new RestClientException(errInfo, e);
    }
  }

  /**
   * http request form by post method.
   *
   * @param entity Http请求entity
   */
  public <T> ResponseEntity<T> postForEntity(String url, HttpEntity entity, Class<T> responseType)
      throws RestClientException {
    try {
      Long beginTime = System.currentTimeMillis();
      ResponseEntity<T> responseEntity = super.postForEntity(url, entity, responseType);
      elkHttpResponseEntity(url, responseEntity, beginTime);
      return responseEntity;
    } catch (RestClientException e) {
      String errInfo = String.format(
          "HttpRestService call for httpPostForm error, target Uri: {%s}, responseType:{%s}, Params:{%s}",
          url, responseType,
          entity == null || entity.getBody() == null ? "null" : entity.getBody().toString());
      logger.error(errInfo, e);
      throw new RestClientException(errInfo, e);
    }
  }

  /**
   * http request for json by post mehtod.
   */
  public <T> ResponseEntity<T> httpPostJson(String url, String jsonRequestBody,
      Class<T> responseType) throws RestClientException {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"));
    HttpEntity<String> entity = new HttpEntity<>(jsonRequestBody, headers);
    try {
      Long beginTime = System.currentTimeMillis();
      ResponseEntity<T> responseEntity = this.postForEntity(url, entity, responseType);
      elkHttpResponseEntity(url, responseEntity, beginTime);
      return responseEntity;
    } catch (RestClientException e) {
      String errInfo = String.format(
          "HttpRestService call for httpPostJson error, target Uri: {%s}, responseType:{%s}, params:{%s}",
          url, responseType, jsonRequestBody);
      logger.error(errInfo, e);
      throw new RestClientException(errInfo, e);
    }
  }

  /**
   * http request form by post method.
   */
  public <T> ResponseEntity<T> httpGetEntity(String url, Map<String, Object> requestMap,
      Class<T> responseType) throws RestClientException {
    URI targetUri = buildUri(url, requestMap);
    try {
      Long beginTime = System.currentTimeMillis();
      ResponseEntity<T> entity = this.getForEntity(targetUri, responseType);
      elkHttpResponseEntity(url, entity, beginTime);
      return entity;
    } catch (RestClientException e) {
      String errInfo = String.format(
          "HttpRestService call for httpGetObject error, target Uri: {%s}, responseType:{%s}, params:{%s}",
          targetUri, responseType, requestMap);
      logger.error(errInfo, e);
      throw new RestClientException(errInfo, e);
    }
  }

  /**
   * http request by get method
   */
  public <T> T httpGetObject(String url, Map<String, Object> requestMap, Class<T> responseType)
      throws RestClientException {
    URI targetUri = buildUri(url, requestMap);
    try {
      Long beginTime = System.currentTimeMillis();
      T obj = this.getForObject(targetUri, responseType);
      return obj;
    } catch (RestClientException e) {
      String errInfo = String.format(
          "HttpRestService call for httpGetObject error, target Uri: {%s}, responseType:{%s}, params:{%s}",
          targetUri, responseType, requestMap);
      logger.error(errInfo, e);
      throw new RestClientException(errInfo, e);
    }
  }


  @Override
  public <T> T getForObject(String url, Class<T> responseType, Object... urlVariables)
      throws RestClientException {
    try {
      Long beginTime = System.currentTimeMillis();
      T obj = super.getForObject(url, responseType, urlVariables);
      return obj;
    } catch (RestClientException e) {
      String errInfo = String.format(
          "HttpRestService call for getForObject error, target Uri: {%s}, responseType:{%s}, params:{%s}",
          url, responseType, JSON.toJSONString(urlVariables));
      logger.error(errInfo, e);
      throw new RestClientException(errInfo, e);
    }
  }

  @Override
  public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> urlVariables)
      throws RestClientException {
    try {
      Long beginTime = System.currentTimeMillis();
      T obj = super.getForObject(url, responseType, urlVariables);
      return obj;
    } catch (RestClientException e) {
      String errInfo = String.format(
          "HttpRestService call for getForObject error, target Uri: {%s}, responseType:{%s}, params:{%s}",
          url, responseType, urlVariables);
      logger.error(errInfo, e);
      throw new RestClientException(errInfo, e);
    }
  }

  @Override
  public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType,
      Object... uriVariables) throws RestClientException {
    try {
      Long beginTime = System.currentTimeMillis();
      ResponseEntity<T> responseEntity = super
          .postForEntity(url, request, responseType, uriVariables);
      elkHttpResponseEntity(url, responseEntity, beginTime);
      return responseEntity;
    } catch (RestClientException e) {
      String errInfo = String.format(
          "HttpRestService call for postForEntity error, target Uri: {%s}, request:{%s}, responseType:{%s}, params:{%s}",
          url, JSON.toJSONString(request), responseType, JSON.toJSONString(uriVariables));
      logger.error(errInfo, e);
      throw new RestClientException(errInfo, e);
    }
  }

  /**
   * 将get请求的参数转变为url参数
   */
  private URI buildUri(String url, Map<String, Object> map) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

    if (map != null && !map.isEmpty()) {
      for (String key : map.keySet()) {
        builder.queryParam(key, map.get(key));
      }
    }

    return builder.build().encode().toUri();
  }

  /**
   * InputStream转换成Byte
   *
   * @return byte
   */
  private byte[] inputStreamToByte(InputStream in) {
    ByteArrayOutputStream out = null;
    try {
      int BUFFER_SIZE = 4096;
      out = new ByteArrayOutputStream();
      byte[] data = new byte[BUFFER_SIZE];
      int count = -1;
      while ((count = in.read(data, 0, BUFFER_SIZE)) != -1) {
        out.write(data, 0, count);
      }

      return out.toByteArray();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      try {
        in.close();
        out.close();
      } catch (IOException e) {
        logger.error("inputStreamToByte exception", e);
      }
    }
  }

  /**
   * 外部访问返回结果码监控
   */
  public static void elkHttpResponseEntity(String url, ResponseEntity entity, Long beginTime) {
    try {
      if (entity != null && entity.getStatusCode() != null) {
        //增加业务监控 HTTP访问
      } else {
        //增加业务监控 HTTP访问异常
      }
    } catch (Exception e) {
      logger.error("elk log error", e);
    }
  }
}
