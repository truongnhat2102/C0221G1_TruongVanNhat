package bai5_Inheritance.exercise;

import java.util.Scanner;

public class Circle {
    protected double radius = 1;
    protected String color = "black";

    public Circle(double v, String yellow) {
        this.radius = v;
        this.color = yellow;
    }

    protected double getRadius() {
        return radius;
    }

    protected void setRadius(double radius) {
        this.radius = radius;
    }

    protected String getColor() {
        return color;
    }

    protected void setColor(String color) {
        this.color = color;
    }

    double getArea() {
        return radius * radius * Math.PI;
    }

    double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() + '\'' +
                '}';
    }
}

class CircleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter radius: ");
        double radius = sc.nextDouble();
        Circle circle = new Circle(radius, "yellow");
        System.out.println(circle.toString());
    }
}
