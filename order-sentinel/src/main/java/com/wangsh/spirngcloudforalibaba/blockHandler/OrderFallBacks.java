package com.wangsh.spirngcloudforalibaba.blockHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 订单接口：降级统一处理类
 */
public class OrderFallBacks {
    /**
     * order/add 的降级方法
     * @return
     */
    public static String addFallBack() {
        return "请求被拒绝，服务降级";
    }
}
