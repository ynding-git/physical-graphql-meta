package com.ynding.cloud.physical.graphql.meta.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.ynding.cloud.physical.graphql.meta.bo.ResponsePageBean;

/**
 * @author ynding
 */
//@Component
public class  ResponsePageResolver<T> implements  GraphQLResolver<ResponsePageBean<T>> {

    public T data(ResponsePageBean<T> responsePageBean){
        return responsePageBean.getData();
    }
}
