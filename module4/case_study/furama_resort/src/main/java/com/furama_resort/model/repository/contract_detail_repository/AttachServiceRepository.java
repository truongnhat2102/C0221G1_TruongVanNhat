package com.furama_resort.model.repository.contract_detail_repository;

import com.furama_resort.model.entity.contract_detail.AttachService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachServiceRepository extends PagingAndSortingRepository<AttachService, Long> {
}
