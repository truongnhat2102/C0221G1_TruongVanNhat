package com.example.demo.model.repository;


import com.example.demo.model.entity.export_bill.ExportBillDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExportBillDetailRepository extends JpaRepository<ExportBillDetail, Long> {
}
