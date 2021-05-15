package bai2_array.exercise;

import java.util.Scanner;

public class exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        Scanner scanner1=new Scanner(System.in);
//        int m=scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = j + i;
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    sum1 += arr[i][j];
                }
                if (j == n - i - 1) {
                    sum2 += arr[i][j];
                }
            }
        }
        System.out.println(sum1 + "\n" + sum2);
    }
}
