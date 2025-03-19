package com.slabodchikov.challenges.leetcode.dp;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/house-robber">Problem 198</a>
 */
public class Problem198 {

    public static void main(String[] args) {

        Problem198 problem = new Problem198();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(problem.rob(nums));
    }

    /**
     * Solution with no extra memory
     */
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }
        return nums[nums.length - 1];
    }

    /**
     * Solution with extra memory for storing max rob results for previous nums
     */
    public int robWithExtraMemory(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxRobResult = new int[nums.length];
        maxRobResult[0] = nums[0];
        maxRobResult[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            maxRobResult[i] = Math.max(maxRobResult[i - 1], maxRobResult[i - 2] + nums[i]);
        }
        return maxRobResult[nums.length - 1];
    }
}
