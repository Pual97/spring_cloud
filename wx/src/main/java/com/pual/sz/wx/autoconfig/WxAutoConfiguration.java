package com.pual.sz.wx.autoconfig;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年11月07日 16:39:00
 */
@AllArgsConstructor
@Configuration
@EnableConfigurationProperties(WxMpProperties.class)
public class WxAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public WxMpService wxMpService(WxMpProperties properties) {
        WxMpService wxMpService = new WxMpServiceImpl();
        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        config.setAppId(properties.getAppId());
        config.setSecret(properties.getSecret());
        config.setToken(properties.getToken());
        config.setAesKey(properties.getAesKey());
        wxMpService.setMultiConfigStorages(ImmutableMap.of(properties.getAppId(), config));
        return wxMpService;
    }
}
