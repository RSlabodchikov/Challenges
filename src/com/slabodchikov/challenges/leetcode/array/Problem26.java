package com.slabodchikov.challenges.leetcode.array;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Problem 26</a>
 */
public class Problem26 {

    public static void main(String[] args) {

        Problem26 problem26 = new Problem26();
        int[] nums = {1,1,2};
        System.out.println(problem26.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {

        int i = 1;
        int j = 1;
        int k = 1;
        int n = nums.length;
        int currentElement = nums[0];
        while (j < n) {
            if (nums[j] != currentElement) {
                nums[i] = nums[j];
                currentElement = nums[i];
                i++;
                k++;
            }
            j++;
        }

        return k;
    }
}
