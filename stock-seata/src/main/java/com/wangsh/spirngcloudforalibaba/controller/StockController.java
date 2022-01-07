package com.wangsh.spirngcloudforalibaba.controller;

import com.wangsh.spirngcloudforalibaba.entity.Stock;
import com.wangsh.spirngcloudforalibaba.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

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


    @Autowired
    private StockService stockService;

    @RequestMapping("/selectStock/{id}")
    public Stock selectStock(@PathVariable("id") Integer id){
        Stock stock = stockService.selectStock(id);
        return stock;
    }

    @RequestMapping("/insertStock/{productId}/{count}")
    public Stock insertStock(@PathVariable("productId") Integer productId,@PathVariable("count") Integer count){
        return stockService.insetStock(Stock.builder().count(count).productId(productId).build());
    }

    @RequestMapping("/reductStock")
    public String reductStock(@RequestParam("productId")Integer productId){
        return stockService.reductStock(productId)+"";
    }
}
