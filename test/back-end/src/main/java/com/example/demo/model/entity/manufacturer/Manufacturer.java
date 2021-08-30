package com.example.demo.model.entity.manufacturer;

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
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer manufacturerId;
    private String manufacturerCode;
    private String manufacturerName;
    private String manufacturerAddress;
    private String manufacturerEmail;
    private String manufacturerPhoneNumber;
    private String manufacturerDebts;
    private Integer manufacturerNote ;
    @OneToMany(mappedBy = "manufacturer")
    @JsonIgnore
    private List<ImportBill> importBills;
    @OneToMany(mappedBy = "manufacturer")
    @JsonIgnore
    private List<ExportBill> exportBills;
}
