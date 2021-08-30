package com.example.demo.model.entity.employee;

import com.example.demo.model.entity.bill_sale.BillSale;
import com.example.demo.model.entity.export_bill.ExportBill;
import com.example.demo.model.entity.import_bill_payment.ImportBill;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeeAddress;
    private String employeeImage;
    private String employeePhone;
    private String employeeStartDate;
    private String employeeNote;
    private int position;
    private String accountName;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    List<ImportBill> importBills;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    List<ExportBill> exportBills;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    List<BillSale> billWholesales;
}
