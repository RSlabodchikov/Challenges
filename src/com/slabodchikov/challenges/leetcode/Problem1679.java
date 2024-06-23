package com.slabodchikov.challenges.leetcode;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/max-number-of-k-sum-pairs/description/">Problem 1679</a>
 */
public class Problem1679 {

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;
        System.out.println(maxOperationsOptimized(nums, k));
    }

    public static int maxOperationsOptimized(int[] nums, int k) {
        int operations = 0;

        Arrays.sort(nums);
        int j = nums.length - 1;
        for (int i = 0; i < nums.length && nums[i] < k; i++) {
            while (j > i && nums[i] + nums[j] >= k) {
                if (nums[i] + nums[j] == k) {
                    operations++;
                    j--;
                    break;
                }
                j--;
            }
        }

        return operations;
    }

    public static int maxOperations(int[] nums, int k) {
        int operations = 0;

        for (int i = 0; i < nums.length; i++) {
            int numsI = nums[i];
            if (numsI == -1) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (numsI + nums[j] == k) {
                    operations++;
                    nums[j] = nums[i + 1];
                    i++;
                    break;
                }
            }
        }

        return operations;
    }
}
