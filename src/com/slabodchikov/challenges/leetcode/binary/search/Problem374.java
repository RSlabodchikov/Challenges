package com.slabodchikov.challenges.leetcode.binary.search;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/guess-number-higher-or-lower">Problem 374</a>
 */
public class Problem374 {

    private int correctNumber;

    public static void main(String[] args) {

        Problem374 problem374 = new Problem374();
        problem374.correctNumber = 4;
        System.out.println(problem374.guessNumber(4));
    }

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     * int guess(int num);
     */
    public int guessNumber(int n) {

        return guessIterative(1, n);
    }

    public int guessIterative(int lowerBound, int upperBound) {

        int guess;
        int tmp;

        while (lowerBound <= upperBound) {
            guess = (lowerBound + (upperBound - lowerBound) / 2);
            tmp = guess(guess);
            if (tmp == 0) {
                return guess;
            } else if (tmp > 0) {
                lowerBound = guess + 1;
            } else {
                upperBound = guess - 1;
            }
        }
        return -1;
    }

    public int guessRecursive(int lowerBound, int upperBound) {

        int currentGuess = (lowerBound + (upperBound - lowerBound) / 2);
        int guess = guess(currentGuess);
        if (guess == 0) {
            return currentGuess;
        } else if (guess > 0) {
            return guessRecursive(currentGuess + 1, upperBound);
        } else {
            return guessRecursive(lowerBound, currentGuess - 1);
        }
    }

    public int guess(int num) {

        return Integer.compare(correctNumber, num);
    }
}
