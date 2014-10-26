package com.artvb.iq.chapter1.problem2;

/**
 * Created by artburkart on 10/25/14.
 */
public class ReverseString {
    /**
     * Reverses a given String
     * @param str the given String
     * @return the given String reversed
     */
    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            int newIndex = chars.length - 1 -i;
            chars[i] = chars[newIndex];
            chars[newIndex] = temp;
        }
        return new String(chars);
    }
}
