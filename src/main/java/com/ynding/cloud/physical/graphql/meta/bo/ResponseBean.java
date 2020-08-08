package com.ynding.cloud.physical.graphql.meta.bo;

/**
 * 返回数据bean
 */
public class ResponseBean {
    private int code = 200;
    private String message = "";
    private Object data;

    public ResponseBean() {
    }

    public ResponseBean(Object data) {
        this.data = data;
    }

    public ResponseBean(String message) {
        this.message = message;
    }

    public ResponseBean(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public ResponseBean(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResponseBean(int code) {
        this.code = code;
    }

    public ResponseBean(IResponseCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public ResponseBean(Object data, IResponseCode errorCode) {
        this.data = data;
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public static ResponseBean ok() {
        return new ResponseBean();
    }

    public static ResponseBean ok(Object data) {
        return new ResponseBean(data);
    }
    public static  ResponseBean ok(String message, Object data) {
        return new ResponseBean(message,data);
    }

    public static  ResponseBean fail() {
        return new ResponseBean();
    }

    public static ResponseBean fail(IResponseCode errorCode) {
        return new ResponseBean(errorCode);
    }

    public static  ResponseBean fail(IResponseCode errorCode, Object data) {
        return new ResponseBean(data, errorCode);
    }

    public static  ResponseBean fail(String message) {
        return new ResponseBean(message);
    }

    public static  ResponseBean fail(int code) {
        return new ResponseBean(code);
    }

    public static  ResponseBean fail(String message, int code) {
        return new ResponseBean(message, code);
    }

    public int getCode() {
        return this.code;
    }

    public ResponseBean setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ResponseBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return this.data;
    }

    public ResponseBean setData(Object data) {
        this.data = data;
        return this;
    }
}
