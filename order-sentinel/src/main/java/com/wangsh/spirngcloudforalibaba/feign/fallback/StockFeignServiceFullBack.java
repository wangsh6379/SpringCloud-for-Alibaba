package com.wangsh.spirngcloudforalibaba.feign.fallback;

import com.wangsh.spirngcloudforalibaba.feign.StockFeignService;
import org.springframework.stereotype.Component;

/**
 * 实现远程服务的接口，如果远程服务存在异常或报错，将直接1调用该降级方法
 */
@Component
public class StockFeignServiceFullBack implements StockFeignService{
    @Override
    public String reduct() {
        return "降级处理";
    }
}
