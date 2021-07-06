package com.furama_resort.model.repository.contract_repository;

import com.furama_resort.model.entity.contract.Contract;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends PagingAndSortingRepository<Contract, Long> {
}
