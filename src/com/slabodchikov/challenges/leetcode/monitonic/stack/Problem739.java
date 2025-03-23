package com.slabodchikov.challenges.leetcode.monitonic.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/daily-temperatures/">Problem 739</a>
 */
public class Problem739 {

    public static void main(String[] args) {

        Problem739 problem739 = new Problem739();
        int[] temperatures = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        System.out.println(Arrays.toString(problem739.dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        int[] nextDayForTemp = new int[71];
        for (int j = temperatures.length - 1; j > 0; j--) {
            nextDayForTemp[temperatures[j] - 30] = j;
            boolean found = false;
            int minInterval = Integer.MAX_VALUE;

            for (int i = temperatures[j - 1] - 30 + 1; i < 71; i++) {
                if (nextDayForTemp[i] != 0) {
                    minInterval = Math.min(minInterval, nextDayForTemp[i] - j + 1);
                    found = true;
                }
            }
            if (found) {
                result[j - 1] = minInterval;
            }
        }

        return result;
    }
}
