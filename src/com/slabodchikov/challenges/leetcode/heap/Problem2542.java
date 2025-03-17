package com.slabodchikov.challenges.leetcode.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/maximum-subsequence-score/">Problem 2542</a>
 */
public class Problem2542 {

    public static void main(String[] args) {

        Problem2542 solver = new Problem2542();
        int[] nums1 = {2, 1, 14, 12};
        int[] nums2 = {11, 7, 13, 6};
        System.out.println(solver.maxScore(nums1, nums2, 3));
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {

        List<int[]> sortedNums = new ArrayList<>(nums1.length);
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            if (nums2[i] == 0) {
                continue;
            }
            sortedNums.add(new int[]{nums1[i], nums2[i]});
        }

        long currentSum = 0;
        long maxScore = 0;
        PriorityQueue<Integer> currentNums = new PriorityQueue<>(k + 1, (a, b) -> a - b);
        sortedNums.sort((a, b) -> b[1] - a[1]);

        for (int[] nums : sortedNums) {
            currentSum += nums[0];
            currentNums.add(nums[0]);
            if (currentNums.size() == k + 1) {
                currentSum -= currentNums.poll();
            }
            if (currentNums.size() == k) {
                maxScore = Math.max(maxScore, currentSum * nums[1]);
            }
        }

        return maxScore;
    }
}
