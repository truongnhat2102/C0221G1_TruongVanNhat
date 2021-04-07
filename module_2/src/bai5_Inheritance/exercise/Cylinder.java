package bai5_Inheritance.exercise;

import java.util.Scanner;

public class Cylinder extends Circle {
    protected double height = 1;

    public Cylinder(double v, String yellow, double height) {
        super(v, yellow);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    double getVolume() {
        return getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", radius=" + radius +
                ", color='" + color +
                ", volume=" + getVolume() + '\'' +
                '}';
    }
}

class CylinderTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter radius: ");
        double radius = sc.nextDouble();
        System.out.println("enter height: ");
        double height = sc.nextDouble();
        Cylinder cylinder = new Cylinder(radius, "yellow", height);
        System.out.println(cylinder.toString());
    }
}