package com.wangsh.spirngcloudforalibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 使用seata进行分布式事务管理
 *
 * @author wangshenghui
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.wangsh.spirngcloudforalibaba.mapper")
@EnableTransactionManagement
public class OrderSeataMybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderSeataMybatisPlusApplication.class, args);
    }
}
