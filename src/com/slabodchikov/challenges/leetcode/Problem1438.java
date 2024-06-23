package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit">Problem 1438</a>
 */
public class Problem1438 {

    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 7, 8, 10, 6, 5, 6};
        int limit = 4;
        System.out.println(longestSubarray(nums, limit));
    }

    public static int longestSubarray(int[] nums, int limit) {
        int maxLength = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (maxLength >= nums.length - i) {
                break;
            }
            int min = nums[i];
            int max = nums[i];
            int currentLength = 1;

            for (int j = i + 1; j < nums.length; j++) {
                int candidate = nums[j];
                if (candidate > max) {
                    if (candidate - min <= limit) {
                        currentLength++;
                        max = candidate;
                    } else {
                        break;
                    }
                } else if (candidate < min) {
                    if (max - candidate <= limit) {
                        currentLength++;
                        min = candidate;
                    } else {
                        break;
                    }
                } else {
                    currentLength++;
                }

            }
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
