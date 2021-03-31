package exercise;

import java.util.Scanner;

public class exercise3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int money= sc.nextInt();
        int result= money*23000;
        System.out.println(money+" USD = "+result+" VND");
    }
}
