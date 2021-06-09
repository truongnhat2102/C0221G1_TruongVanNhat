package model.service.implExtraService;

import model.bean.ExtraService;
import model.repository.ExtraServiceRepository;
import model.service.IExtraService;

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
