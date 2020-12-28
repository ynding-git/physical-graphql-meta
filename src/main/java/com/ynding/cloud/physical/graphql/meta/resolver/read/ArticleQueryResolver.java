package com.ynding.cloud.physical.graphql.meta.resolver.read;

import com.ynding.cloud.physical.graphql.meta.bo.ArticleResponseBean;
import com.ynding.cloud.physical.graphql.meta.bo.GQuery;
import com.ynding.cloud.physical.graphql.meta.bo.ResponseBean;
import com.ynding.cloud.physical.graphql.meta.bo.ResponsePageBean;
import com.ynding.cloud.physical.graphql.meta.data.ArticleRepository;
import com.ynding.cloud.physical.graphql.meta.entity.Article;
import com.ynding.cloud.physical.graphql.meta.service.ArticleService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ynding
 */
@Component
@Slf4j
public class ArticleQueryResolver implements GraphQLQueryResolver {

    private final ArticleService articleService;
    private final ArticleRepository articleRepository;

    public ArticleQueryResolver(ArticleService articleService, ArticleRepository articleRepository) {
        this.articleService = articleService;
        this.articleRepository = articleRepository;
    }


    /**
     * 查找文章列表
     * @param params
     * @return
     */
    public ResponseBean articleList(Map<String, Object> params) {
        if (params == null) {
            params = new HashMap<>();
        }
        GQuery query = new GQuery(params);

        return ResponseBean.ok(articleService.articleList(query));
    }

    /**
     * 查找文章
     * @return
     */
    public ArticleResponseBean findArticleById(long id) {
        return ArticleResponseBean.ok(articleRepository.findById(id).orElse(null));
    }

    /**
     * 分页查询
     * @param page
     * @param limit
     * @param params
     * @return
     */
    public ResponsePageBean articlePage(int page, int limit, Map<String, Object> params){
        try{
            if(params == null){
                params = new HashMap<>();
            }
            params.put("page",page);
            params.put("limit",limit);
            GQuery query = new GQuery(params);
            Page<Article> articlePage = articleService.pageList(query);
            return ResponsePageBean.ok(articlePage.getContent(),articlePage.getTotalElements());
        }catch (Exception e){
            e.printStackTrace();
            return ResponsePageBean.fail(500,e.getMessage());
        }

    }

}
