package com.furama_resort.model.repository.customer_repository;

import com.furama_resort.model.entity.customer.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCustomerRepository extends PagingAndSortingRepository<CustomerType, Long> {
}
