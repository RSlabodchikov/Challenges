package com.slabodchikov.challenges;

import java.util.HashMap;
import java.util.Map;

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
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> lastSeenIndex = new HashMap<>();
        int maxLength = 0;
        int windowStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer previousIndex = lastSeenIndex.get(c);
            if (previousIndex != null && previousIndex >= windowStart) {
                windowStart = previousIndex + 1;
            }
            lastSeenIndex.put(c, i);
            maxLength = Math.max(maxLength, i - windowStart + 1);
        }

        return maxLength;
    }
}
