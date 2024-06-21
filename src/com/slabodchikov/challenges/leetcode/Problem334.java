package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/increasing-triplet-subsequence/description/">Problem 334</a>
 */
public class Problem334 {

    public static void main(String[] args) {

        int[] nums = {3, 4, 1, 5};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                return true;
            }
        }

        return false;
    }

//    public static boolean increasingTriplet(int[] nums) {
//
//        if (nums.length < 3) {
//            return false;
//        }
//        int x = nums[0];
//        Integer y = null;
//        boolean result = false;
//        int tmp;
//        for (int a = 1; a < nums.length; a++) {
//            tmp = nums[a];
//            if (y == null) {
//                if (x >= tmp) {
//                    x = tmp;
//                } else {
//                    y = tmp;
//                }
//            } else {
//                if (y < tmp) {
//                    result = true;
//                    break;
//                } else if (x < tmp) {
//                    y = tmp;
//                } else if (a < nums.length - 1) {
//                    a++;
//                    if (nums[a] > y) {
//                        result = true;
//                        break;
//                    } else if (nums[a] > tmp){
//                        x = tmp;
//                        y = nums[a];
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
}
