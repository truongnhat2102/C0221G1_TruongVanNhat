package condiment.service.impl;

import condiment.repository.CondimentRepository;
import condiment.service.ICondiment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentService implements ICondiment {
    CondimentRepository condimentRepository = new CondimentRepository();

    @Override
    public void saveConmediant(String spices) {
        condimentRepository.add(spices);
    }

    @Override
    public List<String> findByAll() {
        return condimentRepository.findByAll();
    }
}
