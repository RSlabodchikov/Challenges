package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/grumpy-bookstore-owner/">Problem 1052</a>
 */
public class Problem1052 {

    public static void main(String[] args) {

        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int sum = 0;
        int tmpSum = 0;
        int maxSum = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            } else {
                tmpSum += customers[i];
            }
            if (i >= minutes && grumpy[i - minutes] == 1) {
                tmpSum -= customers[i - minutes];
            }
            if (tmpSum > maxSum) {
                maxSum = tmpSum;
            }
        }

        sum += maxSum;
        return sum;
    }
}
