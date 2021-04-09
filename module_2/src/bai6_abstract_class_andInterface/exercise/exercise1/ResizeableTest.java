package bai6_abstract_class_andInterface.exercise.exercise1;

import bai5_Inheritance.practice.Shape;

public class ResizeableTest {
    public static void main(String[] args) {
        double percent = Math.round(Math.random() * 100);
        Shape[] shapes = new Shape[3];
        shapes[0] = new ReCircle(5);
        shapes[1] = new ReRectangle(5, 10);
        shapes[2] = new ReSquare(5);
        for (Shape shape : shapes) {
            shape.reSize(percent);
            System.out.println(shape);
        }
    }
}
