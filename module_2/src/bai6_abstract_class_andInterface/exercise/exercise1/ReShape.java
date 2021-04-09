package bai6_abstract_class_andInterface.exercise.exercise1;

import bai5_Inheritance.practice.Circle;
import bai5_Inheritance.practice.Rectangle;
import bai5_Inheritance.practice.Square;

class ReCircle extends Circle implements Resizeable {

    public ReCircle(double v) {
        super(v);
    }

    public ReCircle(double v, String indigo, boolean b) {
        super(v, indigo, b);
    }

    public ReCircle() {

    }

    @Override
    public void reSize(double percent) {
        double b = super.getRadius() * (1 + percent / 100);
        setRadius(b);
    }
}

class ReRectangle extends Rectangle implements Resizeable {

    public ReRectangle(double width, double height) {
        super(width, height);
    }

    public ReRectangle(double width, double height, String indigo, boolean b) {
        super(width, height, indigo, b);
    }

    public ReRectangle() {

    }

    @Override
    public void reSize(double percent) {
        setWidth(super.getWidth() * (1 + percent / 100));
        setHeight(super.getHeight() * (1 + percent / 100));
    }
}

class ReSquare extends Square implements Resizeable {

    public ReSquare(double v) {
        super(v);
    }

    public ReSquare(double v, String indigo, boolean b) {
        super(v, indigo, b);
    }

    public ReSquare() {

    }

    @Override
    public void reSize(double percent) {
        setSide(super.getSide() * (1 + percent / 100));
    }
}
