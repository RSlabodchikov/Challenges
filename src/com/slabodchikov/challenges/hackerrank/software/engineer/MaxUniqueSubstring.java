package com.slabodchikov.challenges.hackerrank.software.engineer;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/max-unique-substring-length-in-session/problem">Problem</a>
 */
public class MaxUniqueSubstring {

    /*
     * Complete the 'maxDistinctSubstringLengthInSessions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING sessionString as parameter.
     */

    public static int maxDistinctSubstringLengthInSessions(String sessionString) {
        String[] sessions = sessionString.split("\\*");
        int maxLength = 0;
        for (String session : sessions) {
            if (session.length() > maxLength) {
                maxLength = Math.max(maxLength, findLongestSubstringWithUniqueCharacters(session.toCharArray()));
            }
        }
        return maxLength;

    }

    public static int findLongestSubstringWithUniqueCharacters(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int[] charsIndexes = new int[27];
        int largestSubstringSize = 0;
        int start = 0;
        int currentLength;
        for (int i = 0; i < chars.length; i++) {
            if (charsIndexes[chars[i] - 'a' + 1] != 0) {
                currentLength = i - start;
                start = charsIndexes[chars[i] - 'a' + 1] + 2;
                if (currentLength > largestSubstringSize) {
                    largestSubstringSize = currentLength;
                }
            }
            charsIndexes[chars[i] - 'a' + 1] = i + 1;
        }
        currentLength = chars.length - start;
        if (currentLength > largestSubstringSize) {
            largestSubstringSize = currentLength;
        }

        return largestSubstringSize;
    }

    public static void main(String[] args) {
        System.out.println(maxDistinctSubstringLengthInSessions("aa*abcdefa"));
    }
}
