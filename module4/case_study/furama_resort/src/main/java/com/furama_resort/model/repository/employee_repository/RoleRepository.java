package com.furama_resort.model.repository.employee_repository;

import com.furama_resort.model.entity.employee.Role;
import com.furama_resort.model.entity.employee.User;
import com.furama_resort.model.entity.employee.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
