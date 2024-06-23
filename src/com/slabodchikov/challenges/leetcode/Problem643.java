package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/maximum-average-subarray-i/">Problem 643</a>
 */
public class Problem643 {

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        int currentSum = maxSum;
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i];
            currentSum -= nums[i - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return ((double) maxSum) / k;
    }
}
