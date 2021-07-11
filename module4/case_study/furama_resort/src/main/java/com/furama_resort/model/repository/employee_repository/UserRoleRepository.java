package com.furama_resort.model.repository.employee_repository;

import com.furama_resort.model.entity.employee.User;
import com.furama_resort.model.entity.employee.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUser(User user);
}
