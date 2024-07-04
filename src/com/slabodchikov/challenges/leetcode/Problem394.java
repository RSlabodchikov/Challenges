package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/decode-string/">Problem 394</a>
 */
public class Problem394 {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        if (s.isEmpty()) {
            return "";
        }
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                stringBuilder.append(chars[i]);
            } else {
                int l = i;
                while (l < chars.length && chars[l] != '[') {
                    l++;
                }
                int r = l + 1;
                int c = 1;

                while (c != 0) {
                    r++;
                    if (chars[r] == '[') {
                        c++;
                    } else if (chars[r] == ']') {
                        c--;
                    }
                }
                int k = Integer.parseInt(s.substring(i, l));
                String decoded = decodeString(s.substring(l + 1, r));
                stringBuilder.append(decoded.repeat(Math.max(0, k)));
                i = r;
            }
        }
        return stringBuilder.toString();
    }
}
