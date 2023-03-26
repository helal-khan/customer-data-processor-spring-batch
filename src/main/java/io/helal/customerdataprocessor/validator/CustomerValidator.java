package io.helal.customerdataprocessor.validator;

import com.google.i18n.phonenumbers.PhoneNumberUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidator {

    public static final String EMAIL_VALIDATION_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    public static final String REGION = "US";


    public static boolean isValidMail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_VALIDATION_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phone) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        return phoneNumberUtil.isPossibleNumber(phone, REGION);
    }

}
