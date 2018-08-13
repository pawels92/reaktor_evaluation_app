package com.evaluation.demo.repository;

import com.evaluation.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<User, Long> {
}
