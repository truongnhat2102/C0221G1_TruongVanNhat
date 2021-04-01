package bai2_array.exercise;

import java.util.Scanner;

public class exercise4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Scanner scanner1=new Scanner(System.in);
        int m=scanner1.nextInt();
        int[][] arr=new int[n][m];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                Scanner scanner3=new Scanner(System.in);
                int num=scanner3.nextInt();
                arr[i][j]=num;
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println(Max(arr,n,m));
    }
    public static int Max(int[][] arr,int n, int m){
        int max=arr[0][0];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                if (max<arr[i][j]){
                    max=arr[i][j];
                }
            }
        }
        return max;
    }
}
