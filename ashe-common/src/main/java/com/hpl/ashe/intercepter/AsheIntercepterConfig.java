package com.hpl.ashe.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * <p>Title: AsheIntercepterConfig</p>
 *
 * @author hupenglong
 * @date 2020-08-23 17:45
 */
@Component
public class AsheIntercepterConfig implements WebMvcConfigurer {
    @Autowired
    AsheIntercepter asheIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(asheIntercepter).addPathPatterns("/**").excludePathPatterns("/common/*");
    }
}
