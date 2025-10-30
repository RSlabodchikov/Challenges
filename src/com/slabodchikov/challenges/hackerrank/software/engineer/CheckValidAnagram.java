package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/check-valid-anagram/problem">Problem</a>
 */
public class CheckValidAnagram {

    /*
     * Complete the 'isAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     */

    public static int isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return 0;
        }
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);

        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);

        return Arrays.compare(sChars, tChars) == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "acb"));
        System.out.println(isAnagram("aa", "aaa"));
        System.out.println(isAnagram("test", "ttes"));
    }

}
