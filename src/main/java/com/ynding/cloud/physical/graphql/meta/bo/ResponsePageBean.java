package com.ynding.cloud.physical.graphql.meta.bo;

/**
 * 分页bean
 */
public class ResponsePageBean extends ResponseBean {
    private long total;

    private ResponsePageBean(Object data, long total) {
        super(data);
        this.total = total;
    }

    private ResponsePageBean(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public static  ResponsePageBean ok(Object data, long total) {
        return new ResponsePageBean(data, total);
    }

    public static  ResponsePageBean fail(int code, String message) {
        return new ResponsePageBean(code, message);
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}