package bai3_OOP.exercise;

import java.util.Scanner;

public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return (this.b * this.b) - 4 * this.a * this.c;
    }

    public double getRoot1() {
        return (getDiscriminant() - this.b) / (2 * this.a);
    }

    public double getRoot2() {
        return (-getDiscriminant() - this.b) / (2 * this.a);
    }
//    public void check(){
//        if (getDiscriminant()>0){
//            System.out.println("equation has \nroot1 = "+getRoot1()+"\nroot2 =  "+getRoot2());
//        }
//        else if (getDiscriminant()==0){
//            System.out.println("equation has \nroot = "+getRoot1());
//        }
//        else {
//            System.out.println("equation dont have root");
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the a:");
        double a = scanner.nextDouble();
        System.out.print("Enter the b:");
        double b=scanner.nextDouble();
        System.out.print("Enter the c:");
        double c=scanner.nextDouble();
        QuadraticEquation abc=new QuadraticEquation(a,b,c);
//        abc.check();
        if (abc.getDiscriminant()>0){
            System.out.println("equation has \nroot1 = "+abc.getRoot1()+"\nroot2 =  "+abc.getRoot2());
        }
        else if (abc.getDiscriminant()==0){
            System.out.println("equation has \nroot = "+abc.getRoot1());
        }
        else {
            System.out.println("equation dont have root");
        }
    }
}
