package com.wangsh.spirngcloudforalibaba.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangshenghui
 */
@Configuration
public class RestTemplateConfig {
    /**
     * 因为调用nacos需要用到负载均衡器，才可以通过服务名调用该远程服务
     * 需要加注解：@LoadBalanced
     * @param builder
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate build = builder.build();
        return build;
    }
}
