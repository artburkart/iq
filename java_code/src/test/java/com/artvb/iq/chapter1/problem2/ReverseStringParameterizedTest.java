package com.artvb.iq.chapter1.problem2;

import java.util.Arrays;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class ReverseStringParameterizedTest {

    private String str;
    private String expected;

    public ReverseStringParameterizedTest(String str, String expected) {
        this.str = str;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: reverseString({0}) => {1}")
    public static Iterable<Object[]> data() {
        Random rand = new Random();

        // The printable characters from the `string` module in python
        String printable = "0123456789abcdefghijklmnopqrstuvwx" +
                "yzABCDEFGHIJKLMNOPQRSTUVWXYZ!\"#$%&\\'()*+,-." +
                "/:;<=>?@[\\\\]^_`{|}~ \\t\\n\\r\\x0b\\x0c";

        // Generate 100 random Strings
        String[] randStrings = new String[100];

        // TODO(arthurb): Maybe I should use a generator some day
        for (int i = 0; i < randStrings.length; i++) {
            char[] randChars = new char[rand.nextInt(100)];
            for (int j = 0; j < randChars.length; j++) {
                randChars[j] = printable.charAt(rand.nextInt(printable.length()));
            }
            randStrings[i] = new String(randChars);
        }

        // Build the parameters for {input} and {expected}
        Object[][] params = new Object[randStrings.length][2];
        for (int i = 0; i < params.length; i++) {
            String randString = randStrings[i];
            params[i] = new Object[] {randStrings[i], new StringBuilder(randString).reverse().toString() };
        }
        return Arrays.asList(params);
    }

    @Test
    public void testReverseString() {
        assertEquals(expected, ReverseString.reverseString(str));
    }
}