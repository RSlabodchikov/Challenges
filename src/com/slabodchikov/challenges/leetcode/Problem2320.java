package com.slabodchikov.challenges.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Slabodchikov on 1/23/2023
 */
public class Problem2320 {

    public static final Map<Integer, Long> cache = new HashMap<>();

    private static final long MODULO = (int) Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        System.out.println(countHousePlacements(1000));
    }

    public static int countHousePlacements(int n) {
        return (int) (Math.pow(countHousePlacementsOneRow(n), 2) % MODULO);
    }

    public static long countHousePlacementsOneRow(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n <= 0) {
            return 1;
        }

        if (n == 1) {
            return 2;
        }

        long val = (countHousePlacementsOneRow(n - 1) + countHousePlacementsOneRow(n - 2));
        cache.put(n, val);
        return val % MODULO;
    }
}
