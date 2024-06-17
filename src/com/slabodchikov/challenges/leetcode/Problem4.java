package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov on 1/24/2023
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">Problem</a>
 */
public class Problem4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = mergeHalfSortedArrays(nums1, nums2);
        int resLength = nums1.length + nums2.length;
        if (resLength == 1) {
            return res[0];
        }
        if (resLength % 2 == 1) {
            return res[resLength / 2];
        } else {
            return (double) ((res[(resLength + 1) / 2] + res[(resLength - 1) / 2])) / 2;
        }
    }

    public static int[] mergeHalfSortedArrays(int[] nums1, int[] nums2) {
        int resLength = nums1.length + nums2.length;
        int[] res = new int[(resLength + 2) / 2];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length && k < (resLength + 2) / 2) {
            if (nums1[i] <= nums2[j]) {
                res[k] = nums1[i];
                i++;
            } else {
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length && k < (resLength + 2) / 2) {
            res[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length && k < (resLength + 2) / 2) {
            res[k] = nums2[j];
            j++;
            k++;
        }
        return res;
    }
}
