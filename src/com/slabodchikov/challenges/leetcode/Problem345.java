package com.slabodchikov.challenges.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">Problem 345</a>
 */
public class Problem345 {

    public static void main(String[] args) {

        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {

        StringBuilder result = new StringBuilder(s);
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('u');
        vowels.add('U');
        vowels.add('o');
        vowels.add('O');
        vowels.add('i');
        vowels.add('I');
        int start = 0;
        int end = s.length() - 1;
        for (; start < end; start++) {
            if (vowels.contains(s.charAt(start))) {
                while (end > start && !vowels.contains(s.charAt(end))) {
                    end--;
                }
                result.setCharAt(start, s.charAt(end));
                result.setCharAt(end, s.charAt(start));
                end--;
            }
        }

        return result.toString();
    }
}
