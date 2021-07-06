package com.furama_resort.model.entity.service;

import javax.persistence.*;

@Entity
@Table(name = "service_type")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long serviceTypeId;
    private String serviceTypeName;

    public long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
