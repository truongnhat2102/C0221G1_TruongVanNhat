package bai3_OOP.exercise;

import java.util.Scanner;

public class Rectangle {
    double width,height;
    public Rectangle(double width, double height){
        this.width=width;
        this.height=height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public double getArea(){
        return this.height*this.width;
    }
    public double getPerimeter(){
        return (this.height+this.width)*2;
    }
    public String display(){
        return "Rectangle{ width= "+this.width+", height= "+this.height+" }";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width:");
        double width = scanner.nextDouble();
        System.out.print("Enter the height:");
        double height = scanner.nextDouble();
        Rectangle rectangle1 = new Rectangle(width, height);
        System.out.println(rectangle1.getArea()+" "+rectangle1.getPerimeter());
    }
}
