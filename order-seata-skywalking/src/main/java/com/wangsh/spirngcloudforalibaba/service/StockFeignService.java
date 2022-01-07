package com.wangsh.spirngcloudforalibaba.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stock-seata-service", path = "stock")
public interface StockFeignService {

    @RequestMapping("/reductStock")
    String reductStock(@RequestParam("productId") Integer productId);
}
