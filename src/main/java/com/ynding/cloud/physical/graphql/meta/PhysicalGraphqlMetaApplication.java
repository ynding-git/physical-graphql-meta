package com.ynding.cloud.physical.graphql.meta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
public class PhysicalGraphqlMetaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhysicalGraphqlMetaApplication.class, args);
    }

    //让Spring管理JPAQueryFactory

}