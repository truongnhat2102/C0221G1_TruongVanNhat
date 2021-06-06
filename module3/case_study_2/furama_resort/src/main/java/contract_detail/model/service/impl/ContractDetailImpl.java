package contract_detail.model.service.impl;

import contract_detail.model.bean.ContractDetail;
import contract_detail.model.repository.ContractDetailRepository;
import contract_detail.model.service.IContractDetail;

public class ContractDetailImpl implements IContractDetail {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public boolean add(ContractDetail contractDetail) {
        return contractDetailRepository.add(contractDetail);
    }
}
