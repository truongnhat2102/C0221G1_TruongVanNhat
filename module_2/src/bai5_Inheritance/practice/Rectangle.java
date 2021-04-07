package bai5_Inheritance.practice;

public class Rectangle extends Shape {
    double width = 1.0;
    double height = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    Rectangle(double width, double heigth, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = heigth;

    }


    protected double getWidth() {
        return width;
    }

    protected void setWidth(double width) {
        this.width = width;
    }

    protected double getHeight() {
        return height;
    }

    protected void setHeight(double height) {
        this.height = height;
    }

    double getArea() {
        return width * height;
    }

    double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        String s = "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
        return s;
    }

}

class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);
    }
}
