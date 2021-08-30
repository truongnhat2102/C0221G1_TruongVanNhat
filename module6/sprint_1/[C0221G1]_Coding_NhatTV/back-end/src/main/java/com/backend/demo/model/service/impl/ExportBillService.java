package com.backend.demo.model.service.impl;

import com.backend.demo.model.entity.ExportBill;
import com.backend.demo.model.repository.ExportBillRepository;
import com.backend.demo.model.service.ExportBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ExportBillService implements ExportBillServiceImpl {

    @Autowired
    ExportBillRepository exportBillRepository;

    @Override
    public Page<ExportBill> findAll() {
        return null;
    }

    @Override
    public Page<ExportBill> findByFields(String field1, String field2, String field3, String field4, String field5) {
        return null;
    }

    @Override
    public ExportBill findById(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
