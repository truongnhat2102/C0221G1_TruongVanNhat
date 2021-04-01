package bai2_loop.exercise;


import static bai2_loop.exercise.exercise2.checkPrime;

public class exercise3 {
    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            if (checkPrime(j) == true) {
                System.out.print(j+",");
            }
        }
    }
}
