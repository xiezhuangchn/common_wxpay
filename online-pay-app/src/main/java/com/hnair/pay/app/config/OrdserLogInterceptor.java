package com.hnair.pay.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 拦截请求统一打印日志
 */
public class OrdserLogInterceptor implements HandlerInterceptor {

    private final static String REQUEST_ID = "requestId";

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdserLogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        try {
            String uuid = UUID.randomUUID().toString();
            String requestId = String.valueOf(uuid);
            MDC.put("requestId",requestId);

            // 定时任务不需要打印此日志
            if(httpServletRequest.getRequestURI().startsWith("/task")){
                return true;
            }

            long startTime = System.currentTimeMillis();
            httpServletRequest.setAttribute("logStartTime", startTime);
            String remoteIp = httpServletRequest.getRemoteAddr();
            if(handler instanceof HandlerMethod) {
                LOGGER.info("request id:{}, method {}, startTime:{}, client ip:{}",
                         uuid,((HandlerMethod) handler).getMethod().getName(), startTime, remoteIp);
            } else {
                LOGGER.info("request id:{}, startTime:{}, client ip:{}",
                        uuid, startTime, remoteIp);
            }
        } catch (Exception e) {
            //nothing
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
        try {
            // 定时任务不需要打印此日志
            if(httpServletRequest.getRequestURI().startsWith("/task")){
                MDC.remove(REQUEST_ID);
                return;
            }

            String uuid = MDC.get(REQUEST_ID);
            long startTime = (Long)httpServletRequest.getAttribute("logStartTime");
            long endTime = System.currentTimeMillis();
            long executeTime = endTime - startTime;
            if(handler instanceof HandlerMethod) {
                LOGGER.info("requestId {}, method {}, startTime:{}, endTime:{}, executeTime {}",
                        uuid, ((HandlerMethod) handler).getMethod().getName(),startTime, endTime, executeTime);
            } else {
                LOGGER.info("requestId {}, startTime:{}, endTime:{}, executeTime {}",
                        uuid, startTime, endTime, executeTime);
            }

            MDC.remove(REQUEST_ID);
        } catch (Exception e) {
                //nothing
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
