package bai13_searching_algorithms.exercise.find_by_recursion;

import java.util.Scanner;

public class BinarySearch {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    static int high=list.length-1;
    static int low=0;
    static void binarySearch(int[] list, int key, int high, int low){
        int mid = (low + high) / 2;
        if (high>=low){
            if (key < list[mid])
                binarySearch(list, key, (mid-1), low );
            else if (key == list[mid]){
                System.out.println(mid);
                return;
            }
            else
                binarySearch(list, key, high, (mid+1) );
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        binarySearch(list,sc.nextInt(),high,low);
    }
}
