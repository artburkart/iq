package com.artvb.iq.chapter1.problem4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class UrlSpaceEncoderParameterizedTest {

    private String str;
    private int trueLength;

    public UrlSpaceEncoderParameterizedTest(String str, int trueLength) {
        this.str = str;
        this.trueLength = trueLength;
    }

    @Parameterized.Parameters(name = "{index}: urlSpaceEncoder({0}, {1})")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"hello world  ", 11},
            {"", 0},
            {"   ", 1},
            {"a b c    ", 5},
            {"a b c do      ", 8},
            {" a b c do        ", 9}
        });
    }

    @Test
    public void testUrlSpaceEncoder() {
        String actual = UrlSpaceEncoder.urlSpaceEncoder(str, trueLength);
        String expected = str.substring(0, trueLength).replace(" ", "%20");
        assertEquals(expected, actual);
    }
}