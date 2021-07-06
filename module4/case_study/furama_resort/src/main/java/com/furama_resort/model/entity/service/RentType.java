package com.furama_resort.model.entity.service;

import javax.persistence.*;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rentTypeId;
    private String rentTypeName;

    public long getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(long rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }
}
