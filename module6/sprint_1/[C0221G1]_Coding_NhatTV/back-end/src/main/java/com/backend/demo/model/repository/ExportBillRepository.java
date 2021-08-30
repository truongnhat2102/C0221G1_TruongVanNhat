package com.backend.demo.model.repository;

import com.backend.demo.model.entity.ExportBill;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExportBillRepository extends PagingAndSortingRepository<ExportBill, Long> {
    public static Page<ExportBill> findByFields(String field1, String field2, String field3, String field4, String field5){

    }
}
