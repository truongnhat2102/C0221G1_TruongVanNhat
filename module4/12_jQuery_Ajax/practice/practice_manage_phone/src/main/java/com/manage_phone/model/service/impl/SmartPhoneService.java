package com.manage_phone.model.service.impl;

import com.manage_phone.model.entity.SmartPhone;
import com.manage_phone.model.repository.ISmartPhoneRepository;
import com.manage_phone.model.service.ISmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void save(SmartPhone smartPhone) {
        iSmartPhoneRepository.save(smartPhone);
    }

    @Override
    public void delete(long id) {
        iSmartPhoneRepository.deleteById(id);
    }
}
