package com.wangsh.spirngcloudforalibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 使用seata进行分布式事务管理
 *
 * @author wangshenghui
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.wangsh.spirngcloudforalibaba.dao")
@EnableFeignClients
public class OrderSeataApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderSeataApplication.class, args);
    }
}
