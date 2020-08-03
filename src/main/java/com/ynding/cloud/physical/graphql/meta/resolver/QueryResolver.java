package com.ynding.cloud.physical.graphql.meta.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ynding.cloud.physical.graphql.meta.data.ArticleRepository;
import com.ynding.cloud.physical.graphql.meta.data.UserRepository;
import com.ynding.cloud.physical.graphql.meta.entity.Article;
import com.ynding.cloud.physical.graphql.meta.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ynding
 */
@Component
public class QueryResolver implements GraphQLQueryResolver {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public QueryResolver(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    public Article article(String title) {
        return articleRepository.findArticleByTitle(title);
    }

    public User user(String nickname) {
        return userRepository.findUserByNickname(nickname);
    }

    public List<User> users() {
        return userRepository.findAll();
    }
}
