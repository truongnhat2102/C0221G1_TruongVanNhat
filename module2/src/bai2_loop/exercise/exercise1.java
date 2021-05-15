package bai2_loop.exercise;

import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        Scanner num1 = new Scanner(System.in);
        int height = num1.nextInt();
        Scanner num2 = new Scanner(System.in);
        int width = num2.nextInt();
        String draw = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                draw += "*";
            }
            draw += "\n";
        }
        draw += "\n";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < i; j++) {
                draw += "*";
            }
            draw += "\n";
        }
        draw += "\n";
        for (int i = 0; i < height; i++) {
            for (int j = height; j > i; j--) {
                draw += "*";
            }
            draw += "\n";
        }
        System.out.println(draw);
    }
}
