package bai15_exception.exercise.illegal_triangle_exception;

import java.util.Scanner;

public class IllegalTriangleException extends Throwable {
    static int side1;
    static int side2;
    static int side3;
    static void check() throws IllegalTriangleException {
        if (side1<0 || side2<0 || side3<0 || (side1+side2)<=side3 || (side2+side3)<=side1 || (side1+side3)<=side2){
            throw new IllegalTriangleException();
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (true){
            try{
                System.out.println("enter side1");
                side1= Integer.parseInt(sc.nextLine());
                System.out.println("enter side2");
                side2= Integer.parseInt(sc.nextLine());
                System.out.println("enter side3");
                side3= Integer.parseInt(sc.nextLine());
                check();
                break;
            } catch (IllegalTriangleException e) {
                System.out.println("enter again");
            } catch (Exception e){
                System.out.println("enter again");
            }
        }
    }
}