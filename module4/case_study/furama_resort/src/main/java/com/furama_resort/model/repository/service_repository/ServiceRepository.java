package com.furama_resort.model.repository.service_repository;

import com.furama_resort.model.entity.service.Service;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service, Long> {
}
