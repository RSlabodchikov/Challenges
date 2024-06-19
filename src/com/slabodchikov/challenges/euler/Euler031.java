package com.slabodchikov.challenges.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Euler031 {

    private static final long LIMIT = (long) Math.pow(10, 9) + 7;

    private static final List<Integer> availableCoins = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        List<Integer> inputs = new ArrayList<>(t);

        for (int i = 0; i < t; i++) {
            inputs.add(in.nextInt());
        }

        int maxInput = inputs.stream()
            .max(Integer::compareTo).orElse(1);
        long[] ways = calculateReversedWaysForNumber(maxInput);

        inputs.forEach(input ->
            System.out.println(ways[input]));
    }

    public static long[] calculateReversedWaysForNumber(int number) {
        long[] ways = new long[number + 1];
        ways[0] = 1;

        for (Integer availableCoin : availableCoins) {
            for (int j = availableCoin; j <= number; j++) {
                ways[j] += ways[j - availableCoin];
                ways[j] %= LIMIT;
            }
        }

        return ways;
    }
}
