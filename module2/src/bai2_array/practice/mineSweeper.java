package bai2_array.practice;

import java.util.Scanner;

public class mineSweeper {
    public static void main(String[] args) {
        String arr[][]= new String[10][10];
        mineMap(arr);
        boolean a=true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter x");
            int x = scanner.nextInt();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("enter y");
            int y = scanner1.nextInt();
            a=checkLose(x,y);
            chooseIndex(arr,x,y);
            mineMap(arr);
        }while (a!=true);
        System.out.println("you chose bomb");

    }
    static void mineMap(String[][] arr){
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                arr[i][j]=" * ";
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        return;
    }
     static void chooseIndex(String[][] arr,int x, int y){
         for (int i=0; i<10; i++){
             for (int j=0; j<10; j++){
                 if (i==x && j==y){
                     if (!checkLose(x,y)){
                         arr[i][j]=" o ";
                     }
                     else {
                         arr[i][j]=" x ";
                     }
                 }
                 else {
                     arr[i][j]=" * " ;
                 }
             }
         }
        return;
    }
    static boolean checkLose(int x, int y){
        boolean check=false;
        if (x==2 && y==2){
            check=true;
        }
        return check;
    }
}
