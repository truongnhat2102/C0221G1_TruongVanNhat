package extra_service.model.service;

import extra_service.model.bean.ExtraService;

import java.util.List;

public interface IExtraService {
    public List<ExtraService> findByAll();

    public ExtraService findById(int id);
}
