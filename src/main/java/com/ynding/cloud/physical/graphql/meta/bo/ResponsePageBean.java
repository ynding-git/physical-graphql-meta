package com.ynding.cloud.physical.graphql.meta.bo;

import java.util.List;

/**
 * 分页bean
 */
public class ResponsePageBean extends ResponseBean {
    private long total;

    private ResponsePageBean(List data, long total) {
        super(data);
        this.total = total;
    }

    public static  ResponsePageBean ok(List data, long total) {
        return new ResponsePageBean(data, total);
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}