package com.furama_resort.model.service.impl;

import com.furama_resort.model.entity.contract_detail.AttachService;
import com.furama_resort.model.entity.contract_detail.ContractDetail;
import com.furama_resort.model.repository.contract_detail_repository.AttachServiceRepository;
import com.furama_resort.model.repository.contract_detail_repository.ContractDetailRepository;
import com.furama_resort.model.service.IContractDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetail {

    @Autowired
    ContractDetailRepository contractDetailRepository;
    @Autowired
    AttachServiceRepository attachServiceRepository;

    @Override
    public List<ContractDetail> findAllContractDetail() {
        return (List<ContractDetail>) contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findContractDetailById(long id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return (List<AttachService>) attachServiceRepository.findAll();
    }
}
