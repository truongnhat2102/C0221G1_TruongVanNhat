package bai2_array.exercise;

import java.util.Scanner;

public class exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Scanner scanner1 = new Scanner(System.in);
        int m = scanner1.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Scanner scanner3 = new Scanner(System.in);
                int num = scanner3.nextInt();
                arr[i][j] = num;
            }
        }
        System.out.println(Min(arr, n, m));
    }

    public static int Min(int[][] arr, int n, int m) {
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (min > arr[i][j]) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }
}
