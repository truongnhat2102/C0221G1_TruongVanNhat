package com.example.demo.model.repository;


import com.example.demo.model.entity.export_bill.ExportBillType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExportBillTypeRepository extends JpaRepository<ExportBillType, Long> {
}
