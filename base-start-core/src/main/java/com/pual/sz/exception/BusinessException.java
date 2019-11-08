package com.pual.sz.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.StringUtils;

import java.util.Locale;
import java.util.Objects;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年09月24日 20:09:00
 */
@Data
@Slf4j
public class BusinessException extends BasicException {


    public static MessageSource messageSource;

    static {
        ReloadableResourceBundleMessageSource rrbMessageSource = new ReloadableResourceBundleMessageSource();
        rrbMessageSource.setBasename("messages");
        rrbMessageSource.setDefaultEncoding("UTF-8");
        messageSource = rrbMessageSource;
    }
    /**
     * 替换消息例如: msgKey=xxxx
     *
     * @param msgKey 对应messages.properties的KEY
     */
    public BusinessException(String msgKey) {
        super(msgKey);
        this.i18nMessage = getI18nMessage(msgKey, null);
    }

    public static String getI18nMessage(String msgKey, Object[] args) {
        if (StringUtils.isEmpty(msgKey)) {
            return msgKey;
        }

        if (Objects.nonNull(messageSource)) {
            return messageSource.getMessage(msgKey, args, Locale.getDefault());
        } else {
            log.error("load messageSource error:{}", messageSource);
            throw new IllegalArgumentException("load messageSource error");
        }
    }

}
