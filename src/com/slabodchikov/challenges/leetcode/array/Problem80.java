package com.slabodchikov.challenges.leetcode.array;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii">Problem 80</a>
 */
public class Problem80 {

    public static void main(String[] args) {

        Problem80 problem80 = new Problem80();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(problem80.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {

        int currentPosition = 0;
        int j = 1;
        int currentReplicas = 0;

        while (j < nums.length) {

            if (nums[j] == nums[currentPosition]) {
                currentReplicas++;
                if (currentReplicas <= 1) {
                    currentPosition++;
                    nums[currentPosition] = nums[j];
                }
            } else {
                currentReplicas = 0;
                currentPosition++;
                nums[currentPosition] = nums[j];
            }
            j++;
        }

        return currentPosition + 1;
    }
}
