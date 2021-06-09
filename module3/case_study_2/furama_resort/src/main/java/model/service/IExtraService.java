package model.service;

import model.bean.ExtraService;

import java.util.List;

public interface IExtraService {
    public List<ExtraService> findByAll();

    public ExtraService findById(int id);
}
