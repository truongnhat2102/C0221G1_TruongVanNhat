import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {

            int a = i/100;
            int b = i%100/10;
            int c = (i%100)%10;

            if (c!= 0 && a!= 0){
                if ((a%c == 4 || c%a == 4) && b-a == 8){
                    System.out.println(i);
                }
            }
        }
    }
}
