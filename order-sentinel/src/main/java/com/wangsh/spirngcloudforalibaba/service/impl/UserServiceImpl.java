package com.wangsh.spirngcloudforalibaba.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.wangsh.spirngcloudforalibaba.blockHandler.OrderBlockHandlers;
import com.wangsh.spirngcloudforalibaba.feign.StockFeignService;
import com.wangsh.spirngcloudforalibaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通过调用本地的业务方法进行流控
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StockFeignService stockFeignService;

    @SentinelResource(value = "getUser", blockHandler = "addBlockHandler"
            , blockHandlerClass = OrderBlockHandlers.class)
    @Override
    public String getUser() {
        return "getUser===";
    }

    /**
     * 对远程服务进行流控。在Sentinel中可以对远程服务进行限流监控，但是会爆500的错误。只有对当前方法流控才可以进入到流控方法
     * @return
     */
//    @SentinelResource(value = "reduct", blockHandler = "addBlockHandler"
//            , blockHandlerClass = OrderBlockHandlers.class)
    @Override
    public String getReduct() {
        return "getReduct==="+stockFeignService.reduct();
    }
}
