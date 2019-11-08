package com.pual.sz.wx.controller;

import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年11月07日 17:39:00
 */
@Controller
@RequestMapping("/wx/template")
public class TemplateController {

    @Value("${wx.templateId}")
    String templateId;

    @Autowired
    WxMpService wxMpService;

    @RequestMapping("/push")
    public void pushTemplate(){

    }
}
