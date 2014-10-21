package com.artvb.iq.problem1_1;

import java.util.Arrays;

/**
 * Created by artburkart on 10/19/14.
 */
public class UniqChars {
    /**
     * Sorts String to check for redundancy of chars in given String.
     *
     * O(nlogn) Sort array with dual-pivot quicksort.
     *
     * @param str String to check for redundancy of chars
     * @return true if all chars unique, otherwise false
     */
    private static boolean Method1(String str) {
        // Input cannot be null, has no unique chars if length is 0,
        // and must be unique if length 1
        UniqChars.assertNotNull(str);
        if (str.length() == 0) { return false; }
        if (str.length() == 1) { return true; }

        // Derive char array from input String and sort
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i+1]) { return false; }
        }
        return true;
    }

    /**
     * Uses boolean mask to check for redundancy of chars in given String.
     *
     * O(n) - Iterate through chars twice to find duplicate.
     *
     * @param str String to check for redundancy of chars
     * @return true if all chars unique, otherwise false
     */
    private static boolean Method2(String str) {
        // Input cannot be null, has no unique chars if length is 0,
        // and must be unique if length 1
        UniqChars.assertNotNull(str);
        if (str.length() == 0) { return false; }
        if (str.length() == 1) { return true; }

        // Find maximum char ordinal value for mask initialization
        int max = Integer.MIN_VALUE;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            max = (c > max) ? c : max;
        }

        // Initialize mask with length of (max + 1)
        boolean[] mask = new boolean[max + 1];
        for (char c : chars) {
            if (mask[c]) { return false; }
            mask[c] = true;
        }
        return true;
    }

    /**
     * Uses bit twiddling to check for redundancy in given String
     *
     * Note: chars in String must fall within an ordinal range of 32
     *
     * @param str String to check for redundancy of chars
     * @return true if all chars unique, otherwise false
     */
    private static boolean Method3(String str) {
        // Input cannot be null, has no unique chars if length is 0,
        // and must be unique if length 1
        UniqChars.assertNotNull(str);
        if (str.length() == 0) { return false; }
        if (str.length() == 1) { return true; }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find and min and max ordinal char values in String
        char[] chars = str.toCharArray();
        for (char c: chars) {
            min = (c < min) ? c : min;
            max = (c > max) ? c : max;
        }

        // If range of ordinal char values is greater than 32, then this
        // method will not work on the string
        if (max - min > Integer.SIZE - 1) {
            String err = String.format("Range between ordinal char values " +
                "is larger than maximum (%d).", Integer.SIZE - 1);
            throw new IllegalArgumentException(err);
        }

        int mask = 0;
        int marker, offset;
        for (char c: chars) {
            offset = c - min;
            marker = 1 << offset;
            if ((marker & mask) > 0) { return false; }
            mask |= marker;
        }
        return true;
    }

    /**
     * Asserts that an object not be null.
     *
     * @param o Object to check whether null
     */
    private static void assertNotNull(Object o) {
        if (o == null) {
            throw new NullPointerException("Given input must not be null");
        }
    }


    /**
     * Selects algorithm for determining redundancy in given String.
     *
     * @param str String to check if contains only unique chars
     * @param method determines which algorithm to use
     */
    public static boolean uniqChars(String str, int method) {
        UniqChars.assertNotNull(method);
        // Use different algorithms based on method option provided
        switch (method) {
            case UniqChars.SORTED:
                return UniqChars.Method1(str);
            case UniqChars.BOOL:
                return UniqChars.Method2(str);
            case UniqChars.BIT:
                return UniqChars.Method3(str);
            default:
                throw new IllegalArgumentException("Given `method` is not valid.");
        }
    }

    // Available methods for checking uniqueness of a String
    public static final int SORTED = 1;
    public static final int BOOL = 2;
    public static final int BIT = 3;
}
