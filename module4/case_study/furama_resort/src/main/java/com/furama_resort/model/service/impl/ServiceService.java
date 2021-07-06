package com.furama_resort.model.service.impl;

import com.furama_resort.model.entity.service.RentType;
import com.furama_resort.model.entity.service.Service;
import com.furama_resort.model.entity.service.ServiceType;
import com.furama_resort.model.repository.service_repository.RentTypeRepository;
import com.furama_resort.model.repository.service_repository.ServiceRepository;
import com.furama_resort.model.repository.service_repository.ServiceTypeRepository;
import com.furama_resort.model.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceService implements IService {

    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<Service> findAllService() {
        return (List<Service>) serviceRepository.findAll();
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public List<RentType> findAllRentType() {
        return (List<RentType>) rentTypeRepository.findAll();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return (List<ServiceType>) serviceTypeRepository.findAll();
    }
}
