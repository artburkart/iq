package com.artvb.iq.chapter1.problem2;

import org.junit.Test;

public class ReverseStringTest {

    @Test(expected = NullPointerException.class)
    public void testNullStringThrowsException() {
        ReverseString.reverseString(null);
    }
}