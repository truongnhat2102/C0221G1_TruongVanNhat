package exercise;

import java.util.Scanner;

public class exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num < 10) {
            System.out.println(from1To10(num));
        } else if (num >= 10 && num < 20) {
            System.out.println(from11To19(num));
        } else if (num > 19 && num < 100) {
            int surPlus = num % 10;
            int unit10 = num / 10;
            System.out.println(from10To90(unit10 * 10) + " " + from1To10(surPlus));
        } else if (num >= 100 && num < 1000) {
            int surPlus1 = num % 100;
            int unit100 = num / 100;
            int surPlus2 = surPlus1 % 10;
            int unit10 = surPlus1 / 10;
            if (surPlus1 >= 10 && surPlus1 < 20) {
                System.out.println(from1To10(unit100) + " hundred " + from11To19(surPlus1));
            } else if (surPlus1 <= 10) {
                System.out.println(from1To10(unit100) + " hundred " + from1To10(surPlus1));
            } else if (surPlus1 > 20) {
                System.out.println(from1To10(unit100) + " hundred " + from10To90(unit10 * 10) + " " + from1To10(surPlus2));
            }
        }
    }

    public static String from1To10(int number) {
        String call = "";
        switch (number) {
            case 1:
                call = "one";
                break;
            case 2:
                call = "two";
                break;
            case 3:
                call = "three";
                break;
            case 4:
                call = "four";
                break;
            case 5:
                call = "five";
                break;
            case 6:
                call = "six";
                break;
            case 7:
                call = "seven";
                break;
            case 8:
                call = "eight";
                break;
            case 9:
                call = "nine";
                break;
        }
        return call;
    }

    public static String from11To19(int number) {
        String call = "";
        int surplus = number % 10;
        switch (number) {
            case 10:
                call = "ten";
                break;
            case 11:
                call = "eleven";
                break;
            case 12:
                call = "twelve";
                break;
            case 13:
                call = "thirteen";
                break;
            case 14:
                call = "fourteen";
                break;
            case 15:
                call = "fifteen";
                break;
            case 16:
            case 17:
            case 18:
            case 19:
                call = from1To10(surplus) + "teen";
                break;
        }
        return call;
    }

    public static String from10To90(int number) {
        String call = "";
        switch (number) {
            case 20:
                call = "twenty";
                break;
            case 30:
                call = "thirty";
                break;
            case 40:
                call = "forty";
                break;
            case 50:
                call = "fifty";
                break;
            case 60:
                call = "sixty";
                break;
            case 70:
                call = "seventy";
                break;
            case 80:
                call = "eighty";
                break;
            case 90:
                call = "ninety";
                break;
        }
        return call;
    }
}
