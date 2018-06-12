package org.gemstone.usercenter.rpc;

import org.gemstone.usercenter.hystrix.HelloServiceFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign 声明式服务接口
 * 
 * @author: zouhao 2017年8月13日 下午9:27:35
 */
// 指定服务名（不区分大小写）绑定服务,并提供服务降级回调实现
@FeignClient(name = "SCLOUD-SERVICE-PROVIDER", fallback = HelloServiceFallBack.class)
// @FeignClient(name = "SCLOUD-SERVICE-PROVIDER", value = DisableHystrixConfiguration.class) //针对该服务名关闭Hystrix服务保护和熔断功能

public interface HelloService {

    @RequestMapping("/test/hello") // 绑定具体服务提供的rest接口
    String hello();

    @RequestMapping("test/hello2")
    String hello2(@RequestParam("word") String word);// Feign中绑定参数必须通过value指明具体的参数名
}
