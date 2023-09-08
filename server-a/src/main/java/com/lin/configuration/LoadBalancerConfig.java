package com.lin.configuration;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.loadbalancer.NacosLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

public class LoadBalancerConfig {
    /**
     * 配置nacos负载均衡
     * @param environment environment
     * @param loadBalancerClientFactory loadBalancerClientFactory
     * @param nacosDiscoveryProperties nacosDiscoveryProperties
     * @return NacosLoadBalancer
     */
    @Bean
    public ReactorServiceInstanceLoadBalancer getNacosLoadBalancer(Environment environment,
                                                                   LoadBalancerClientFactory loadBalancerClientFactory,
                                                                   NacosDiscoveryProperties nacosDiscoveryProperties) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new NacosLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class),
                name,
                nacosDiscoveryProperties);
    }
}
