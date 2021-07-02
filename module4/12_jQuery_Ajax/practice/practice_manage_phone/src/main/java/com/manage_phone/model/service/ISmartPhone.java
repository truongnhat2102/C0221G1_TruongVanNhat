package com.manage_phone.model.service;

import com.manage_phone.model.entity.SmartPhone;

import java.util.List;

public interface ISmartPhone {
    List<SmartPhone> findAll();

    SmartPhone findById(long id);

    void save(SmartPhone smartPhone);

    void delete(long id);
}
