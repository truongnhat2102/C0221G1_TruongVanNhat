package bai2_loop.exercise;

public class exercise2 {
    public static void main(String[] args) {
        int count = 0;
        for (int j = 0; j < 1000; j++) {
            if (count == 20) {
                break;
            } else if (checkPrime(j) == true) {
                System.out.print(j+",");
                count++;
            }
        }
        System.out.println();
        System.out.print(count);
    }

    public static boolean checkPrime(int num) {
        boolean check = true;
        if (num > 2) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
        } else {
            check = false;
        }
        return check;
    }

}
