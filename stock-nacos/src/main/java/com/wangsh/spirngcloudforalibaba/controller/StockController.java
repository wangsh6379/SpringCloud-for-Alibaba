package com.wangsh.spirngcloudforalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangshenghui
 */
@RefreshScope
@RestController
@RequestMapping("/stock")
public class StockController {
    @Value("${server.port}")
    String prot;

    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int age;


    @Value("${user.name2}")
    String userName2;

    @Value("${user.age2}")
    int age2;

    @RequestMapping("/reduct")
    public String reduct() {
        System.out.println("扣减库存成功");
        return "success,prot:" + prot + ",name:" + userName + ",age:" + age+ ",name2:" + userName2 + ",age2:" + age2;
    }
}
