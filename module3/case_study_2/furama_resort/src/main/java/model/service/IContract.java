package model.service;

import model.bean.Contract;

import java.util.List;

public interface IContract {
    boolean add(Contract contract);
    List<Contract> findByAll();
}
