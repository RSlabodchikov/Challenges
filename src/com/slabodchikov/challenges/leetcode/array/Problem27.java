package com.slabodchikov.challenges.leetcode.array;

import java.util.Arrays;

import static java.util.Arrays.sort;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/remove-element/">Problem 27</a>
 */
public class Problem27 {

    public static void main(String[] args) {

        Problem27 problem27 = new Problem27();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        problem27.removeElement(nums, val);

        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {

        int count = 0;
        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {
            if (nums[i] == val) {
                count++;
                nums[i] = nums[j];
                j--;
                i--;
            }
        }
        return nums.length - count;
    }
}
