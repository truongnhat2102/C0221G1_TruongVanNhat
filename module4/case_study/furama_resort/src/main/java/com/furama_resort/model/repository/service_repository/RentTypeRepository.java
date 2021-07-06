package com.furama_resort.model.repository.service_repository;

import com.furama_resort.model.entity.service.RentType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepository extends PagingAndSortingRepository<RentType, Long> {
}
