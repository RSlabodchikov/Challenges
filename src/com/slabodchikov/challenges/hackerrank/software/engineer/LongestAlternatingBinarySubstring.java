package com.slabodchikov.challenges.hackerrank.software.engineer;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/longest-alternating-binary-substring-with-limited-flips/problem">Problem</a>
 */
public class LongestAlternatingBinarySubstring {

    /*
     * Complete the 'longestAlternatingSubstring' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
    public static int longestAlternatingSubstring(String s, int k) {
        int currentMaxLength = 0;
        // v1: 010101
        // v2: 101010
        int v1Length = 0;
        int v2Length = 0;
        int v1Swaps = 0;
        int v2Swaps = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            // v1
            v1Length++;
            if ((i % 2 == 0 && currentChar == '1') || (i % 2 == 1 && currentChar == '0')) {
                v1Swaps++;
                if (v1Swaps <= k) {
                    currentMaxLength = Math.max(v1Length, currentMaxLength);
                } else {
                    for (int j = i - v1Length + 1; j <= i; j++) {
                        v1Length--;
                        if ((j % 2 == 0 && chars[j] == '1') || (j % 2 == 1 && chars[j] == '0')) {
                            v1Swaps--;
                            break;
                        }
                    }
                }
            } else {
                currentMaxLength = Math.max(v1Length, currentMaxLength);
            }

            // v2
            v2Length++;
            if ((i % 2 == 0 && currentChar == '0') || (i % 2 == 1 && currentChar == '1')) {
                v2Swaps++;
                if (v2Swaps <= k) {
                    currentMaxLength = Math.max(v2Length, currentMaxLength);
                } else {
                    for (int j = i - v2Length + 1; j <= i; j++) {
                        v2Length--;
                        if ((j % 2 == 0 && chars[j] == '0') || (j % 2 == 1 && chars[j] == '1')) {
                            v2Swaps--;
                            break;
                        }
                    }
                }
            } else {
                currentMaxLength = Math.max(v2Length, currentMaxLength);
            }
        }
        return currentMaxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestAlternatingSubstring("1001101", 2));
    }
}
