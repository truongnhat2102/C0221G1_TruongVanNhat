package service.model.service.impl;

import service.model.bean.Service;
import service.model.repository.ServiceRepository;
import service.model.service.IService;

import java.util.List;

public class ServiceImple implements IService {
    ServiceRepository serviceRepository = new ServiceRepository();

    @Override
    public List<Service> findByAll() {
        return serviceRepository.findByAll();
    }

    @Override
    public Service findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public boolean add(Service service) {
        return serviceRepository.add(service);
    }
}
