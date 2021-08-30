package com.example.demo.model.repository;

import com.example.demo.model.entity.TypeUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeUserRepository extends PagingAndSortingRepository<TypeUser, Long> {
}
