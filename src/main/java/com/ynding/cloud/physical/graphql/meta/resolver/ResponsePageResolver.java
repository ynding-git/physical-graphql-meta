package com.ynding.cloud.physical.graphql.meta.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.ynding.cloud.physical.graphql.meta.bo.ResponsePageBean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ynding
 */
//@Component
public class  ResponsePageResolver implements  GraphQLResolver<ResponsePageBean> {

    public Object data(ResponsePageBean responsePageBean){
        return responsePageBean.getData();
    }
}
