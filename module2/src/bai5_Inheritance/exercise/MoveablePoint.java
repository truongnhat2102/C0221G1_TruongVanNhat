package bai5_Inheritance.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MoveablePoint extends Point{
    protected float xSpeed=0.0f;
    protected float ySpeed=0.0f;

    protected MoveablePoint(float x, float y) {
        super(x, y);
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x,y);
        setxSpeed(xSpeed);
        setySpeed(ySpeed);
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    protected void setSpeed(float[] arr){
        arr[0] = x;
        arr[1] = y;
        arr[2]=xSpeed;
        arr[3]=ySpeed;
    }
    protected String getSpeed(){
        float[] arr=new float[4];
        setSpeed(arr);
        String str="("+x+","+y+")"+",=("+xSpeed+","+ySpeed+")";
        return str;
    }
    protected String move(){
        x+=xSpeed;
        y+=ySpeed;
        return Arrays.toString(getXY());
    }
}
class MoveablePointTest{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter x: ");
        float x = sc.nextFloat();
        System.out.println("enter y: ");
        float y = sc.nextFloat();
        System.out.println("enter xspeed: ");
        float xSpeed=sc.nextFloat();
        System.out.println("enter yspeed: ");
        float ySpeed=sc.nextFloat();
        MoveablePoint moveablePoint=new MoveablePoint(x,y,xSpeed,ySpeed);
        System.out.println(moveablePoint.getSpeed());
        System.out.println("how many movings do you want?");
        int n=sc.nextInt();
        for (int i = 0; i < n-1; i++) {
            moveablePoint.move();
        }
        System.out.println(moveablePoint.move());
    }
}
