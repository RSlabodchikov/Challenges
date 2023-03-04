package com.slabodchikov.challenges.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Slabodchikov on 1/27/2023
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">Problem 70</a>
 */
public class Problem70 {

    public final static Map<Integer, Integer> ways = new HashMap<>();

    static {
        ways.put(1, 1);
        ways.put(2, 2);
    }

    public int climbStairs(int n) {
        if (!ways.containsKey(n)) {
            int nWays = climbStairs(n - 1) + climbStairs(n - 2);
            ways.put(n, nWays);
        }
        return ways.get(n);
    }

    public static int log2(int N) {
        return (int) (Math.log(N) / Math.log(2));
    }

}
