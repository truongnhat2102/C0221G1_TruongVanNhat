package com.furama_resort.model.entity.contract_detail;

import javax.persistence.*;

@Entity
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long attachServiceId;
    private String attachServiceName;
    private double attachServiceCost;
    private int attachServiceUnit;
    private String attachServiceStatus;

    public long getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(long attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public int getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(int attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
