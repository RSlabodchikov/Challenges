package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.*;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/zero-sum-triplets-within-sliding-window/problem">Problem</a>
 */
public class ZeroSumTripletsWithSlidingWindow {

    /*
     * Complete the 'findZeroSumTripletsInWindow' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY readings
     *  2. INTEGER windowSize
     */

    public static List<List<Integer>> findZeroSumTripletsInWindow(List<Integer> readings, int windowSize) {
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        int n = readings.size();

        for (int i = 0; i <= n - 3; i++) {
            int maxK = Math.min(n - 1, i + windowSize - 1);
            for (int j = i + 1; j <= maxK - 1; j++) {
                for (int k = j + 1; k <= maxK; k++) {

                    if (readings.get(i) + readings.get(j) + readings.get(k) == 0) {
                        List<Integer> triplet = Arrays.asList(readings.get(i), readings.get(j), readings.get(k));
                        Collections.sort(triplet);

                        uniqueTriplets.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(uniqueTriplets);
    }

    public static void main(String[] args) {
        System.out.println(findZeroSumTripletsInWindow(Arrays.asList(-1, 1, 0, 5), 3));
    }
}
