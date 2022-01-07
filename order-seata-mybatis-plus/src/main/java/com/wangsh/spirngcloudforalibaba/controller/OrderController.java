package com.wangsh.spirngcloudforalibaba.controller;

import com.wangsh.spirngcloudforalibaba.model.Order;
import com.wangsh.spirngcloudforalibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private OrderService orderService;

    @RequestMapping("/insertOrder/{productId}/{totalAmount}")
    public Order insertOrder(@PathVariable("productId") Integer productId, @PathVariable("totalAmount") Double totalAmount) {
        return orderService.insertOrder(Order.builder().productId(productId).totolAmount(totalAmount).status(0).build());
    }

    @RequestMapping("selectOrder/{id}")
    public Order selectOrder(@PathVariable("id") Integer id) {
        return orderService.selectOrder(id);
    }

    /**
     * 与seata集成
     * @return
     */
    @RequestMapping("/insert")
    public Order insert() {
        return orderService.insertOrder(Order.builder().productId(100).totolAmount(200.00).status(0).build());
    }
}
