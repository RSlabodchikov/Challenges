package com.slabodchikov.challenges.leetcode.binary.search;

/**
 * @author Roman Slabodchikov
 * @see <a href="http://leetcode.com/problems/find-peak-element/">Problem 374</a>
 */
public class Problem162 {

    public static void main(String[] args) {

        Problem162 problem = new Problem162();
        int[] array = {1,2,1,3,5,6,4};
        System.out.println(problem.findPeakElement(array));
    }

    public int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start != end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
