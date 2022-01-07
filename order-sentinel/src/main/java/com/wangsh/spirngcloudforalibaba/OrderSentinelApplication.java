package com.wangsh.spirngcloudforalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 集成Sentinel进行服务降级、熔断、流控
 *
 *
 * @author wangshenghui
 */
@SpringBootApplication
@EnableFeignClients
public class OrderSentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderSentinelApplication.class, args);
    }
}
