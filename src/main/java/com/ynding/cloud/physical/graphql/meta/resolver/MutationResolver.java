package com.ynding.cloud.physical.graphql.meta.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ynding.cloud.physical.graphql.meta.data.ArticleRepository;
import com.ynding.cloud.physical.graphql.meta.data.UserRepository;
import com.ynding.cloud.physical.graphql.meta.entity.Article;
import com.ynding.cloud.physical.graphql.meta.entity.User;
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

    public MutationResolver(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
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
