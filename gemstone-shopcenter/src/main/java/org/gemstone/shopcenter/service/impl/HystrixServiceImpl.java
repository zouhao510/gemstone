package org.gemstone.shopcenter.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.gemstone.shopcenter.service.HystrixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixServiceImpl implements HystrixService {

    private static final Logger LOGGER  = LoggerFactory.getLogger(HystrixServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(commandKey = "orderSayHello",fallbackMethod = "fallbackOrderSayHello")
    @Override
    public String orderSayHello() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://GEMSTONE-ORDERCENTER/test/hello",
                String.class);
        LOGGER.info("Get rpc [http://GEMSTONE-ORDERCENTER/test/hello] request response : " + response.getBody());
        return response.getBody();
    }

    private String fallbackOrderSayHello(){
        return "fallback error";
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackOrderSayHelloWithWord")
    public String orderSayHelloWithWord(String word) {
        ResponseEntity<String> response = restTemplate.getForEntity("http://GEMSTONE-ORDERCENTER/test/hello2?word={1}",
                String.class,word);
        LOGGER.info("Get rpc [http://GEMSTONE-ORDERCENTER/test/hello2] request response : " + response.getBody());
        return response.getBody();
    }

    private String fallbackOrderSayHelloWithWord(String word){
        return "fallback:"+word;
    }
}
