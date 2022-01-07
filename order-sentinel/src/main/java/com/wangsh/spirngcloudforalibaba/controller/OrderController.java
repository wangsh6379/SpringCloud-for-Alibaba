package com.wangsh.spirngcloudforalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wangsh.spirngcloudforalibaba.blockHandler.OrderBlockHandlers;
import com.wangsh.spirngcloudforalibaba.blockHandler.OrderFallBacks;
import com.wangsh.spirngcloudforalibaba.feign.StockFeignService;
import com.wangsh.spirngcloudforalibaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangshenghui
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    private int port;

    @Autowired
    private UserService userService;

    @Autowired
    private StockFeignService stockFeignService;

    /**
     * 注解：SentinelResource
     * value:资源名；
     * blockHandler：流控后需要进行服务限流处理的方法。
     * blockHandlerClass：如果限流方法不再本类中，需要指定方法所在类的class，切方法必须是static类型
     * fallback：降级后需要处理的方法
     * fallbackClass:如果降级方法不再本类中，需要指定方法所在类的class，切方法必须是static类型
     *
     * @return
     */
//    @SentinelResource(value = "add"
//            ,blockHandler = "addBlockHandler"
//            ,blockHandlerClass = OrderBlockHandlers.class
//            ,fallback = "addFallBack",fallbackClass = OrderFallBacks.class)
    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        String forObject = restTemplate.getForObject("http://localhost:8070/order/get", String.class);
        System.out.println(forObject);
        return "下单成功" + forObject;
    }

    @RequestMapping("/get")
    public String get() {
        System.out.println("获取端口方法");
        return userService.getUser();
    }

    /**
     * 整合openfeign
     *
     * @return
     */
    @RequestMapping("/stock")
    public String stock() {
        System.out.println("第二个调用获取端口方法");
        return stockFeignService.reduct();
    }

    /**
     * 针对热点数据流控，当热点数据大于设定的阈值，则被流控。
     * 当接口的QPS大于设定的阈值也会被流控
     *
     * @param id
     * @return
     */
    @SentinelResource(value = "hotData", blockHandler = "hotDateBlockHandler", blockHandlerClass = OrderBlockHandlers.class)
    @RequestMapping("/hotData/{id}")
    public String hotData(@PathVariable("id") String id) {
        System.out.println("热点数据流控规则");
        return stockFeignService.reduct();
    }

    /**
     * 注意：nacos中的配置文件中resource值必须与controller + RequestMapping一致,如果不一致则无法映射
     * 通过nacos获取sentinel配置规则
     * @param id
     * @return
     */
    @RequestMapping("/hotDataCofnig/{id}")
    public String hotDataCofnig(@PathVariable("id") String id) {
        System.out.println("热点数据流控规则");
        return stockFeignService.reduct();
    }
}
