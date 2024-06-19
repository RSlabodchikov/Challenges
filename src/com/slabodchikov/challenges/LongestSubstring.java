package com.slabodchikov.challenges;

import java.util.LinkedList;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * @author Roman Slabodchikov
 */
public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring task = new LongestSubstring();
        System.out.println(task.calculateLongestSubstring(""));
    }

    public int calculateLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        LinkedList<Character> uniqList = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (uniqList.contains(c)) {
                if (uniqList.size() - 1 > maxLength) {
                    maxLength = uniqList.size();
                }
                while (uniqList.size() > 0 && uniqList.getFirst().equals(c)) {
                    uniqList.removeFirst();
                }
            }
            uniqList.addLast(c);
        }

        if (uniqList.size() - 1 > maxLength) {
            maxLength = uniqList.size();
        }

        return maxLength;
    }
}
