package com.paul.sz.basic.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年09月25日 11:57:00
 */
@Component
public class I18nMessageUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(I18nMessageUtil.class);

    private static MessageSource messageSource;

    /**
     * 初始化
     * @return
     */
    private MessageSource initMessageSource() {
        ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setCacheMillis(-1);
        return messageSource;
    }
    /**
     * 设置当前的返回信息
     * @param request
     * @param code
     * @return
     */
    public String getMessage(HttpServletRequest request, String code, Object... params){
        if(messageSource == null){
            messageSource = initMessageSource();
        }
        String lauage = request.getHeader("Accept-Language");
        //zh-CN,zh;q=0.9
        //默认没有就是请求地区的语言
        Locale locale = null;
        if(lauage == null){
            locale=request.getLocale();
        }
        else if(lauage.contains("en-US")){
            locale = Locale.US;
        }
        else if(lauage.contains("zh-CN")){
            locale = Locale.CHINA;
        }
        //其余的不正确的默认就是本地的语言
        else{
            locale = request.getLocale();
        }
        String result = null;
        try {
            result = messageSource.getMessage(code, null, locale);
        } catch (NoSuchMessageException e) {
            LOGGER.error("Cannot find the error message of internationalization, return the original error message.");
        }
        if(result == null){
            return code;
        }
        if (params != null && params.length > 0) {
            result = MessageFormat.format(result, params);
        }
        return result;
    }
}
