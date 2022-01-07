package com.wangsh.spirngcloudforalibaba.feign;

import com.wangsh.spirngcloudforalibaba.config.FeignConfig;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * configuration：指定类加载到该类中，进行局部配置feign的日志级别
 */
@FeignClient(name = "product-nacos-service", path = "product",configuration = FeignConfig.class)
public interface ProductFeignServcice {

    /**
     * 在feign中@PathVariable需要指定参数，如果不指定会找不到参数，报错
     * Caused by: java.lang.IllegalStateException: PathVariable annotation was empty on param 0.
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    String get(@PathVariable("id") Integer id);
}
