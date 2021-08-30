package com.example.export.model.entity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "export_bill")
public class ExportBill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int exportBillId;
    private String exportBillCode;
    private Date exportBillDate;
    private String reason;
    private String address;

    @ManyToOne
    @JoinColumn(name = "export_bill_type_id")
    private ExportBillType exportBillType;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    public int getExportBillId() {
        return exportBillId;
    }

    public void setExportBillId(int exportBillId) {
        this.exportBillId = exportBillId;
    }

    public String getExportBillCode() {
        return exportBillCode;
    }

    public void setExportBillCode(String exportBillCode) {
        this.exportBillCode = exportBillCode;
    }

    public Date getExportBillDate() {
        return exportBillDate;
    }

    public void setExportBillDate(String exportBillDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = sdf.parse(exportBillDate);
        this.exportBillDate = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ExportBillType getExportBillType() {
        return exportBillType;
    }

    public void setExportBillType(ExportBillType exportBillType) {
        this.exportBillType = exportBillType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    //    public Date getDateCreate() {
//        return dateCreate;
//    }
//
//    public void setDateCreate(String dateCreate) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        Date dateCr = sdf.parse(dateCreate);
//        this.dateCreate = dateCr;
//    }
//
//    public Date getTimeCreate() {
//        return timeCreate;
//    }
//
//    public void setTimeCreate(String timeCreate) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//        Date timeCr = sdf.parse(timeCreate);
//        this.timeCreate = timeCr;
//    }
}
