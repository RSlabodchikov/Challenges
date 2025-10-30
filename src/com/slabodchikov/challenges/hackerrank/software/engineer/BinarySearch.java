package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/lookup-with-binary-search/problem">Problem</a>
 */
public class BinarySearch {

    /*
     * Complete the 'binarySearch' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY nums
     *  2. INTEGER target
     */
    public static int binarySearch(List<Integer> nums, int target) {
        int i = 0;
        int j = nums.size() - 1;
        while (i <= j) {
            int mid = (j + i + 1) / 2;
            int result = Integer.compare(target, nums.get(mid));
            if (result == 0) {
                return mid;
            } else if (result < 0) {
                j = mid == j ? mid - 1 : mid;
            } else {
                i = mid == j ? mid + 1 : mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(binarySearch(nums, 1));
        System.out.println(binarySearch(nums, 2));
        System.out.println(binarySearch(nums, 3));
        System.out.println(binarySearch(nums, 4));
        System.out.println(binarySearch(nums, 5));
        System.out.println(binarySearch(nums, 6));
    }
}
