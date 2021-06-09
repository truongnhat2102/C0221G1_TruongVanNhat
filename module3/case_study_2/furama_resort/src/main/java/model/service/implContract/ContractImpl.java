package model.service.implContract;

import model.bean.Contract;
import model.repository.ContractRepository;
import model.service.IContract;

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
