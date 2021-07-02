package com.exercise_2_manage_phone.model.service;

import com.exercise_2_manage_phone.model.entity.SmartPhone;

import java.util.List;

public interface ISmartPhone {
    List<SmartPhone> findAll();

    SmartPhone findById(long id);

    List<SmartPhone> findByName(String name);

    void save(SmartPhone smartPhone);

    void delete(long id);
}
