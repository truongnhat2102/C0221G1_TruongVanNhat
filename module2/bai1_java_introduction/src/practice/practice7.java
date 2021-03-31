package practice;

import java.util.Scanner;

public class practice7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter weight: ");
        float weight = scanner.nextFloat();
        System.out.println("enter height: ");
        float height = scanner.nextFloat();
        float bmi = weight / (height*height);
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("Normal");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
