package com.ynding.cloud.physical.graphql.meta.service;

import com.ynding.cloud.common.model.bo.GQuery;
import com.ynding.cloud.physical.graphql.meta.data.UserRepository;
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

/**
 * @author ynding
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    public Page<User> pageList(GQuery query) {
        Pageable pageable =  PageRequest.of(query.getOffset(), query.getLimit(), Sort.Direction.DESC, "id");

        Page<User> page = userRepository.findAll(condition(query),pageable);

        return page;
    }


    /**
     * 查询条件
     * @param query
     * @return
     */
    private Specification<User> condition(GQuery query) {

        return (Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) -> {
            Predicate predicate = cb.conjunction();
            if (query.get("id") != null)
                predicate.getExpressions().add(cb.equal(root.get("id"), query.get("id")));
            if (query.get("nickname") != null)
                predicate.getExpressions().add(cb.like(root.get("nickname"), "%" + query.get("nickname") + "%"));
            return predicate;
        };
    }

}
