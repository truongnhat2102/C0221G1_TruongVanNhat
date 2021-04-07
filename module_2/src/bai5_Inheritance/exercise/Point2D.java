package bai5_Inheritance.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Point2D {
    protected float x = 0.0f;
    protected float y = 0.0f;

    protected Point2D(float x, float y) {
        this.x=x;
        this.y=y;
    }

    protected float getX() {
        return x;
    }

    protected void setX(float x) {
        this.x = x;
    }

    protected float getY() {
        return y;
    }

    protected void setY(float y) {
        this.y = y;
    }

    float[] getXY() {
        float[] arr = new float[2];
        arr[0] = x;
        arr[1] = y;
        return arr;
    }

    @Override
    public String toString() {
        return Arrays.toString(getXY());
    }
}
class Point2DTest{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter x: ");
        float x=sc.nextFloat();
        System.out.println("enter y: ");
        float y=sc.nextFloat();
        Point2D point2D=new Point2D(x,y);

    }
}
