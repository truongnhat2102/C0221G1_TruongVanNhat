package service.model.service;

import service.model.bean.Service;

import java.util.List;

public interface IService {
    List<Service> findByAll();

    Service findById(int id);

    boolean add(Service service);
}
