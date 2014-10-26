package com.artvb.iq.chapter1.problem3;

import org.junit.Test;

public class PermutationsEqualTest {
    @Test(expected = NullPointerException.class)
    public void testNullStringsThrowsException() {
        PermutationsEqual.permutationsEqual(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullStringRightThrowsException() {
        PermutationsEqual.permutationsEqual("", null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullStringsLeftThrowsException() {
        PermutationsEqual.permutationsEqual(null, "");
    }
}