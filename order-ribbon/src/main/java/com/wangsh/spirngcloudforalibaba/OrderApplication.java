package com.wangsh.spirngcloudforalibaba;

import com.wangsh.ribbon.RibbonConfigRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * ribbon 负载均衡器，提供负载机制比较完善
 * @author wangshenghui
 */
@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(basePackages =)
//@RibbonClients(value = {
//        @RibbonClient(name = "stock-service", configuration = RibbonConfigRule.class)
//})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
