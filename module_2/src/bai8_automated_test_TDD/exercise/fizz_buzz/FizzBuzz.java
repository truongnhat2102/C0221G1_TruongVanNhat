package bai8_automated_test_TDD.exercise.fizz_buzz;

public class FizzBuzz {
    protected static int num;

    protected static int getNum() {
        return num;
    }

    protected static void setNum(int num) {
        FizzBuzz.num = num;
    }

    protected int check() {
        if (num % 3 == 0) {
            return 1;
        } else if (num % 5 == 0) {
            return 2;
        }
        return 0;
    }

    protected String output() {
        String str = "";
        if (check() == 1) {
            str += "Fizz";
        }
        if (check() == 2) {
            str += "Buzz";
        }
        return str;
    }
}
