package model.common.validate;

import java.util.regex.Pattern;

public class Validate {
    final String CUSTOMER_REGEX = "KH-[0-9]{4}";
    final String SERVICE_REGEX = "DV-[0-9]{4}";
    final String PHONE_REGEX = "([090]||[091]||[(84)+90]||[(84)+91])([0-9]{7})";
    final String IDCARD_REGEX = "[0-9]{4}";
    final String EMAIL_REGEX = "[A-Za-z0-9]{1,}@[a-z]{1,}(.[a-z]){1,}";
    final String NUMBER_REGEX = "[0-9]{1,}";

    public boolean customerRegex(String text){
        Pattern pattern = Pattern.compile(CUSTOMER_REGEX);
        return pattern.matches(CUSTOMER_REGEX,text);
    }
    public boolean serviceRegex(String text){
        Pattern pattern = Pattern.compile(SERVICE_REGEX);
        return pattern.matches(SERVICE_REGEX,text);
    }
    public boolean phoneRegex(String text){
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        return pattern.matches(PHONE_REGEX,text);
    }
    public boolean idCardRegex(String text){
        Pattern pattern = Pattern.compile(IDCARD_REGEX);
        return pattern.matches(IDCARD_REGEX,text);
    }
    public boolean emailRegex(String text){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        return pattern.matches(EMAIL_REGEX,text);
    }
    public boolean numberRegex(String text){
        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        return pattern.matches(NUMBER_REGEX,text);
    }
}
