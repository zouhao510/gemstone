package org.gemstone.usercenter.hystrix;

import org.gemstone.usercenter.rpc.HelloService;
import org.springframework.stereotype.Component;

/**
 * 服务降级实现类@FeignClient(fallback=HelloServiceFallBack.class)
 * 
 * @author: zouhao 2017年8月13日 下午11:32:49
 */
@Component
public class HelloServiceFallBack implements HelloService {

    @Override
    public String hello() {
        return "error hello";
    }

    @Override
    public String hello2(String word) {
        return "error hello2";
    }

}
