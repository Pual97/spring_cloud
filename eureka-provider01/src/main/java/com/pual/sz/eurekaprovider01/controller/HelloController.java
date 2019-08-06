package com.pual.sz.eurekaprovider01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年08月06日 15:00:00
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello1";
    }

}
