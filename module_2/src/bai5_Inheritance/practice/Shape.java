package bai5_Inheritance.practice;

public class Shape {
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
}
class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);
    }
}