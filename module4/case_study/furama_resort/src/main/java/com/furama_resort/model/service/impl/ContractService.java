package com.furama_resort.model.service.impl;

import com.furama_resort.model.entity.contract.Contract;
import com.furama_resort.model.repository.contract_repository.ContractRepository;
import com.furama_resort.model.service.IContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContract {

    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Contract> findAllContract() {
        return (List<Contract>) contractRepository.findAll();
    }

    @Override
    public Contract findContractById(long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
