package com.furama_resort.model.repository.employee_repository;

import com.furama_resort.model.entity.employee.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
