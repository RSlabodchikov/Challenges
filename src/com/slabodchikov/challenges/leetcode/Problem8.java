package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/string-to-integer-atoi/">Problem</a>
 */
public class Problem8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483647"));
    }

    public static int myAtoi(String s) {
        long res = 0;
        int sign = 1;

        boolean signed = false;

        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            // skip whitespaces
            if (res == 0 && aChar == ' ' && !signed) {
                continue;
            } else if (res == 0 && aChar == '+' && !signed) {
                signed = true;
                continue;
            } else if (res == 0 && aChar == '-' && !signed) {
                sign = -1;
                signed = true;
                continue;
            }
            if (aChar < '0' || aChar > '9') {
                break;
            }
            signed = true;
            res = res * 10 + (aChar - '0');
            if (res >= Integer.MAX_VALUE && sign == 1 || res > Integer.MAX_VALUE) {
                if (sign > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }

        return (int) res * sign;
    }
}
