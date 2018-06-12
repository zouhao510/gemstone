package org.gemstone.usercenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;

/**
 * 针对某个服务名的客户端关闭Hystrix功能,使用@FeignClient(name="HELLO-SERVICE",configuration=DisableHystrixConfiguration.class)
 * 
 * @author: zouhao 2017年8月13日 下午11:20:43
 */
@Configuration
public class DisableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

}
