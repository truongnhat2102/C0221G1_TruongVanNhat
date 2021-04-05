package bai2_array.exercise;

import java.util.Scanner;

public class exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Scanner scanner1 = new Scanner(System.in);
        int m = scanner1.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = j + i;
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("enter col to sum");
        int col = scanner2.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == col - 1) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}
