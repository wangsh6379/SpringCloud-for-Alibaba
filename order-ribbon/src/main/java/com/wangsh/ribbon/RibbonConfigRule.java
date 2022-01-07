package com.wangsh.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class RibbonConfigRule {

    /**
     * 方法名一定要是iRule
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
