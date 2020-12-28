package com.ynding.cloud.physical.graphql.meta.resolver;

import com.ynding.cloud.physical.graphql.meta.bo.ResponsePageBean;
import com.ynding.cloud.physical.graphql.meta.data.UserRepository;
import com.ynding.cloud.physical.graphql.meta.entity.Article;
import com.ynding.cloud.physical.graphql.meta.entity.User;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

/**
 * @author ynding
 */
@Component
public class ArticleResolver implements GraphQLResolver<Article> {
    private final UserRepository userRepository;

    public ArticleResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User author(Article article) {
        return userRepository.findById(article.getAuthorId()).get();
    }
}
