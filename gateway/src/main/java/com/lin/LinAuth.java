package com.lin;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.nacos.common.utils.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LinAuth implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        HttpHeaders headers = request.getHeaders();
        String authorization = headers.getFirst("Authorization");

        try {
            StpUtil.checkLogin();
            return chain.filter(exchange);
        } catch (NotLoginException e) {
            ServerHttpResponse response = exchange.getResponse();

            response.setStatusCode(HttpStatus.UNAUTHORIZED);

            return response.setComplete();
        }


    }
}
