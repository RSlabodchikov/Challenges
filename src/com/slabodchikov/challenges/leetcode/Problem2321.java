package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 */
public class Problem2321 {

    public static int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int[] diffs1 = new int[nums1.length];
        int[] diffs2 = new int[nums1.length];

        int origSum1 = getSumOfArray(nums1);
        int origSum2 = getSumOfArray(nums2);

        for (int i = 0; i < nums1.length; i++) {
            diffs1[i] = nums2[i] - nums1[i];
            diffs2[i] = nums1[i] - nums2[i];
        }
        int maxDiff1 = getMaxSumSubarray(diffs1);
        int maxDiff2 = getMaxSumSubarray(diffs2);
        
        return Math.max(origSum1 + maxDiff1, origSum2 + maxDiff2);
    }

    public static int getMaxSumSubarray(int[] array) {
        int maxDiffSum = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int j : array) {
            maxEndingHere += j;
            if (maxDiffSum < maxEndingHere) {
                maxDiffSum = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return Math.max(maxDiffSum, 0);
    }

    public static int getSumOfArray(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }
}
