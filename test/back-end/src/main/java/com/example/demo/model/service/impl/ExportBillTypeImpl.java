package com.example.demo.model.service.impl;


import com.example.demo.model.entity.export_bill.ExportBillType;
import com.example.demo.model.repository.ExportBillTypeRepository;
import com.example.demo.model.service.ExportBillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportBillTypeImpl implements ExportBillTypeService {
    @Autowired
    private ExportBillTypeRepository exportBillTypeRepository;
    @Override
    public List<ExportBillType> findAllExportBillType() {
        return exportBillTypeRepository.findAll();
    }
}
