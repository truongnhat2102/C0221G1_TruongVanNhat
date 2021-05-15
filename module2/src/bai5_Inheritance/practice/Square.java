package bai5_Inheritance.practice;

public class Square extends Rectangle {
    double side=1.0;

    public Square(double v, String yellow, boolean b) {
        super(v,v,yellow,b);
    }

    public Square() {

    }

    public Square(double v) {
        super(v,v);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        System.out.println(square);
    }
}