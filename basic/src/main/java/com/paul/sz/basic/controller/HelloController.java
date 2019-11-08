package com.paul.sz.basic.controller;

import com.pual.sz.Entity.ResultBean;
import com.pual.sz.exception.BusinessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年09月24日 20:05:00
 */
@RestController
public class HelloController {


    @RequestMapping("/testException")
    public ResultBean testException(){
        if(1==1){
            throw new BusinessException("hello.test.exception");
        }
        return ResultBean.createBySuccess();
    }
}
