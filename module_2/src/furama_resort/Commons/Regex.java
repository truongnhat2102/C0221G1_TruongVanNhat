package furama_resort.Commons;

import java.util.regex.Pattern;

public class Regex {
    public static final String IDVILLA_REGEX = "SVVL-[0-9]{4}";
    public static final String IDHOUSE_REGEX = "SVHO-[0-9]{4}";
    public static final String IDROOMREGEX = "SVRO-[0-9]{4}";
    public static final String AREA_REGEX = "[3-9][0-9]+";
    public static final String PRICE_REGEX = "[1-9][0-9]{4,}";
    public static final String PEOPLE_REGEX = "[0-1][0-9]";
    public static final String STANDARD_REGEX = "diamond|platinum|gold|silver";
    public static final String SERVICE_REGEX = "massage|karaoke|food|drink|car";
    public static final String FLOOR_REGEX = "[0-9]+";
    public static final String TYPEOFRENT_REGEX = "day|month|year";
    public static final String NAMEPERSON_REGEX = "[A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]+([ ][A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]+)+";
    public static final String GENDER_REGEX = "male|female|another";
    public static final String DATEOFBIRTH_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String IDCUSTOMER_REGEX = "[0-9]{3}[ ][0-9]{3}[ ][0-9]{3}";
    public static final String PHONE_REGEX = "09[0-9]{8}";
    public static final String EMAIL_REGEX = "([a-zA-Z]+[0-9]{0,})+@([a-z]+.)+[a-z]";

    public static boolean check(String regex,String toCheck){
        return Pattern.matches(regex,toCheck);
    }
}
