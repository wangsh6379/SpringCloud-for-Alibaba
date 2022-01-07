package com.wangsh.spirngcloudforalibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * 使用seata进行分布式事务管理
 * @author wangshenghui
 */
@SpringBootApplication
@MapperScan("com.wangsh.spirngcloudforalibaba.dao")
public class StockSeataApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockSeataApplication.class, args);
    }
}
