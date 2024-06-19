package com.slabodchikov.challenges.leetcode;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/two-sum/">Problem</a>
 */
public class Problem1 {

    public int[] twoSum(int[] nums, int target) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int i = 0, j = sortedNums.length - 1;
        int l = sortedNums[i], r = sortedNums[j];
        while (l + r != target) {
            if (l + r > target) {
                j--;
                r = sortedNums[j];
            } else {
                i++;
                l = sortedNums[i];
            }
        }

        i = -1;
        j = -1;

        for (int k = 0; k < nums.length && (i == -1 || j == -1); k++) {
            if (i == -1 && nums[k] == l) {
                i = k;
                continue;
            }
            if (j == -1 && nums[k] == r) {
                j = k;
            }
        }
        return new int[]{i, j};
    }
}
