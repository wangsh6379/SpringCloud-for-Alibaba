package com.wangsh.spirngcloudforalibaba.intercepter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * Feign拦截器
 * 通过bean注入进行生效
 */
@Configuration
public class CustomFeignIntercepter implements RequestInterceptor{

    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("====================");
        requestTemplate.header("test","123456");
    }

    /**
     * 通过bean注入将拦截器进行生效
     * @return
     */
//    @Bean
//    public CustomFeignIntercepter feignIntercepter(){
//        return new CustomFeignIntercepter();
//    }
}
