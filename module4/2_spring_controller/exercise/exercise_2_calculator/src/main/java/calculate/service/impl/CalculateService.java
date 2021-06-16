package calculate.service.impl;

import calculate.repository.CalculateRepository;
import calculate.service.ICalculate;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculate {
    CalculateRepository calculateRepository = new CalculateRepository();

    @Override
    public double calculate(double num1, double num2, int situation) {
        double result = 0.0;
        switch (situation){
            case 1:
                result = calculateRepository.sum(num1,num2);
                break;
            case 2:
                result = calculateRepository.sub(num1, num2);
                break;
            case 3:
                result = calculateRepository.multi(num1, num2);
                break;
            case 4:
                result = calculateRepository.divi(num1, num2);
                break;
        }
        return result;
    }
}
