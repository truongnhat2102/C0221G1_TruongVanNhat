package bai14_sorting_algorithms.exercise.insert_sorting_by_list;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSortByList {
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> arr = new ArrayList<>();
    static int temp=0;
    static int templ=0;
    public static void insertionSort(ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i+1; j++) {
                temp=list.get(i);
                if (arr.size()==0){
                    arr.add(0,temp);
                    break;
                }
                templ=arr.get(i-j-1);
                if (templ < temp) {
                    arr.add((i-j),temp);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list.add(1);
        list.add(9);
        list.add(4);
        list.add(6);
        list.add(5);
        list.add(-4);
        System.out.println("list before sort");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        insertionSort(list);
        System.out.println("list after sort");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
