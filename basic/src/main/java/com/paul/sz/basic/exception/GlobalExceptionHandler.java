package com.paul.sz.basic.exception;

import com.paul.sz.basic.util.I18nMessageUtil;
import com.pual.sz.Entity.ResultBean;
import com.pual.sz.exception.BasicException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年09月25日 11:05:00
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @Resource
    private I18nMessageUtil messageUtil;


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean<String> exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        log.info("Exception  " + ExceptionUtils.getStackTrace(exception));
        Throwable throwable = getBasicExceptionRecursive(exception);
        if (throwable != null) {
            BasicException be = (BasicException) throwable;
            return handleBusinessErrorInfo(request.getRequestURI(), be.getMsgKey(), be.getI18nMessage());
        }
        return handleErrorInfo(request, -1, "思想开小差了");
    }


    private Throwable getBasicExceptionRecursive(Throwable error) {
        while (error != null) {
            if (error instanceof BasicException) {
                break;
            }
            error = error.getCause();
        }
        return error;
    }

    private ResultBean<String> handleErrorInfo(int code, String msg) {
        return ResultBean.createByError(code, msg);
    }

    private ResultBean<String> handleBusinessErrorInfo(String url, String msgCode, String msgStr) {
        ResultBean<String> resultBean = new ResultBean<>();
        resultBean.setCode(412);
        resultBean.setMsgCode(msgCode);
        resultBean.setMsg(msgStr);
        resultBean.setUrl(url);
        return resultBean;
    }

    private ResultBean<String> handleErrorInfo(HttpServletRequest request, int code, String msgCode, Object... params) {
        ResultBean<String> resultBean = new ResultBean<>();
        resultBean.setCode(code);
        resultBean.setMsg(messageUtil.getMessage(request, msgCode, params));
        resultBean.setMsgCode(msgCode);
        resultBean.setUrl(request.getRequestURI());
        return resultBean;
    }
}
