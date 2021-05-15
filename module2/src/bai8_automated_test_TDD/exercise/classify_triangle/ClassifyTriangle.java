package bai8_automated_test_TDD.exercise.classify_triangle;

import bai5_Inheritance.exercise.Triangle;

import java.util.Scanner;

public class ClassifyTriangle extends Triangle {

    public ClassifyTriangle(double side1, double side2, double side3) {
        super(side1, side2, side3);
    }

    protected int check() {
        if (side1 > 0 && side2 > 0 && side3 > 0) {
            if (side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2) {
                if (side2 == Math.sqrt(side1 * side1 + side3 * side3)) {
                    return 2;
                } else if (side3 == Math.sqrt(side1 * side1 + side2 * side2)) {
                    return 2;
                } else if (side1 == Math.sqrt(side2 * side2 + side3 * side3)) {
                    return 2;
                } else if (side1 == side2 && side2 == side3) {
                    return 4;
                } else if (side1 == side2 || side2 == side3 || side1 == side3) {
                    return 3;
                }
                return 1;
            }
            return 0;
        }
        return 0;
    }

    public String toString() {
        switch (check()) {
            case 1:
                return "normal triangle";
            case 2:
                return "right triangle";
            case 3:
                return "isosceles triangle";
            case 4:
                return "equilateral triangle";
        }
        return "not a triangle";
    }
}

class TestClassifyTriangle {
    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter side1: ");
            double side1 = sc.nextDouble();
            System.out.println("enter side2: ");
            double side2 = sc.nextDouble();
            System.out.println("enter side3: ");
            double side3 = sc.nextDouble();
            ClassifyTriangle classifyTriangle = new ClassifyTriangle(side1, side2, side3);
            System.out.println(classifyTriangle.toString());
        } while (true);
    }
}

