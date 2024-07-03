package com.slabodchikov.challenges.leetcode;

import java.util.*;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/determine-if-two-strings-are-close/">Problem 1657</a>
 */
public class Problem1657 {

    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        HashMap<Character, Integer> occurrences1 = new HashMap<>();
        for (char ch : word1Chars) {
            occurrences1.compute(ch, (k, v) -> (v == null) ? 1 : (v + 1));
        }

        HashMap<Character, Integer> occurrences2 = new HashMap<>();
        for (char ch : word2Chars) {
            occurrences2.compute(ch, (k, v) -> (v == null) ? 1 : (v + 1));
        }

        Set<Character> word1UniqueChars = occurrences1.keySet();
        Set<Character> word2UniqueChars = occurrences2.keySet();

        Collection<Integer> word1Occurrences = occurrences1.values();
        Collection<Integer> word2Occurrences = new ArrayList<>(occurrences2.values());

        if (!(word1UniqueChars.size() == word2UniqueChars.size())) {
            return false;
        }
        for (Character word1UniqueChar : word1UniqueChars) {
            if (!word2UniqueChars.remove(word1UniqueChar)) {
                return false;
            }
        }

        if (!(word1Occurrences.size() == word2Occurrences.size())) {
            return false;
        }
        for (Integer word1Occurrence : word1Occurrences) {
            if (!word2Occurrences.remove(word1Occurrence)) {
                return false;
            }
        }
        return true;
    }
}
