package com.backend.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "export_bill_type")
public class ExportBillType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long exportBillTypeId;
    private String exportBillTypeName;

    public long getExportBillTypeId() {
        return exportBillTypeId;
    }

    public void setExportBillTypeId(long exportBillTypeId) {
        this.exportBillTypeId = exportBillTypeId;
    }

    public String getExportBillTypeName() {
        return exportBillTypeName;
    }

    public void setExportBillTypeName(String exportBillTypeName) {
        this.exportBillTypeName = exportBillTypeName;
    }
}
