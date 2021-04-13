package bai11_stack_queue.exercise.convert_decimal_binary;

import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter number");
        int num=sc.nextInt();
        Stack<Number> binary= new Stack<>();
        String str="";
        while (num>0) {
            binary.add(0,num%2);
            num=num/2;
        }
        binary.add(0,0);
        for (int i = 0; i < binary.size(); i++) {
            System.out.print(binary.get(i));
        }
    }
}
