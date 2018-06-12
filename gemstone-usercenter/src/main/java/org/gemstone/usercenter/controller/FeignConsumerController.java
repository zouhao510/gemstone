package org.gemstone.usercenter.controller;

import org.gemstone.usercenter.rpc.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignConsumerController {

    @Autowired
    private HelloService testService;// 注入feign声明的rpc服务接口

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsuemr() {
        return testService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsuemr2(@RequestParam String word) {
        return testService.hello2(word);
    }

}
