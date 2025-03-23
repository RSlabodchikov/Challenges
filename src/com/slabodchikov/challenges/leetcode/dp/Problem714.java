package com.slabodchikov.challenges.leetcode.dp;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee">Problem 714</a>
 */
public class Problem714 {

    public static void main(String[] args) {

        Problem714 problem714 = new Problem714();
        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(problem714.maxProfit(prices, fee));
    }

    public int maxProfit(int[] prices, int fee) {

        if (prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int i = 0; i < n; i++) {
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i] - fee);
        }

        return sell;
    }
}
