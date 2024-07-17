package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/average-waiting-time/">Problem 1701</a>
 */
public class Problem1701 {

    public static void main(String[] args) {

        int[][] customers = {{1, 2}, {2, 5,}, {4, 3}};
        System.out.println(averageWaitingTime(customers));
    }

    public static double averageWaitingTime(int[][] customers) {

        long totalWaitingTime = 0;
        int chefAvailability = 0;
        for (int[] customer : customers) {
            totalWaitingTime += customer[1];
            if (chefAvailability <= customer[0]) {
                chefAvailability = customer[0] + customer[1];
            } else {
                totalWaitingTime += chefAvailability - customer[0];
                chefAvailability = chefAvailability + customer[1];
            }
        }
        return (double) totalWaitingTime / customers.length;
    }
}
