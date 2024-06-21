package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/is-subsequence/description/">Problem 392</a>
 */
public class Problem392 {

    public static void main(String[] args) {

        System.out.println(isSubsequence("aec", "abcde"));
    }

    public static boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty() || s.length() > t.length()) {
            return false;
        }
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char sChar = s.charAt(j);
            while (i < t.length() && sChar != t.charAt(i)) {
                i++;
            }
            if (i == t.length()) {
                return false;
            }
            i++;
        }

        return true;
    }
}
