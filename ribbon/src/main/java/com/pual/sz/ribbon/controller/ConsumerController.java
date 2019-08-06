package com.pual.sz.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年08月06日 14:05:00
 */
@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/consumer")
    public String helloConsumer() throws Exception{
//        ServiceInstance providers = loadBalancerClient.choose("providers");
//        URI uri = URI.create(String.format("http://%s:%s", providers.getHost(), providers.getPort()));
//        return uri.toString();
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }

}
