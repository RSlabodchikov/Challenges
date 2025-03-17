package com.slabodchikov.challenges.leetcode.binary.search;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/koko-eating-bananas">Problem 875</a>
 */
public class Problem875 {

    public static void main(String[] args) {

        Problem875 problem875 = new Problem875();
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        System.out.println(problem875.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {

        int maxElement = Integer.MIN_VALUE;
        long time;
        int result = -1;
        for (int pile : piles) {
            maxElement = Math.max(pile, maxElement);
        }
        int left = 1;
        int right = maxElement;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            time = 0;
            for (int p : piles) {
                time += (p + mid - 1) / mid;
            }
            if (time <= h) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
