package com.evaluation.demo.repository;

import com.evaluation.demo.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    //metoda zwracająca obiekt klasy Role dla ROLE_USER
    Role findOneByRoleName (String roleName);

}
