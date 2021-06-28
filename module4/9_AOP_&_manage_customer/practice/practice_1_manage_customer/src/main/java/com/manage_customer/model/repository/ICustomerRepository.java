package com.manage_customer.model.repository;

import com.manage_customer.model.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
