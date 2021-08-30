package com.example.export.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExportBillType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int exportBillTypeId;
    private String exportBillTypeName;
}
