package com.ynding.cloud.physical.graphql.meta.bo;

import com.ynding.cloud.physical.graphql.meta.entity.Article;

/**
 * @author ynding
 */
public class ArticleResponseBean {
    private int code = 200;
    private String message = "";
    private Article data;

    public ArticleResponseBean() {
    }

    public ArticleResponseBean(Article data) {
        this.data = data;
    }

    public ArticleResponseBean(String message) {
        this.message = message;
    }

    public ArticleResponseBean(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public ArticleResponseBean(String message, Article data) {
        this.message = message;
        this.data = data;
    }

    public ArticleResponseBean(int code) {
        this.code = code;
    }

    public ArticleResponseBean(IResponseCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public ArticleResponseBean(Article data, IResponseCode errorCode) {
        this.data = data;
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public static ArticleResponseBean ok() {
        return new ArticleResponseBean();
    }

    public static ArticleResponseBean ok(Article data) {
        return new ArticleResponseBean(data);
    }
    public static  ArticleResponseBean ok(String message, Article data) {
        return new ArticleResponseBean(message,data);
    }

    public static  ArticleResponseBean fail() {
        return new ArticleResponseBean();
    }

    public static ArticleResponseBean fail(IResponseCode errorCode) {
        return new ArticleResponseBean(errorCode);
    }

    public static  ArticleResponseBean fail(IResponseCode errorCode, Article data) {
        return new ArticleResponseBean(data, errorCode);
    }

    public static  ArticleResponseBean fail(String message) {
        return new ArticleResponseBean(message);
    }

    public static  ArticleResponseBean fail(int code) {
        return new ArticleResponseBean(code);
    }

    public static  ArticleResponseBean fail(String message, int code) {
        return new ArticleResponseBean(message, code);
    }

    public int getCode() {
        return this.code;
    }

    public ArticleResponseBean setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ArticleResponseBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public Article getData() {
        return this.data;
    }

    public ArticleResponseBean setData(Article data) {
        this.data = data;
        return this;
    }
}
