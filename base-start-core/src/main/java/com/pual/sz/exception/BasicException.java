package com.pual.sz.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年09月24日 15:54:00
 */
@Data
@Slf4j
public abstract class BasicException extends RuntimeException {
    protected String msgKey;
    protected String i18nMessage;
    protected String[] args;


    protected BasicException(String message, String msgKey, String i18nMessage) {
        super(message);
        this.msgKey = msgKey;
        this.i18nMessage = i18nMessage;
    }

    protected BasicException(String message, String msgKey, String i18nMessage, Throwable cause) {
        super(message, cause);
        this.msgKey = msgKey;
        this.i18nMessage = i18nMessage;
    }

    public BasicException(String msgKey) {
        super(msgKey);
        this.msgKey = msgKey;
    }

}
