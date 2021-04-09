package bai6_abstract_class_andInterface.exercise.exercise2;

import bai5_Inheritance.practice.Circle;
import bai5_Inheritance.practice.Shape;
import bai5_Inheritance.practice.Square;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[2];
        shapes[0]=new Square();
        shapes[1]=new Circle();
        for (Shape shape : shapes) {
            if(shape instanceof Colorable) {
                System.out.println(shape+ " Co COLORABLE");
                ((Colorable) shape).howToColor();


            }
            else System.out.println(shape+ "KHONG co COLORABLE");

        }
    }
}
