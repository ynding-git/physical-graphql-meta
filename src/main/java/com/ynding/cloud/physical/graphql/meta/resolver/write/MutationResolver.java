package com.ynding.cloud.physical.graphql.meta.resolver.write;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ynding.cloud.physical.graphql.meta.data.ArticleRepository;
import com.ynding.cloud.physical.graphql.meta.data.UserRepository;
import com.ynding.cloud.physical.graphql.meta.entity.Article;
import com.ynding.cloud.physical.graphql.meta.entity.User;
import com.ynding.cloud.physical.graphql.meta.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ynding
 */
@Component
public class MutationResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public MutationResolver(ArticleRepository articleRepository,
                            UserRepository userRepository,
                            UserService userService) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public User addUser(String mail, String nickname, String password) {
        if (userRepository.findUserByNickname(nickname) != null) {
            return null;
        }
        return userRepository.save(User.builder()
                .nickname(nickname)
                .mail(mail)
                .password(new BCryptPasswordEncoder().encode(password))
                .build());
    }

    public Boolean deleteUser(Long id){
        return userService.deleteById(id);
    }


    public Article addArticle(String title, String content, Long authorId) {
        if (!userRepository.findById(authorId).isPresent()) {
            return null;
        }
        return articleRepository.save(Article.builder()
                .authorId(authorId)
                .title(title)
                .content(content)
                .createBy(new Date())
                .thumbUp(0)
                .build());
    }





}
