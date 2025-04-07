package com.slabodchikov.challenges.leetcode.monitonic.stack;

public class Problem901 {

    public static void main(String[] args) {

        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price
        // of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));  // return 6
    }

    static class StockSpanner {

        private final int[][] stocks;
        private int entriesCount;
        int prevStockPrice = 0;

        public StockSpanner() {

            entriesCount = 0;
            stocks = new int[10000][2];
        }

        public int next(int price) {

            entriesCount++;
            int span;
            if (price < prevStockPrice) {
                span = 1;
            } else if (price == prevStockPrice) {
                span = stocks[entriesCount - 2][1] + 1;
            } else {
                if (entriesCount == 1) {
                    span = 1;
                } else if (entriesCount == 2) {
                    span = 2;
                } else {
                    int prevHigherPriceIndex = -1;
                    for (int i = entriesCount - stocks[entriesCount - 2][1] - 1; i >= 0; ) {
                        if (stocks[i][0] > price) {
                            prevHigherPriceIndex = i;
                            break;
                        } else {
                            i -= stocks[i][1];
                        }
                    }
                    if (prevHigherPriceIndex == -1) {
                        span = entriesCount;
                    } else {
                        span = entriesCount - prevHigherPriceIndex - 1;
                    }
                }
            }
            prevStockPrice = price;
            stocks[entriesCount - 1][0] = price;
            stocks[entriesCount - 1][1] = span;

            return span;
        }
    }
}
