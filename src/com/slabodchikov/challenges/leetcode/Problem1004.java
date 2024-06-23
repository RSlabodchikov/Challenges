package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/max-consecutive-ones-iii/">Problem 1004</a>
 */
public class Problem1004 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int longestArray = 0;
        int currentZeroCount = 0;
        int currentArrayLength = 0;
        for (int i = 0; i < nums.length; i++) {
            currentArrayLength++;
            if (nums[i] == 0) {
                currentZeroCount++;
                while (currentZeroCount > k) {
                    currentArrayLength--;
                    if (nums[i - currentArrayLength] == 0) {
                        currentZeroCount--;
                    }
                }
            }
            longestArray = Math.max(longestArray, currentArrayLength);
        }
        return longestArray;
    }
}
