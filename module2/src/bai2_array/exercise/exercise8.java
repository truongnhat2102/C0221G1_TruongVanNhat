package bai2_array.exercise;

import java.util.Scanner;

public class exercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter string");
        String str = scanner.nextLine();
        System.out.println(str);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("enter char to find");
        char enter = scanner1.next().charAt(0);
        System.out.println(checkInStr(str, enter));
    }

    public static int checkInStr(String str, char enter) {
        String index = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == enter) {
                count++;
            }
        }
        return count;
    }
}
