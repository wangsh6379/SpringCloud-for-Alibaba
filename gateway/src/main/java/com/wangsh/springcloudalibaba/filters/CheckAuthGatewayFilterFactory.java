package com.wangsh.springcloudalibaba.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.AddRequestHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.cloud.gateway.support.GatewayToStringStyler.filterToStringCreator;


/**
 * gateway自定义拦截器
 * 增加请求头
 */
@Component
public class CheckAuthGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {
//        return (ServerWebExchange exchange,
//                GatewayFilterChain chain) -> {
//            String value = ServerWebExchangeUtils.expand(exchange, config.getValue());
//            return chain.filter(exchange.mutate().request(exchange.getRequest().mutate()
//                    .headers(httpHeaders -> httpHeaders.add(config.getName(), value))
//                    .build()).build());
//        };

        //            @Override
//            public String toString() {
//                return filterToStringCreator(CheckAuthGatewayFilterFactory.this)
//                        .append(config.getName(), config.getValue()).toString();
//            }
        return (exchange, chain) -> {
            String value = ServerWebExchangeUtils.expand(exchange, config.getValue());
            ServerHttpRequest request = exchange.getRequest().mutate()
                    .headers(httpHeaders -> httpHeaders.add(config.getName(), value))
                    .build();

            return chain.filter(exchange.mutate().request(request).build());
        };
    }

}
