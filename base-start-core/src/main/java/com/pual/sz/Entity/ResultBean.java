package com.pual.sz.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回对象包装类(带泛型)
 */
@Data
@ApiModel(description = "返回值")
public class ResultBean<T> implements Serializable {

    private static final int SUCCESS_CODE = 0;

    private static final int UNKNOWN_EXCEPTION = -99;

    /**
     * 返回的信息(主要出错的时候使用)
     */
    @ApiModelProperty(value = "错误提示")
    private String msg;

    /**
     * 接口返回码
     */
    @ApiModelProperty(value = "0：成功")
    private int code;

    /**
     * 返回的数据
     */
    @ApiModelProperty(value = "返回的数据")
    private T data;

    /**
     * 返回的信息code(通过这个code从语言资源文件中查找错误提示信息)
     */
    @ApiModelProperty(value = "错误提示code")
    private String msgCode;

    /**
     * 请求访问路径
     */
    @ApiModelProperty(value = "请求访问路径")
    private String url;

    public ResultBean() {
    }

    private ResultBean(int code) {
        this.code = code;
    }

    private ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResultBean(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    private ResultBean(int code, T data) {
        this.code = code;
        this.data = data;
    }

    /**
     * 功能描述: 判断是否是成功的返回
     *
     * @return boolean
     */
//    @JsonIgnore
    public boolean isSuccess() {
        return this.code == SUCCESS_CODE;
    }

    public static <T> ResultBean<T> createBySuccess() {
        return new ResultBean<>(SUCCESS_CODE);
    }

    public static <T> ResultBean<T> createBySuccess(T data) {
        return new ResultBean<>(SUCCESS_CODE, data);
    }

    public static <T> ResultBean<T> createBySuccess(String msg, T data) {
        return new ResultBean<>(SUCCESS_CODE, msg, data);
    }

    public static <T> ResultBean<T> createByError() {
        return new ResultBean<>(UNKNOWN_EXCEPTION);
    }

    public static <T> ResultBean<T> createByError(String msg) {
        return new ResultBean<>(UNKNOWN_EXCEPTION, msg);
    }

    public static <T> ResultBean<T> createByError(int code, String msg) {
        return new ResultBean<>(code, msg, null);
    }
}
