package com.wangsh.spirngcloudforalibaba.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.wangsh.spirngcloudforalibaba.entity.Order;
import com.wangsh.spirngcloudforalibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangshenghui
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        //使用nacos的服务名称来调用远程服务
        String forObject = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
        System.out.println(forObject);
        return "下单成功" + forObject;
    }

//    @PathVariable("id") = selectOrder/{id}
//    @RequestParam  = /selectOrder?id=dsds
    @RequestMapping("selectOrder")
    public Order selectOrder(@RequestParam("id") Integer id) {
        return orderService.selectOrder(id);
    }

    /**
     * 与seata集成
     * @return
     */
    @RequestMapping("/insert")
    public Order insert() {
        return orderService.insertOrder(Order.builder().id(85).productId(100).totolAmount(100.00).status(0).build());
    }

    /**
     * 测试gateway的拦截器是否添加了指定的hearders头
     * @param hearder
     * @return
     */
    @RequestMapping("/testGatewayHeaders")
    public String testGatewayHeaders(@RequestHeader("wangsh") String hearder){
        return hearder;
    }
}
