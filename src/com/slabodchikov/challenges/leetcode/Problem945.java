package com.slabodchikov.challenges.leetcode;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/">Problem 945</a>
 */
public class Problem945 {

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 1, 2, 1, 7};
        System.out.println(minIncrementForUnique(nums));
    }

    public static int minIncrementForUnique(int[] nums) {

        Arrays.sort(nums);
        int minIncrement = 0;
        int a, b;
        for (int i = 1; i < nums.length; i++) {
            a = nums[i - 1];
            b = nums[i];
            if (b <= a) {
                minIncrement += a - b + 1;
                nums[i] = a + 1;
            }
        }
        return minIncrement;
    }
}
