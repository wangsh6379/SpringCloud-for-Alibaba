package com.wangsh.springcloudalibaba.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义配置断言规则
 */
@Component
public class CheckAuthRoutePredicateFactory
        extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {

    /**
     * 配置文件 key.
     */
    public static final String PARAM_KEY = "param";

    /**
     * 配置文件 value.
     */
    public static final String REGEXP_KEY = "regexp";

    /**
     * 继承抽象方法，必须要进行实例化对象，因为abstract类无法实例化对象
     */
    public CheckAuthRoutePredicateFactory() {
        super(Config.class);
    }

    /**
     * 进行断言匹配规则
     *
     * @param config
     * @return
     */
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        boolean hasRegexp = !StringUtils.isEmpty(config.regexp);
        return (serverWebExchange)->{
            List<String> values = serverWebExchange.getRequest().getQueryParams().getOrDefault(config.param, Collections.emptyList());
            //如果在请求上没有存在配置的参数，则直接拒绝请求
            if (values.isEmpty()) {
                return false;
            }
            //如果配置了必须以value值，则查看参数是否符合配置参数
            if (hasRegexp) {
                for (String value : values) {
                    if (value.matches(config.regexp)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        };
//        return new GatewayPredicate() {
//            @Override
//            public boolean test(ServerWebExchange serverWebExchange) {
//                List<String> values = serverWebExchange.getRequest().getQueryParams().getOrDefault(config.param, Collections.emptyList());
//
//                //如果在请求上没有存在配置的参数，则直接拒绝请求
//                if (values.isEmpty()) {
//                    return false;
//                }
//                //如果配置了必须以value值，则查看参数是否符合配置参数
//                if (hasRegexp) {
//                    for (String value : values) {
//                        if (value.matches(config.regexp)) {
//                            return true;
//                        }
//                    }
//                    return false;
//                }
//                return true;
//            }
//
//            @Override
//            public String toString() {
//                return String.format("Header: %s regexp=%s", config.param,
//                        config.regexp);
//            }
//        };
    }

    /**
     * 进行配置文件与参数绑定
     *
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAM_KEY, REGEXP_KEY);
    }

    /**
     * 定义内部类，进行与配置文件的参数绑定
     */
    @Validated
    public static class Config {

        @NotEmpty
        private String param;

        private String regexp;

        public String getParam() {
            return param;
        }

        public CheckAuthRoutePredicateFactory.Config setParam(String param) {
            this.param = param;
            return this;
        }

        public String getRegexp() {
            return regexp;
        }

        public CheckAuthRoutePredicateFactory.Config setRegexp(String regexp) {
            this.regexp = regexp;
            return this;
        }
    }
}
