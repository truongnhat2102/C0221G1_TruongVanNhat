package convert.service.impl;

import convert.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    @Override
    public double convert(double money, double currency) {
        return money*currency;
    }
}
