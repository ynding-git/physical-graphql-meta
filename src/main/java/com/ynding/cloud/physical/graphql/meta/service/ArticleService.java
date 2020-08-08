package com.ynding.cloud.physical.graphql.meta.service;

import com.ynding.cloud.physical.graphql.meta.bo.GQuery;
import com.ynding.cloud.physical.graphql.meta.data.ArticleRepository;
import com.ynding.cloud.physical.graphql.meta.entity.Article;
import com.ynding.cloud.physical.graphql.meta.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author ynding
 */
@Service
@Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> articleList(GQuery query) {
        return articleRepository.findAll(condition(query));
    }

    public Page<Article> pageList(GQuery query) {
        Pageable pageable =  PageRequest.of(query.getOffset(), query.getLimit(), Sort.Direction.DESC, "id");
        Page<Article> page = articleRepository.findAll(condition(query),pageable);
        return page;
    }

    /**
     * 查询条件
     *
     * @param query
     * @return
     */
    private Specification<Article> condition(GQuery query) {

        return (Root<Article> root, CriteriaQuery<?> cq, CriteriaBuilder cb) -> {
            Predicate predicate = cb.conjunction();
            if (query.get("id") != null) {
                predicate.getExpressions().add(cb.equal(root.get("id"), query.get("id")));
            }
            if (query.get("title") != null) {
                predicate.getExpressions().add(cb.like(root.get("title"), "%" + query.get("title") + "%"));
            }
            return predicate;
        };
    }


}
