package com.okgo.jwt.config;

import com.okgo.jwt.intercepter.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Shawn
 * @date 2020/7/5 2:46
 * @title 配置类将作为一个SpringBean添加到IOC容器内
 *
 *  WebMvcConfigurer接口是Spring内部的一种配置方式，采用JavaBean的形式来代替传统的xml配置文件来实现基本的配置需要。
 *
 *  InterceptorConfig内的addInterceptor需要一个实现HandlerInterceptor接口的拦截器实例，addPathPatterns方法用于设置拦截器的过滤路径规则:
 *      在addInterceptors方法中，我们将实现了HandlerInterceptor接口的拦截器实例authenticationInterceptor，
 *      添加至InterceptorRegistration中，并设置过滤路径。
 *      现在，我们所有请求都要经过authenticationInterceptor的拦截,拦截器authenticationInterceptor通过preHandle方法的业务过滤，
 *      判断是否有@TokenRequired 来决定是否需要登录。
 *
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 将我们上步定义的实现了HandlerInterceptor接口的拦截器实例authenticationInterceptor添加InterceptorRegistration中，并设置过滤规则，所有请求都要经过authenticationInterceptor拦截。
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/user/hello");
    }
}
