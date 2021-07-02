package com.exercise_2_manage_phone.model.service.impl;


import com.exercise_2_manage_phone.model.entity.SmartPhone;
import com.exercise_2_manage_phone.model.repository.ISmartPhoneRepository;
import com.exercise_2_manage_phone.model.service.ISmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SmartPhoneService implements ISmartPhone {

    @Autowired
    ISmartPhoneRepository iSmartPhoneRepository;

    @Override
    public List<SmartPhone> findAll() {
        return (List<SmartPhone>) iSmartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(long id) {
        return iSmartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public List<SmartPhone> findByName(String name) {
        List<SmartPhone> smartPhoneList = new ArrayList<>();
        for (long i = 0; i < findAll().size(); i++) {
            if (findById(i).getModel().contains(name)){
                smartPhoneList.add(findById(i));
            }
        }
        return smartPhoneList;
    }

    @Override
    public void save(SmartPhone smartPhone) {
        iSmartPhoneRepository.save(smartPhone);
    }

    @Override
    public void delete(long id) {
        iSmartPhoneRepository.deleteById(id);
    }
}
