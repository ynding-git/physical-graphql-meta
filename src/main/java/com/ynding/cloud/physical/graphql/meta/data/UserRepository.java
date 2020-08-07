package com.ynding.cloud.physical.graphql.meta.data;

import com.ynding.cloud.physical.graphql.meta.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ynding
 *
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findUserByNickname(String nickname);

    Boolean deleteByNickname(String nickname);
}
