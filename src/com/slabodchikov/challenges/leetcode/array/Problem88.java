package com.slabodchikov.challenges.leetcode.array;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/merge-sorted-array">Problem 88</a>
 */
public class Problem88 {

    public static void main(String[] args) {

        Problem88 problem88 = new Problem88();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int m = 3;
        problem88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        while (i != -1 || j != -1) {
            if (i == -1) {
                nums1[i + j + 1] = nums2[j--];
            } else if (j == -1) {
                nums1[i + j + 1] = nums1[i--];
            } else if (nums1[i] >= nums2[j]) {
                nums1[i + j + 1] = nums1[i--];
            } else {
                nums1[i + j + 1] = nums2[j--];
            }
        }
    }
}
