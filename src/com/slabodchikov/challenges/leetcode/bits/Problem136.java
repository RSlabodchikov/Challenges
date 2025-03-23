package com.slabodchikov.challenges.leetcode.bits;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/single-number">Problem 136</a>
 */
public class Problem136 {

    public static void main(String[] args) {

        Problem136 problem136 = new Problem136();
        int[] nums = {4,1,2,1,2};
        System.out.println(problem136.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }
}
