package com.artvb.iq.problem1_1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class UniqCharsParameterizedTest {

    private String str;
    private int method;
    private boolean expected;

    public UniqCharsParameterizedTest(String str, int method, boolean expected) {
        this.str = str;
        this.method = method;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: uniqChars({0}, {1}) => {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", UniqChars.BIT, false},
                {"", UniqChars.BOOL, false},
                {"", UniqChars.SORTED, false},
                {"a", UniqChars.BIT, true},
                {"a", UniqChars.BOOL, true},
                {"a", UniqChars.SORTED, true},
                {"ab", UniqChars.BIT, true},
                {"ab", UniqChars.BOOL, true},
                {"ab", UniqChars.SORTED, true},
                {"aba", UniqChars.BIT, false},
                {"aba", UniqChars.BOOL, false},
                {"aba", UniqChars.SORTED, false},
                {"aaba", UniqChars.BIT, false},
                {"aaba", UniqChars.BOOL, false},
                {"aaba", UniqChars.SORTED, false},
                {"baa", UniqChars.BIT, false},
                {"baa", UniqChars.BOOL, false},
                {"baa", UniqChars.SORTED, false},
                {"abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.BIT, true},
                {"abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.BOOL, true},
                {"abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.SORTED, true},
                {"abcdefghijklmnopqrstuvwxyz{|}~_`abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.BIT, false},
                {"abcdefghijklmnopqrstuvwxyz{|}~_`abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.BOOL, false},
                {"abcdefghijklmnopqrstuvwxyz{|}~_`abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.SORTED, false},
                // The BIT method cannot be used with these tests because the char values are out of range
                {"!🛅", UniqChars.BOOL, true},
                {"!🛅", UniqChars.SORTED, true},
                {"!🛅🛅", UniqChars.BOOL, false},
                {"!🛅🛅", UniqChars.SORTED, false},
        });
    }

    @Test
    public void testUniqCharsFunction() {
        assertEquals(expected, UniqChars.uniqChars(str, method));
    }
}