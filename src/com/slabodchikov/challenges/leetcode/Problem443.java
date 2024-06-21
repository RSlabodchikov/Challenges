package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/string-compression/">Problem 443</a>
 */
public class Problem443 {

    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {

        if (chars.length == 1) {
            return 1;
        }
        int currentLength = 1;
        int currentPosition = 1;
        int totalLength = 1;
        char currentChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != currentChar) {
                currentChar = chars[i];

                if (currentLength != 1) {
                    char[] digits = String.valueOf(currentLength).toCharArray();
                    for (char digit : digits) {
                        chars[currentPosition++] = digit;
                        totalLength++;
                    }
                    currentLength = 1;
                }
                chars[currentPosition++] = currentChar;
                totalLength++;
            } else {
                currentLength++;
            }
        }
        if (currentLength != 1) {
            char[] digits = String.valueOf(currentLength).toCharArray();
            for (char digit : digits) {
                chars[currentPosition++] = digit;
                totalLength++;
            }
        }

        return totalLength;
    }
}
