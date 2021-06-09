package model.service;

import model.bean.Service;

import java.util.List;

public interface IService {
    List<Service> findByAll();

    Service findById(int id);

    boolean add(Service service);
}
