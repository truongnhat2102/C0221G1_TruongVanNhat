package extra_service.model.service.impl;

import extra_service.model.bean.ExtraService;
import extra_service.model.repository.ExtraServiceRepository;
import extra_service.model.service.IExtraService;

import java.util.List;

public class ExtraServiceImpl implements IExtraService {
    ExtraServiceRepository extraServiceRepository = new ExtraServiceRepository();
    @Override
    public List<ExtraService> findByAll() {
        return extraServiceRepository.findByAll();
    }

    @Override
    public ExtraService findById(int id) {
        return extraServiceRepository.findById(id);
    }
}
