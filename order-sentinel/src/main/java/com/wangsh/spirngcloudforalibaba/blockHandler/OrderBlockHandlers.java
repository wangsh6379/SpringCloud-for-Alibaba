package com.wangsh.spirngcloudforalibaba.blockHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 流控统一处理类
 */
public class OrderBlockHandlers {
    /**
     * order/add 的流控方法
     *
     * @param blockException
     * @return
     */
    public static String addBlockHandler(BlockException blockException) {
        return "请求被拒绝，流控";
    }

    /**aa
     * 针对热点数据流控，当热点数据大于设定的阈值，则进入该方法。
     * 当接口的QPS大于设定的阈值也会进入该方法
     *
     * @param blockException
     * @return
     */
    public static String hotDateBlockHandler(@PathVariable("id") String id, BlockException blockException) {
        return "热点数据流控" + id;
    }
}
