package com.wangsh.spirngcloudforalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangshenghui
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    String prot;

    @RequestMapping("/reduct")
    public String reduct() {
        System.out.println("扣减库存成功");
        return "success,prot:" + prot;
    }
}
