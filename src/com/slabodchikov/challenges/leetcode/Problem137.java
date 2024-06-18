package com.slabodchikov.challenges.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Roman Slabodchikov on 5/22/2024
 * @see <a href="https://leetcode.com/problems/single-number-ii/description/">Problem 137</a>
 */
public class Problem137 {

    public int singleNumber(int[] nums) {
        Set<Integer> rs = new HashSet<>();
        Set<Integer> candidates = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (rs.add(nums[i])) {
                candidates.add(nums[i]);
            } else {
                candidates.remove(nums[i]);
            }
        }
        return candidates.stream().findFirst().orElse(0);
    }
}
