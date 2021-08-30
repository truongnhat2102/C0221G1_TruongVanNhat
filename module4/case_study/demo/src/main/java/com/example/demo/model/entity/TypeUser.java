package com.example.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "type_user")
public class TypeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long typeUserId;
    private String typeUserName;

    public long getTypeUserId() {
        return typeUserId;
    }

    public void setTypeUserId(long typeUserId) {
        this.typeUserId = typeUserId;
    }

    public String getTypeUserName() {
        return typeUserName;
    }

    public void setTypeUserName(String typeUserName) {
        this.typeUserName = typeUserName;
    }
}
