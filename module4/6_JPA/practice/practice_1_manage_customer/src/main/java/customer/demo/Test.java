package customer.demo;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List result = new ArrayList();
        for (int i = 100; i < 1000; i++) {
            boolean check = false;
            int a = i/100;
            int b = a%100/10;
            int c = b%10;
            if (a%c == 4 || c%a == 4 ){
                if (b-a == 8){
                    check = true;
                }
            }
            if (check == true) {
                System.out.println(i);
            }
        }

    }
}
