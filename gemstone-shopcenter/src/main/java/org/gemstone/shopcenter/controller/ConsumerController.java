package org.gemstone.shopcenter.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consume")
public class ConsumerController {

    private final Logger log = Logger.getLogger(ConsumerController.class);

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloConsumer() {

        // 通过服务名组成的url从服务注册中心获取服务
        ResponseEntity<String> response = restTemplate.getForEntity("http://SCLOUD-SERVICE-PROVIDER/test/hello",
                String.class);
        log.info("Get rpc request response : " + response.getBody());
        return response.getBody();
    }

}
