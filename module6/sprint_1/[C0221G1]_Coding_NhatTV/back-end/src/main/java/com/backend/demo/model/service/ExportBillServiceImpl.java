package com.backend.demo.model.service;

import com.backend.demo.model.entity.ExportBill;
import org.springframework.data.domain.Page;

public interface ExportBillServiceImpl {
    Page<ExportBill> findAll();

    Page<ExportBill> findByFields(String field1, String field2, String field3, String field4, String field5);

    ExportBill findById(long id);

    void delete(long id);
}
