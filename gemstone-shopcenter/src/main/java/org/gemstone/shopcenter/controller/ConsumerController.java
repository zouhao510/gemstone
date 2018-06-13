package org.gemstone.shopcenter.controller;

import com.netflix.hystrix.Hystrix;
import org.gemstone.shopcenter.service.HystrixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consume")
public class ConsumerController {

    private final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HystrixService hystrixService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloConsumer() {

        String result =  hystrixService.orderSayHello();

        LOGGER.info("execute rpc invoke orderSayHello get result :{}",result);

        return result;
    }

}
