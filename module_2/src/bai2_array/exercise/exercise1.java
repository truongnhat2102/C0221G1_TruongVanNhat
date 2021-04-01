package bai2_array.exercise;

import java.lang.reflect.Array;
import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("enter num to delete");
        int del = scanner1.nextInt();
        for (int i = 0; i < n - 1; i++) {
            System.out.println(delete1Element2(arr, del)[i]);
        }
    }

    //    public static int[] delete1Element(int arr[], int index) {
//        int arrNew[] = new int[arr.length-1];
//        for (int i = 0; i < index; i++) {
//            arrNew[i] = arr[i];
//        }
//        for (int i = index-1; i < arr.length - 1; i++) {
//            arrNew[i] = arr[i+1];
//        }
//        return arrNew;
//    }
    public static int[] delete1Element2(int arr[], int eleToDel) {
        int arrNew[] = new int[arr.length - 1];
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == eleToDel) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < index; i++) {
            arrNew[i] = arr[i];
        }
        for (int i = index; i < arr.length - 1; i++) {
            arrNew[i] = arr[i + 1];
        }
        return arrNew;
    }
}
