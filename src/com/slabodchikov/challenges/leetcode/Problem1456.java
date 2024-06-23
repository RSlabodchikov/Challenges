package com.slabodchikov.challenges.leetcode;

import java.util.Set;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">Problem 1456</a>
 */
public class Problem1456 {

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int maxVowels = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(chars[i])) {
                maxVowels++;
            }
        }
        int currentVowels = maxVowels;
        for (int i = k; i < chars.length; i++) {
            if (vowels.contains(chars[i])) {
                currentVowels++;
            }
            if (vowels.contains(chars[i - k])) {
                currentVowels--;
            }
            maxVowels = Math.max(currentVowels, maxVowels);
            if (maxVowels == k) {
                return k;
            }
        }
        return maxVowels;
    }
}
