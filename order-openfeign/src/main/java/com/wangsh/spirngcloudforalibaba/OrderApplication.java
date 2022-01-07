package com.wangsh.spirngcloudforalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * openFeign 集成了Ribbon与Nacos，可以使用Spring MVC的注解，具有负载均衡
 * @author wangshenghui
 */
@SpringBootApplication
//服务注册与发现
//@EnableDiscoveryClient
//Feign的使用
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
