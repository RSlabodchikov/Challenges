package com.slabodchikov.challenges.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Problem 215</a>
 */
public class Problem215 {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));

        for (int i = 0; i < nums.length; i++) {

            if (heap.size() < k) {
                heap.add(nums[i]);
            } else if (heap.peek() < nums[i]) {
                heap.add(nums[i]);
                heap.remove();
            }
        }

        return heap.peek();
    }
}
