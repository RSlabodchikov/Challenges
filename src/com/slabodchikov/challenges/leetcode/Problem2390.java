package com.slabodchikov.challenges.leetcode;


import java.util.LinkedList;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/removing-stars-from-a-string/">Problem 2390</a>
 */
public class Problem2390 {

    public static void main(String[] args) {
        System.out.println(removeStars("erase*****"));
    }

    public static String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        LinkedList<Character> chars = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                chars.removeLast();
            } else {
                chars.addLast(c);
            }
        }
        for (char c : chars) {
            result.append(c);
        }

        return result.toString();
    }
}
