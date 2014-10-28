package com.artvb.iq.chapter1.problem5;

/**
 * Created by artburkart on 10/27/14.
 */
public class StringCompressor {
    /**
     * Compresses String with simple algorithm of
     * representing repeated occurrences with numbers
     *
     * Note: If the String cannot be compressed, then
     * the original input String is returned instead
     *
     * Example:
     *
     * input: hheeelloo  output: h2e3l2o2
     * input: aaabbb     output: a3b3
     * input: hello      output: hello
     * input: aa         output aa
     * input: hheelloo   output: hheelloo
     *
     * @param str String to compress
     * @return compressed String
     */
    public static String compress(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        if (str.length() < 3) {
            return str;
        }

        char curr = str.charAt(0);
        String comp = "";
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == curr) {
                count++;
            } else {
                comp += curr;
                comp += Integer.toString(count);
                curr = c;
                count = 1;
            }
        }
        comp += curr;
        comp += Integer.toString(count);
        if (comp.length() < str.length()) {
            return comp;
        }
        return str;
    }
}
