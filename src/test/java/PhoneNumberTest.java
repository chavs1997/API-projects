import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PhoneNumberTest {

    @Test
    public void testPhoneNumberMatching(){
        Pattern pattern = Pattern.compile("(\\d{3}[\\s\\-]?)?\\d{3}[\\s\\-]?\\d{4}");
        String text = "This might be my phone number: 888-852-7564. I wonder whose it is.";
        Matcher matcher = pattern.matcher(text);
        assertTrue(matcher.find());

    }
}
