package convert.service.impl;

import convert.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    @Override
    public double convert(double money, int i) {
        double currency = 1;
        switch (i){
            case 1:
                currency = 0.00004347826;
                break;
            case 2:

                currency = 23000;
                break;
            default:
                currency = 1;
                break;
        }
        return money*currency;
    }
}
