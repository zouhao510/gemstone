package org.gemstone.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Logger;

/**
 * 使用spring cloud feign实现声明式服务调用 1.定义接口绑定服务名。 2.接口中定义方法绑定服务名下具体的rest接口
 * 
 * @author: zouhao 2017年7月25日 下午11:14:58
 */
@EnableFeignClients // 开启spring cloud feign声明式服务支持
@EnableDiscoveryClient // 让应用注册为客户端应用，以获得服务发现的能力
@SpringBootApplication
public class UserCenterStarter {

    /**
     * 定义Feign logger level
     * 
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        // NONE/BASIC/HEADERS/FULL
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {

        SpringApplication.run(UserCenterStarter.class, args);
    }
}
