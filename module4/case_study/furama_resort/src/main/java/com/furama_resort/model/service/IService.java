package com.furama_resort.model.service;

import com.furama_resort.model.entity.service.RentType;
import com.furama_resort.model.entity.service.Service;
import com.furama_resort.model.entity.service.ServiceType;

import java.util.List;

public interface IService {
    List<Service> findAllService();

    void save(Service service);

    List<RentType> findAllRentType();

    List<ServiceType> findAllServiceType();
}
