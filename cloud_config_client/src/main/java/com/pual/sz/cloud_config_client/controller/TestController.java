package com.pual.sz.cloud_config_client.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年08月12日 15:10:00
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${age}")
    private Integer age;

    @RequestMapping("/test")
    public int test(){
        return this.age;
    }
}
