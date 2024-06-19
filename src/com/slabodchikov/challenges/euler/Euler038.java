package com.slabodchikov.challenges.euler;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Roman Slabodchikov
 */
public class Euler038 {

    public static Set<Integer> getNumberDigits(int n) {
        Set<Integer> digits = new HashSet<>();

        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }

        return digits;
    }
}
