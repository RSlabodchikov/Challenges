package com.slabodchikov.challenges.hackerrank.software.engineer;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/check-palindrome-filter-non-letters/problem">Problem</a>
 */
public class CheckPalindrome {

    /*
     * Complete the 'isAlphabeticPalindrome' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts STRING code as parameter.
     */
    public static boolean isAlphabeticPalindrome(String code) {
        char[] chars = code.toLowerCase().toCharArray();
        if (chars.length < 2) {
            return true;
        }

        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if ((chars[i] < 'a') || (chars[i] > 'z')) {
                i++;
                continue;
            }
            if ((chars[j] < 'a') || (chars[j] > 'z')) {
                j--;
                continue;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlphabeticPalindrome(""));
        System.out.println(isAlphabeticPalindrome("A1b2B!a"));
        System.out.println(isAlphabeticPalindrome("abcba"));
        System.out.println(isAlphabeticPalindrome("aaa"));
        System.out.println(isAlphabeticPalindrome("aabb"));
    }
}
