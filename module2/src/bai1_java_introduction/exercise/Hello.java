package bai1_java_introduction.exercise;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter your name:");
        String name= sc.nextLine();
        System.out.println("hello "+name);
    }
}
