package com.artvb.iq.chapter1.problem1;

import org.junit.Test;

public class UniqCharsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMethodThrowsException() {
        UniqChars.uniqChars("a", 100);
    }

    @Test(expected = NullPointerException.class)
    public void testNullMethodThrowsException() {
        UniqChars.uniqChars("a", (Integer) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringOutOfRangeThrowsExceptionForBitMethod() {
        UniqChars.uniqChars("1a", UniqChars.BIT);
    }
}