package com.lin;

import com.lin.configuration.FeignConfiguration;
import com.lin.configuration.LoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients(defaultConfiguration = FeignConfiguration.class)
@EnableFeignClients
//@LoadBalancerClients({
//        @LoadBalancerClient(value = "server-b", configuration = LoadBalancerConfig.class)
//})
public class AServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AServerApplication.class, args);
    }
}
