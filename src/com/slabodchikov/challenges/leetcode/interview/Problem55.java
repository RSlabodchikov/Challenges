package com.slabodchikov.challenges.leetcode.interview;

/**
 * @author Roman Slabodchikov on 1/26/2023
 * @see <a href="https://leetcode.com/problems/jump-game/"></a>
 */
public class Problem55 {

    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && !validateZero(nums, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateZero(int[] nums, int zeroIndex) {
        for (int j = zeroIndex - 1; j >= 0; j--) {
            if (zeroIndex - j < nums[j]) {
                return true;
            }
        }
        return false;
    }
}
