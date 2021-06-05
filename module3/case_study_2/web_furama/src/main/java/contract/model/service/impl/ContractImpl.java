package contract.model.service.impl;

import contract.model.bean.Contract;
import contract.model.repository.ContractRepository;
import contract.model.service.IContract;

import java.util.List;

public class ContractImpl implements IContract {
    ContractRepository contractRepository = new ContractRepository();
    @Override
    public boolean add(Contract contract) {
        return contractRepository.add(contract);
    }

    @Override
    public List<Contract> findByAll() {
        return null;
    }
}
