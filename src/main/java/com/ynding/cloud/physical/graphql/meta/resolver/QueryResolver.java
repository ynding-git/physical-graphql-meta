package com.ynding.cloud.physical.graphql.meta.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ynding.cloud.common.model.bo.GQuery;
import com.ynding.cloud.common.model.bo.ResponsePageBean;
import com.ynding.cloud.common.model.entity.book.Book;
import com.ynding.cloud.physical.graphql.meta.data.ArticleRepository;
import com.ynding.cloud.physical.graphql.meta.data.UserRepository;
import com.ynding.cloud.physical.graphql.meta.entity.Article;
import com.ynding.cloud.physical.graphql.meta.entity.User;
import com.ynding.cloud.physical.graphql.meta.service.UserService;
import graphql.relay.Connection;
import graphql.relay.Edge;
import graphql.relay.PageInfo;
import graphql.relay.SimpleListConnection;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ynding
 */
@Component
public class QueryResolver implements GraphQLQueryResolver {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final UserService userService;

    public QueryResolver(UserRepository userRepository, ArticleRepository articleRepository, UserService userService) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.userService = userService;
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

    public List<User> userPage(int page, int limit, Map<String, Object> params){
        if(params == null){
            params = new HashMap<>();
        }
        params.put("page",page);
        params.put("limit",limit);
        GQuery query = new GQuery(params);
        Page<User> userPage = userService.pageList(query);

        return userPage.getContent();
    }
}
