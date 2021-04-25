package bai19_string_regex.exercise.validate_classroom;

import bai19_string_regex.practice.validate_account.ValidateAccount;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String CLASS_REGEX="^[CAP]+[0-9]{1,4}+([GHIKLM]+)$";
    public ValidateClass(){
        pattern=Pattern.compile(CLASS_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        while (true){
            Scanner sc= new Scanner(System.in);
            ValidateClass validateClass= new ValidateClass();
            System.out.println("enter name of class");
            System.out.println(validateClass.validate(sc.nextLine()));
        }
    }
}

