package org.gemstone.ordercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 标注为服务消费客户端，从注册中心获取服务
 * 
 * @author: zouhao 2017年7月25日 下午10:22:04
 */
@EnableEurekaClient
@SpringBootApplication
public class OrderCenterStarter {

    public static void main(String[] args) {

        SpringApplication.run(OrderCenterStarter.class, args);
    }

}
