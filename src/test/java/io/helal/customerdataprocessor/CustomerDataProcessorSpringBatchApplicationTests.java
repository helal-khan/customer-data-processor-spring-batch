package io.helal.customerdataprocessor;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CustomerDataProcessorSpringBatchApplicationTests {

    @Test
    public void testEmailUsingRegex() {
        String email = "test@domain.com";
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        assertTrue(matcher.matches());
    }

    @Test
    public void testUsPhoneUsingLibPhoneNumber() {
        String[] usPhones = {"555-555-5555", "(555)555-5555", "(555) 555-5555", "555 555 5555", "5555555555", "1 555 555 5555", "Hello 555"};
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

        assertTrue(phoneNumberUtil.isPossibleNumber(usPhones[0], "US"));
        assertTrue(phoneNumberUtil.isPossibleNumber(usPhones[1], "US"));
        assertTrue(phoneNumberUtil.isPossibleNumber(usPhones[2], "US"));
        assertTrue(phoneNumberUtil.isPossibleNumber(usPhones[3], "US"));
        assertTrue(phoneNumberUtil.isPossibleNumber(usPhones[4], "US"));
        assertTrue(phoneNumberUtil.isPossibleNumber(usPhones[5], "US"));
        assertFalse(phoneNumberUtil.isPossibleNumber(usPhones[6], "US"));
    }

}
