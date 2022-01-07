package com.wangsh.spirngcloudforalibaba.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * name 指定调用的服务
 * path 指定调用的服务对应的Controller  =  @RequestMapping("/stock")
 */
@FeignClient(name = "stock-service",path = "stock")
public interface StockFeignService {

    /**
     * 与Spring MVC编码一致，对应stockController中的reduct方法
     * @return
     */
    @RequestMapping("/reduct")
    String reduct();
}
