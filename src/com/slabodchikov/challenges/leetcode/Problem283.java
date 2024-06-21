package com.slabodchikov.challenges.leetcode;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/move-zeroes/description/">Problem 283</a>
 */
public class Problem283 {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {

        int zeroesCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroesCount++;
            } else {
                nums[i - zeroesCount] = nums[i];
            }
        }
        for (int i = nums.length - zeroesCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
