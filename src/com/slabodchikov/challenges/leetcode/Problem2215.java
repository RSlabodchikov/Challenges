package com.slabodchikov.challenges.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays/">Problem 2215</a>
 */
public class Problem2215 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 1, 2, 2};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>(2);

        HashSet<Integer> array1 = new HashSet<>();
        HashSet<Integer> array2 = new HashSet<>();
        for (int value : nums1) {
            array1.add(value);
        }
        for (int k : nums2) {
            array2.add(k);
        }
        for (int k : nums1) {
            array2.remove(k);
        }
        for (int i : nums2) {
            array1.remove(i);
        }

        res.add(array1.stream().toList());
        res.add(array2.stream().toList());
        return res;
    }
}
