package com.artvb.iq.chapter1.problem5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class StringCompressorParameterizedTest {
    private String str;
    private String expected;

    public StringCompressorParameterizedTest(String str, String expected) {
        this.str = str;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: compress({0}) => {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"", ""},
            {"ab", "ab"},
            {"abc", "abc"},
            {"aaa", "a3"},
            {"hello", "hello"},
            {"hellllllo", "h1e1l6o1"},
            {"hheelloo", "hheelloo"},
            {"hheeelloo", "h2e3l2o2"},
        });
    }

    @Test
    public void testCompress() {
        assertEquals(expected, StringCompressor.compress(str));
    }
}