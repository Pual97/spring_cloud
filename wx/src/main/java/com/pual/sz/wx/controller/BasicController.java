package com.pual.sz.wx.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年11月07日 16:35:00
 */
@Slf4j
@RestController
public class BasicController {



    @Autowired
    private WxMpService wxService;

    @GetMapping(produces = "text/plain;charset=utf-8")
    public String validation(@RequestParam(name = "signature", required = false) String signature,
                             @RequestParam(name = "timestamp", required = false) String timestamp,
                             @RequestParam(name = "nonce", required = false) String nonce,
                             @RequestParam(name = "echostr", required = false) String echostr){
        log.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature,
                timestamp, nonce, echostr);
        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }

        if (wxService.checkSignature(timestamp, nonce, signature)) {
            return echostr;
        }

        return "非法请求";
    }

//    @PostMapping(produces = "application/xml; charset=UTF-8")
//    public String post(@PathVariable Integer agentId,
//                       @RequestBody String requestBody,
//                       @RequestParam("msg_signature") String signature,
//                       @RequestParam("timestamp") String timestamp,
//                       @RequestParam("nonce") String nonce) {
//        this.logger.info("\n接收微信请求：[signature=[{}], timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
//                signature, timestamp, nonce, requestBody);
//
//        final WxCpService wxCpService = WxCpConfiguration.getCpService(agentId);
//        WxCpXmlMessage inMessage = WxCpXmlMessage.fromEncryptedXml(requestBody, wxCpService.getWxCpConfigStorage(),
//                timestamp, nonce, signature);
//        this.logger.debug("\n消息解密后内容为：\n{} ", JsonUtils.toJson(inMessage));
//        WxCpXmlOutMessage outMessage = this.route(agentId, inMessage);
//        if (outMessage == null) {
//            return "";
//        }
//
//        String out = outMessage.toEncryptedXml(wxCpService.getWxCpConfigStorage());
//        this.logger.debug("\n组装回复信息：{}", out);
//        return out;
//    }
//
//    private WxCpXmlOutMessage route(Integer agentId, WxCpXmlMessage message) {
//        try {
//            return WxCpConfiguration.getRouters().get(agentId).route(message);
//        } catch (Exception e) {
//            this.logger.error(e.getMessage(), e);
//        }
//
//        return null;
//    }



}
