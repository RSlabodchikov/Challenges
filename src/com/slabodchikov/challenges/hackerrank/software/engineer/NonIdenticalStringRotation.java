package com.slabodchikov.challenges.hackerrank.software.engineer;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/check-non-identical-string-rotation/problem">Problem</a>
 */
public class NonIdenticalStringRotation {

    /*
     * Complete the 'isNonTrivialRotation' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */
    public static boolean isNonTrivialRotation(String s1, String s2) {
        if (s1.length() != s2.length() || s1.equals(s2)) {
            return false;
        }
        int n = s1.length();

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        char firstCharS1 = s1Chars[0];
        for (int j = 1; j < n; j++) {
            if (s2Chars[j] == firstCharS1 && isRotationFromIndex(n, s1Chars, s2Chars, j)) {
                return true;
            }
        }

        return false;

    }

    public static boolean isRotationFromIndex(int n, char[] chars1, char[] chars2, int shift) {
        for (int i = 0; i < n; i++) {
            int j = ((i + shift) >= n) ? (i + shift - n) : i + shift;
            if (chars1[i] != chars2[j]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNonTrivialRotation("cdeab", "cdeab"));
    }
}
