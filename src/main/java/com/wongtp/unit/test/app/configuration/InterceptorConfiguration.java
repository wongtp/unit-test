/*
 * Copyleft
 */
package com.wongtp.unit.test.app.configuration;

import com.wongtp.unit.test.app.interceptor.WebInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author wontgtp
 * @date 2024-06-21
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Resource
    private WebInterceptor webInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webInterceptor).addPathPatterns("/**");
    }
}
