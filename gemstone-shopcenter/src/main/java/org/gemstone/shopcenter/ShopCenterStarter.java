package org.gemstone.shopcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * rpc服务消费
 * 
 * @author: zouhao 2017年7月25日 下午11:14:58
 */
@EnableDiscoveryClient // 让应用注册为客户端应用，以获得服务发现的能力
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ShopCenterStarter {

    @Bean
    @LoadBalanced // 使用spring cloud ribbon开启客户端负载均衡
    RestTemplate restTempalte() {
        return new RestTemplate();
    }

    public static void main(String[] args) {

        SpringApplication.run(ShopCenterStarter.class, args);
    }
}
