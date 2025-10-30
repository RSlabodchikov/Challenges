package com.slabodchikov.challenges.hackerrank.software.engineer;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/count-number-pairs/problem">Problem</a>
 */
public class CountNumberPair {

    /*
     * Complete the 'countAffordablePairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER budget
     */
    public static int countAffordablePairs(List<Integer> prices, int budget) {
        int count = 0;

        int i = 0;
        int j = prices.size() - 1;
        while (i < j) {
            int iPrice = prices.get(i);
            while (prices.get(j) > (budget - iPrice) && i < j) {
                j--;
            }
            if (i < j && (iPrice + prices.get(j) <= budget)) {
                count += j - i;
            }
            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(
            1,2,3
        );
        int budget = 7;
        System.out.println(countAffordablePairs(prices, budget));
    }
}
