package bai8_automated_test_TDD.exercise.next_day;

import java.util.Scanner;

public class NextDay extends LeafYear {
    int day;
    int month;

    NextDay(int day, int month, int year) {
        super.year = year;
        this.day = day;
        this.month = month;
    }

    protected int getDay() {
        return day;
    }

    protected void setDay(int day) {
        this.day = day;
    }

    protected int getMonth() {
        return month;
    }

    protected void setMonth(int month) {
        this.month = month;
    }


    public String toString() {
        if (outNextDay() == 1) {
            return "NextDay{" +
                    "nextDay= " + (day + 1) +
                    "month= " + month +
                    " year= " + year +
                    '}';
        } else if (outNextDay() == 2) {
            return "NextDay{" +
                    " nextDay= " + "1" +
                    " month= " + (month + 1) +
                    " year= " + year +
                    '}';
        } else if (outNextDay() == 4) {
            return "NextDay{" +
                    " nextDay= " + "1" +
                    " month= " + "1" +
                    " year= " + (year + 1) +
                    '}';
        }
        return "enter again";

    }


    protected int outNextDay() {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if (day == 31) {
                    return 2;
                } else if (day > 31) {
                    return 3;
                }
                return 1;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 30) {
                    return 2;
                } else if (day > 30) {
                    return 3;
                }
                return 1;
            case 2:
                if (checkLeafYear()) {
                    if (day == 29) {
                        return 1;
                    }
                    return 2;
                } else if (day > 29) {
                    return 3;
                }
                return 1;
            case 12:
                if (day == 31) {
                    return 4;
                } else if (day > 31) {
                    return 3;
                }
                return 1;
        }
        return 0;
    }
}

class TestNextDay {
    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter day:");
            int day = sc.nextInt();
            System.out.println("enter month:");
            int month = sc.nextInt();
            System.out.println("enter year");
            int year = sc.nextInt();
            NextDay nextDay = new NextDay(day, month, year);
            System.out.println(nextDay.toString());
        } while (true);
    }
}

