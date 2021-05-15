package bai2_array.exercise;

import java.util.Scanner;

public class exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = i;
            arr2[i] = i + 6;
        }
        System.out.println();
        for (int j = 0; j < arr1.length + arr2.length; j++) {
            System.out.print(concat(arr1, arr2)[j]+" ");
        }
    }

    public static int[] concat(int[] arr1, int[] arr2) {
        int arrNew[] = new int[arr1.length + arr2.length];
        for (int i = 0; i < arrNew.length; i++) {
            if (i < arr1.length) {
                arrNew[i] = arr1[i];
            } else {
                arrNew[i] = arr2[i - arr1.length];
            }
        }
        return arrNew;
    }

}
