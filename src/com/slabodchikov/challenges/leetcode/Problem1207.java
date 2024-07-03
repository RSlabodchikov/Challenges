package com.slabodchikov.challenges.leetcode;


import java.util.HashMap;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/unique-number-of-occurrences/">Problem 1207</a>
 */
public class Problem1207 {

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int num : arr) {
            occurrences.compute(num, (k, v) -> (v == null) ? 1 : (v + 1));
        }
        long distinctOccurrences = occurrences.values().stream().distinct().count();
        return occurrences.size() == distinctOccurrences;
    }
}
