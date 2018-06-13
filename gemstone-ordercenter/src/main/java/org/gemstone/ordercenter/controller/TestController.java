package org.gemstone.ordercenter.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author: zouhao 2017年7月25日 下午10:23:51
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger log = Logger.getLogger(TestController.class);

    private static final Random random = new Random();

    @Autowired
    private DiscoveryClient client;

    // 将/test/hello作为rpc服务发布到注册中心
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        ServiceInstance instance = client.getLocalServiceInstance();
        log.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "hello world";
    }

    // 将/test/hello2作为rpc服务发布到注册中心
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2(@RequestParam String word) {
        return "RPC:say " + word + "IP:[localhost:8989]";
    }

}
