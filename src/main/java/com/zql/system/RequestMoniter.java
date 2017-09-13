package com.zql.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/9/11.
 */
public class RequestMoniter extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger("com.zql");


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("uri:{}",request.getServletPath());
        logger.info("params:{}", request.getParameterMap());
        return true;
    }
}
