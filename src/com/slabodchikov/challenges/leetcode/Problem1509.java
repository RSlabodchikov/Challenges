package com.slabodchikov.challenges.leetcode;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/">Problem 1509</a>
 */
public class Problem1509 {

    public static void main(String[] args) {
        int[] nums = {3,100,20};
        System.out.println(minDifference(nums));
    }

    public static int minDifference(int[] nums) {
        int length = nums.length;
        int minDifference = Integer.MAX_VALUE;
        if (length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        for (int l = 0; l <= 3; l++) {
            int r = 3 - l;
            int diff = (nums[length - 1 - r] - nums[l]);
            minDifference = Math.min(diff, minDifference);
        }
        return minDifference;
    }
}
