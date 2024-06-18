package com.slabodchikov.challenges.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Roman Slabodchikov on 5/23/2024
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
