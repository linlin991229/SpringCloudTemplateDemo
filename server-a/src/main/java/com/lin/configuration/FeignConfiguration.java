package com.lin.configuration;

import com.lin.feign.LinClient;
import com.lin.feign.impl.LinClientFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    @Bean
    public LinClient LinClientFallback(){
        return new LinClientFallback();
    }
}
