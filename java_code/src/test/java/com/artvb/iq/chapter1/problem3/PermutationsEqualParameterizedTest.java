package com.artvb.iq.chapter1.problem3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class PermutationsEqualParameterizedTest {

    private String strA;
    private String strB;
    private boolean expected;

    public PermutationsEqualParameterizedTest(String strA, String strB, boolean expected) {
        this.strA = strA;
        this.strB = strB;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: permutationsEqual({0}, {1}) => {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"aba", "baa", true},
            {"aaa", "aaa", true},
            {"", "", true},
            {"a", "a", true},
            {"aab", "baa", true},
            {"aabc", "baac", true},
            {"ab", "cb", false},
            {"aaba", "aab", false},
            {"bbb", "aaa", false}
        });
    }

    @Test
    public void testUniqCharsFunction() {
        assertEquals(PermutationsEqual.permutationsEqual(strA, strB), expected);
    }
}