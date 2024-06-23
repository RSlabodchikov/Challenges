package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/">Problem 1493</a>
 */
public class Problem1493 {

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int zeroPos = -1;
        int longestSubarray = 0;
        int currentSubarray = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                if (zeroPos != -1) {
                    longestSubarray = Math.max(longestSubarray, currentSubarray - 1);
                    currentSubarray = i - zeroPos - 1;
                }
                zeroPos = i;
            } else {
                currentSubarray++;
                longestSubarray = Math.max(longestSubarray, currentSubarray);
            }
        }
        if (zeroPos == -1) {
            longestSubarray--;
        }

        return longestSubarray;
    }
}
