package com.ynding.cloud.physical.graphql.meta.resolver.read;

import com.ynding.cloud.physical.graphql.meta.bo.GQuery;
import com.ynding.cloud.physical.graphql.meta.bo.ResponseBean;
import com.ynding.cloud.physical.graphql.meta.data.ArticleRepository;
import com.ynding.cloud.physical.graphql.meta.data.UserRepository;
import com.ynding.cloud.physical.graphql.meta.entity.Article;
import com.ynding.cloud.physical.graphql.meta.entity.User;
import com.ynding.cloud.physical.graphql.meta.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ynding
 */
@Component
@Slf4j
public class UserQueryResolver implements GraphQLQueryResolver {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final UserService userService;

    public UserQueryResolver(UserRepository userRepository, ArticleRepository articleRepository, UserService userService) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.userService = userService;
    }

    /**
     * @param title
     * @return
     */
    public Article article(String title) {
        return articleRepository.findTopArticleByTitle(title);
    }

    public List<Article> articles() {
        return articleRepository.findAll();
    }

    public ResponseBean user(String nickname) {
        try{
            User user = userRepository.findUserByNickname(nickname);
            return ResponseBean.ok(user);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseBean.fail(500);
        }
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
    public long userPageCount(Map<String, Object> params){
        if(params == null){
            params = new HashMap<>();
        }
        GQuery query = new GQuery(params);
        List<User> users = userService.findList(query);
        return users == null?0:users.size();
    }

}
