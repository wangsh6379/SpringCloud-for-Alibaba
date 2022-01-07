package com.wangsh.spirngcloudforalibaba.controller;

import com.wangsh.spirngcloudforalibaba.feign.ProductFeignServcice;
import com.wangsh.spirngcloudforalibaba.feign.StockFeignService;
import com.wangsh.spirngcloudforalibaba.intercepter.CustomFeignIntercepter;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.Configuration;

/**
 * @author wangshenghui
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private StockFeignService stockFeignService;
    @Autowired
    private ProductFeignServcice productFeignServcice;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        //使用nacos的服务名称来调用远程服务
        String s = stockFeignService.reduct();
        System.out.println(s);

        String p = productFeignServcice.get(1);
        return "通过Feign调用微服务" + s + "，查询商品：" + p;
    }

}
