package com.pual.sz.wx.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年11月07日 16:40:00
 */
@Data
@ConfigurationProperties(prefix = "wx")
public class WxMpProperties {
    /**
     * 设置微信公众号的appid.
     */
    private String appId;

    /**
     * 设置微信公众号的app secret.
     */
    private String secret;

    /**
     * 设置微信公众号的token.
     */
    private String token;

    /**
     * 设置微信公众号的EncodingAESKey.
     */
    private String aesKey;
}
