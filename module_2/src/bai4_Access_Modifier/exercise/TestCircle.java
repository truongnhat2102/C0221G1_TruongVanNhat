package bai4_Access_Modifier.exercise;

import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter radius of circle");
        double rad=sc.nextDouble();
        System.out.println();
        Circle circle=new Circle(rad);
        System.out.println(circle.toString());

    }
}
