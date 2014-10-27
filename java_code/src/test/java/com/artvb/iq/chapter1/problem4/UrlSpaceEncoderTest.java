package com.artvb.iq.chapter1.problem4;

import org.junit.Test;

public class UrlSpaceEncoderTest {
    @Test(expected = NullPointerException.class)
    public void testNullStringThrowsException() {
        UrlSpaceEncoder.urlSpaceEncoder(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTrueLengthThrowsException() {
        UrlSpaceEncoder.urlSpaceEncoder("", -1);
    }
}