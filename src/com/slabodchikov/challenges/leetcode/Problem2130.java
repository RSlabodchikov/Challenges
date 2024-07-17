package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">Problem 2130</a>
 */

public class Problem2130 {

    public static void main(String[] args) {
        int[] vals = {1,100000};
        System.out.println(pairSum(ListNode.fromArray(vals)));
    }

    public static int pairSum(ListNode head) {
        int maxSum = Integer.MIN_VALUE;
        int[] list = new int[10_001];
        int i = 0;
        while (head != null) {
            list[i++] = head.val;
            head = head.next;
        }
        for (int j = 0; j < i / 2; j++) {
            maxSum = Math.max(maxSum, list[j] + list[i - j - 1]);
        }

        return maxSum;
    }
}
