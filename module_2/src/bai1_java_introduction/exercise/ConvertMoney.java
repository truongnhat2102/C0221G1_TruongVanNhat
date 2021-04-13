package bai1_java_introduction.exercise;

import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter money (VND)");
        double money=sc.nextDouble();
        System.out.println((money/23000)+"USD");
    }
}
