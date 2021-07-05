package com.test.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import com.test.model.entity.AppRole;
import com.test.model.entity.AppUser;
import com.test.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
