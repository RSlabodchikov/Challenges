package com.slabodchikov.challenges.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/">Problem 1431</a>
 */
public class Problem1431 {

    public static void main(String[] args) {

        int[] candies = {2, 3, 5, 1, 3};
        int extra = 3;
        System.out.println(kidsWithCandies(candies, extra));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> results = new ArrayList<>(candies.length);
        int max = 1;
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        for (int candy : candies) {
            results.add(candy + extraCandies >= max);
        }
        return results;
    }
}
