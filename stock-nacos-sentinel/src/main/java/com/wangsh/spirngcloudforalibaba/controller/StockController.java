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
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int a = 5/0;
        System.out.println("扣减库存成功");
        return "success,prot:" + prot;
    }
}
