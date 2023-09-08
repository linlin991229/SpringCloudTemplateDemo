package com.lin.configuration;

import com.lin.feign.LinClient;
import com.lin.feign.impl.LinClientFallback;
import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class FeignConfiguration {
//    @Bean
//    public LinClient LinClientFallback(){
//        return new LinClientFallback();
//    }

    @Bean
    public Logger.Level feignLogLevel(){
       return Logger.Level.FULL;
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

}
