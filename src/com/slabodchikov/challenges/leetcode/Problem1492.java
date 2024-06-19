package com.slabodchikov.challenges.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/the-kth-factor-of-n/description/">Problem 1492</a>
 */
public class Problem1492 {

    public static void main(String[] args) {

        System.out.println(kthFactor(7, 2));
    }

    public static int kthFactor(int n, int k) {

        if (k > n / 2 + 1) {

            return -1;
        }
        int step = n % 2 == 0 ? 1 : 2;
        for (int i = 1; i <= n; i += step) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }

        return -1;
    }
}
