package com.artvb.iq.chapter1.problem4;

/**
 * Created by artburkart on 10/27/14.
 */
public class UrlSpaceEncoder {
    /**
     * URL encodes spaces as "%20" and trims off the extra spaces on the end
     *
     * @param str given String to URL encode spaces in
     * @param trueLength given length of String to URL encode
     * @return returns String with spaces URL encoded
     */
    public static String urlSpaceEncoder(String str, int trueLength) {
        if (str == null) { throw new NullPointerException(); }
        if (trueLength < 0) { throw new IllegalArgumentException(); }

        if (str.length() == 0) {
            return str;
        }

        char[] chars = str.toCharArray();
        int placeholder = chars.length - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (placeholder < 0) {
                break;
            } else if (chars[i] == ' ') {
                chars[placeholder] = '0';
                chars[placeholder - 1] = '2';
                chars[placeholder - 2] = '%';
                placeholder -= 3;
            } else {
                chars[placeholder] = chars[i];
                placeholder -= 1;
            }
        }
        return new String(chars);
    }
}
