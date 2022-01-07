package com.wangsh.springcloudalibaba.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.wangsh.springcloudalibaba.domain.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import javax.annotation.PostConstruct;

/**
 * 自定义异常
 */
@Configuration
public class GatewayConfig {
    @PostConstruct
    public void init() {
        BlockRequestHandler blockRequestHandler = new BlockRequestHandler() {

            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable e) {
                //资源的详细信息
                System.out.println("=================" + e.getMessage());
                Result result = null;

                if (e instanceof FlowException) {
                    result = Result.error(100, "接口限流");
                } else if (e instanceof DegradeException) {
                    result = Result.error(101, "服务降级");
                } else if (e instanceof ParamFlowException) {
                    result = Result.error(102, "热点参数限流");
                } else if (e instanceof SystemBlockException) {
                    result = Result.error(103, "触发系统保护机制");
                } else if (e instanceof AuthorityException) {
                    result = Result.error(104, "授权规则不通过");
                }
                return ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(result));
            }
        };
        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
    }
}
