package com.wangsh.spirngcloudforalibaba.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * 针对日志配置，处理使用Feign调用远程服务没有日志显示的问题
 * @Configuration：全局配置，如果不需要全局配置就不要加此注解
 * 局部配置：指定类的头上加上属性，configuration = FeignConfig.class，进行局部配置
 */
//@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
