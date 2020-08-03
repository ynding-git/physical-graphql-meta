package com.ynding.cloud.physical.graphql.meta.data;

import com.ynding.cloud.physical.graphql.meta.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ynding
 */
public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {

    Article findArticleByTitle(String title);

}
