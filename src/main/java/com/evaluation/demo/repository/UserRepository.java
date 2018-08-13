package com.evaluation.demo.repository;

import com.evaluation.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findOneByEmail(String email);
}
