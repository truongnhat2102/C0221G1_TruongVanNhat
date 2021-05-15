package bai5_Inheritance.exercise;

import bai5_Inheritance.practice.Shape;

import java.util.Scanner;

public class Triangle extends Shape {
    protected double side1 = 1.0;
    protected double side2 = 1.0;
    protected double side3 = 1.0;

    public Triangle(double side1, double side2, double side3, String blue, boolean b) {
        super(blue,true);
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
    }

    public Triangle(double side1, double side2, double side3) {
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
    }

    protected double getSide1() {
        return side1;
    }

    protected void setSide1(double side1) {
        this.side1 = side1;
    }

    protected double getSide2() {
        return side2;
    }

    protected void setSide2(double side2) {
        this.side2 = side2;
    }

    protected double getSide3() {
        return side3;
    }

    protected void setSide3(double side3) {
        this.side3 = side3;
    }

    protected double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    protected double getPerimeter() {
        return (side1 + side2 + side3);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", perimeter=" + getPerimeter() +
                ", Area=" + getArea() +
                ", color=" + color +
                ", filled=" + filled +
                '}';
    }
}
class TriangleTest{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter side 1:");
        double side1=sc.nextDouble();
        System.out.println("enter side 1:");
        double side2=sc.nextDouble();
        System.out.println("enter side 1:");
        double side3=sc.nextDouble();
        Triangle triangle=new Triangle(side1,side2,side3,"blue",true);
        System.out.println(triangle.toString());
    }
}
