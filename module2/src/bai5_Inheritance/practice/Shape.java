package bai5_Inheritance.practice;

import bai6_abstract_class_andInterface.exercise.exercise1.Resizeable;
import bai6_abstract_class_andInterface.exercise.exercise2.Colorable;

public class Shape implements Resizeable {
    protected String color;
    protected boolean filled;

    protected Shape(String color, boolean filled) {
        this.color=color;
        this.filled=filled;
    }

    public Shape() {

    }

    protected String getColor() {
        return color;
    }

    protected void setColor(String color) {
        this.color = color;
    }

    protected boolean isFilled() {
        return filled;
    }

    protected void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Shape with " +
                "color of " + color +
                ", filled /not filled" + filled;
    }

    public void reSize(double percent) {
    }


}
class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);
    }
}