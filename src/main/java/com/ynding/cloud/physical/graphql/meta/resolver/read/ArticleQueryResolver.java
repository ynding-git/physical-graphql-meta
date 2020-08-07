package com.ynding.cloud.physical.graphql.meta.resolver.read;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ynding.cloud.physical.graphql.meta.data.ArticleRepository;
import com.ynding.cloud.physical.graphql.meta.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ynding
 */
@Component
@Slf4j
public class ArticleQueryResolver implements GraphQLQueryResolver {

    private final ArticleRepository articleRepository;

    public ArticleQueryResolver(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }



}
