package service.model.service;

import service.model.bean.Service;

import java.util.List;

public interface IService {
    List<Service> findByAll();

    boolean add(Service service);
}
