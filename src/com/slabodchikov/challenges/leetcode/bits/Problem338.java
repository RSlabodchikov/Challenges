package com.slabodchikov.challenges.leetcode.bits;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/counting-bits/?envType=study-plan-v2&envId=leetcode-75">Problem 338</a>
 */
public class Problem338 {

    public static void main(String[] args) {

        Problem338 problem338 = new Problem338();
        System.out.println(Arrays.toString(problem338.countBits(3)));
        System.out.println(Arrays.toString(problem338.countBits(10)));
    }

    public int[] countBits(int n) {

        if (n == 0) {
            return new int[]{0};
        }
        if (n == 1) {
            return new int[]{0, 1};
        }
        if (n == 2) {
            return new int[]{0, 1, 1};
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 1;
        int powerOf2 = 2;
        int nextPower = powerOf2 * 2;
        for (int i = 3; i <= n; i++) {
            if (i == nextPower) {
                result[i] = 1;
                powerOf2 = i;
                nextPower = i * 2;
            } else {
                result[i] = result[powerOf2] + result[i - powerOf2];
            }
        }

        return result;
    }
}
