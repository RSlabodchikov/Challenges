package com.slabodchikov.challenges.leetcode;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov on 5/22/2024
 * @see <a href="https://leetcode.com/problems/sort-colors/">Problem 77</a>
 */
public class Problem75 {

    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {

        int[] counts = {0, 0, 0};
        for (int num : nums) {
            if (num == 0) {
                counts[0] = counts[0] + 1;
            } else if (num == 1) {
                counts[1] = counts[1] + 1;
            } else {
                counts[2] = counts[2] + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < counts[0]) {
                nums[i] = 0;
            } else if (i < counts[1] + counts[0]){
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
