package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/find-pivot-index/description/">Problem 724</a>
 */
public class Problem724 {

    public static void main(String[] args) {
        int[] nums = {-1,-1,0,1,1,0};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int leftSum = 0;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
            totalSum -= nums[i];
        }
        return -1;
    }
}
