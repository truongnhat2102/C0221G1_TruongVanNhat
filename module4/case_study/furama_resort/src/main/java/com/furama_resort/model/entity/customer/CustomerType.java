package com.furama_resort.model.entity.customer;

import javax.persistence.*;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerTypeId;

    private String customerTypeName;

    public CustomerType() {
    }

    public long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
