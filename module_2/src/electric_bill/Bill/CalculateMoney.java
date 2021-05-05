package electric_bill.Bill;

import javax.swing.*;

public class CalculateMoney {
    public static double localCalculate(String consumption) {
        double consump = Integer.parseInt(consumption);
        double price;
        switch (checkConsumption(consumption)) {
            case 1:
                price = consump * 1.678;
                break;
            case 2:
                price = 50 * 1.678 + (consump - 50) * 1.734;
                break;
            case 3:
                price = 50 * 1.678 + 50 * 1.734 + (consump - 100) * 2.014;
                break;
            case 4:
                price = 50 * 1.678 + 50 * 1.734 + 100 * 2.014 + (consump - 200) * 2.536;
                break;
            case 5:
                price = 50 * 1.678 + 50 * 1.734 + 100 * 2.014 + 100 * 2.536 + (consump - 300) * 2.834;
                break;
            case 6:
                price = 50 * 1.678 + 50 * 1.734 + 100 * 2.014 + 100 * 2.536 + 100 * 2.834 + (consump - 400) * 2.927;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + checkConsumption(consumption));
        }
        return price;
    }

    public static double internationalCalculate(String consumption) {
        double consump = Double.parseDouble(consumption);
        return consump * 2.0;
    }

    public static int checkConsumption(String consumption) {
        int i = Integer.parseInt(consumption);
        if (i <= 50) {
            return 1;
        } else if (i <= 100) {
            return 2;
        } else if (i <= 200) {
            return 3;
        } else if (i <= 300) {
            return 4;
        } else if (i <= 400) {
            return 5;
        }
        return 6;
    }

}
