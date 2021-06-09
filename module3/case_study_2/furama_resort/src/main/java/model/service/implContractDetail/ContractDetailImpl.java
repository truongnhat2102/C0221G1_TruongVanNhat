package model.service.implContractDetail;

import model.bean.ContractDetail;
import model.repository.ContractDetailRepository;
import model.service.IContractDetail;

public class ContractDetailImpl implements IContractDetail {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public boolean add(ContractDetail contractDetail) {
        return contractDetailRepository.add(contractDetail);
    }
}
