package com.wangsh.spirngcloudforalibaba.feign;

import com.wangsh.spirngcloudforalibaba.feign.fallback.StockFeignServiceFullBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过使用openfeign来调用远程服务.
 * fallback: 对sentinel的整合，代表可以集中管理每一个接口降级方法
 */
@FeignClient(value = "stock-service-sentinel", path = "stock",fallback = StockFeignServiceFullBack.class)
public interface StockFeignService {

    @RequestMapping("/reduct")
    String reduct();
}
