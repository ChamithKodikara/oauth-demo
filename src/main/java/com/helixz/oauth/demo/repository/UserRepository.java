package com.helixz.oauth.demo.repository;

import com.helixz.oauth.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chamith
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
