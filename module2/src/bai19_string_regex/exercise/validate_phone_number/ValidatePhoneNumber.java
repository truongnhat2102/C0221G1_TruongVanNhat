package bai19_string_regex.exercise.validate_phone_number;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_REGEX= "^[0-9]{2,}[-][0][0-9]{9,}$";
    public ValidatePhoneNumber(){
        pattern=Pattern.compile(PHONE_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
       while (true){
           Scanner sc= new Scanner(System.in);
           ValidatePhoneNumber validatePhoneNumber = new ValidatePhoneNumber();
           System.out.println("enter phone number");
           System.out.println(validatePhoneNumber.validate(sc.nextLine()));
       }
    }
}
