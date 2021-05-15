package bai1_java_introduction.exercise;

import java.util.Scanner;

public class ReadNumber {

    String readUnit(int num) {
        String read = "";
        switch (num) {
            case 1:
                read += "one";
                break;
            case 2:
                read += "two";
                break;
            case 3:
                read += "three";
                break;
            case 4:
                read += "four";
                break;
            case 5:
                read += "five";
                break;
            case 6:
                read += "six";
                break;
            case 7:
                read += "seven";
                break;
            case 8:
                read += "eight";
                break;
            case 9:
                read += "nine";
                break;
        }
        return read;
    }

    String readTen(int num) {
        String read = "";
        if (num >= 10 && num < 20) {
            switch (num) {
                case 10:
                    read += "ten";
                    break;
                case 11:
                    read += "eleven";
                    break;
                case 12:
                    read += "twelve";
                    break;
                case 13:
                    read += "thirteen";
                    break;
                case 14:
                    read += "fourteen";
                    break;
                case 15:
                    read += "fifteen";
                    break;
                case 16:
                    read += "sixteen";
                    break;
                case 17:
                    read += "seventeen";
                    break;
                case 18:
                    read += "eighteen";
                    break;
                case 19:
                    read += "nineteen";
                    break;

            }
        } else {
            switch (num / 10) {
                case 2:
                    read += "twenty" + readUnit(num % 10);
                    break;
                case 3:
                    read += "thirty" + readUnit(num % 10);
                    break;
                case 4:
                    read += "forty" + readUnit(num % 10);
                    break;
                case 5:
                    read += "fifty" + readUnit(num % 10);
                    break;
                case 6:
                    read += "sixty" + readUnit(num % 10);
                    break;
                case 7:
                    read += "seventy" + readUnit(num % 10);
                    break;
                case 8:
                    read += "eighty" + readUnit(num % 10);
                    break;
                case 9:
                    read += "ninety" + readUnit(num % 10);
                    break;
            }
        }
        return read;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ReadNumber readNumber = new ReadNumber();
        if (num < 10) {
            System.out.println(readNumber.readUnit(num));
        } else if (num >= 10 && num < 100) {
            System.out.println(readNumber.readTen(num));
        } else if (num >= 100 && num < 1000) {
            System.out.println(readNumber.readUnit(num / 100) + " hundred " + readNumber.readTen(num % 100));
        }
    }
}
