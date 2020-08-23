package com.hpl.ashe.intercepter;

import com.hpl.ashe.utils.ContainerInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title: AsheIntercepter</p>
 *
 * @author hupenglong
 * @date 2020-08-23 17:48
 */
@Component
@Slf4j
public class AsheIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        //HTTP请求生成全局UUID
        ContainerInstance.setUniqueId();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("afterCompletion");
        ContainerInstance.remove();
    }
}
