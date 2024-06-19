package com.slabodchikov.challenges.leetcode;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/">Problem 2037</a>
 */
public class Problem2037 {

    public static void main(String[] args) {

        int[] seats = {4, 1, 5, 9};
        int[] students = {1, 3, 2, 6};
        System.out.println(minMovesToSeat(seats, students));
    }

    public static int minMovesToSeat(int[] seats, int[] students) {

        int moves = 0;
        Arrays.parallelSort(seats);
        Arrays.parallelSort(students);
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }
}
