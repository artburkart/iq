package com.artvb.iq.chapter1.problem3;

import java.util.HashMap;

/**
 * Created by artburkart on 10/25/14.
 */
public class PermutationsEqual {
    /**
     * Checks if strA is a permutation of strB
     *
     * @param strA the first String
     * @param strB the second String
     * @return true iff strA is a permutation of strB, otherwise false
     */
    public static Boolean permutationsEqual(String strA, String strB) {
        if (strA == null || strB == null) {
            throw new NullPointerException();
        }
        if (strA.length() != strB.length()) {
            return false;
        }

        String curr;
        HashMap<String, Integer> tracker = new HashMap<String, Integer>();

        // Add 1 for every character in strA
        for (char c : strA.toCharArray()) {
            curr = String.valueOf(c);
            if (tracker.get(curr) == null) {
                tracker.put(curr, 1);
            } else {
                tracker.put(curr, tracker.get(curr) + 1);
            }
        }

        // Subtract 1 for every character in strB
        for (char c : strB.toCharArray()) {
            curr = String.valueOf(c);
            if (tracker.get(curr) == null) {
                return false;
            } else {
                tracker.put(curr, tracker.get(curr) - 1);
            }
            if (tracker.get(curr) < 0) {
                return false;
            }
        }

        for (int val : tracker.values()) {
           if (val > 0) {
               return false;
           }
        }
        return true;

    }
}
