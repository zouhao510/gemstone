package org.gemstone.registercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka 服务器应用
 * 
 * @author: zouhao 2017年7月25日 下午10:06:01
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterCenterStarter {

    public static void main(String[] args) {
        SpringApplication.run(RegisterCenterStarter.class, args);
    }
}
