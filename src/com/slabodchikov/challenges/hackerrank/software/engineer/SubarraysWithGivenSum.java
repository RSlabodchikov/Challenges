package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.*;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/subarrays-given-sum-bounded-maximum/problem">Problem</a>
 */
public class SubarraysWithGivenSum {

    /*
     * Complete the 'countSubarraysWithSumAndMaxAtMost' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY nums
     *  2. LONG_INTEGER k
     *  3. LONG_INTEGER M
     */
    public static long countSubarraysWithSumAndMaxAtMost(List<Integer> nums, long k, long M) {
        long subarraysCount = 0;
        int i = 0;
        for (int j = 0; j < nums.size(); j++) {
            if (nums.get(j) > M) {
                i = j;
                continue;
            }
            long sum = 0;
            for (int l = j; l >= i; l--) {
                sum += nums.get(l);
                if (sum == k) {
                    subarraysCount++;
                }
            }
        }
        return subarraysCount;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, -1, 2, 1, -2, 3);
        int k = 2;
        int M = 2;
        System.out.println(countSubarraysWithSumAndMaxAtMost(nums, k, M));
    }
}
