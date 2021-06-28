package com.library.model.repository;

import com.library.model.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomer extends PagingAndSortingRepository<Customer, Long> {
}
