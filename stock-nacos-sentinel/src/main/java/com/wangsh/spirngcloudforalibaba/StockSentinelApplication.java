package com.wangsh.spirngcloudforalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangshenghui
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StockSentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockSentinelApplication.class, args);
    }
}
