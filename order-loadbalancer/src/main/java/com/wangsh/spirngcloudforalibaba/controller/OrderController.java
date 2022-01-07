package com.wangsh.spirngcloudforalibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangshenghui
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        //使用nacos的服务名称来调用远程服务
        String forObject = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
        System.out.println(forObject);
        return "下单成功" + forObject;
    }
}
