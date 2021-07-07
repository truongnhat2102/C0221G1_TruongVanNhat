package com.furama_resort.model.service;

import com.furama_resort.model.entity.contract_detail.AttachService;
import com.furama_resort.model.entity.contract_detail.ContractDetail;

import java.util.List;

public interface IContractDetail {
    List<ContractDetail> findAllContractDetail();

    ContractDetail findContractDetailById(long id);

    void saveContractDetail(ContractDetail contractDetail);

    List<AttachService> findAllAttachService();
}
