package com.slabodchikov.challenges.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 03.11.2022
 */
public class FibonacciFactor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCasesCount = sc.nextInt();

        int[] inputNumbers = new int[testCasesCount];

        for (int i = 0; i < testCasesCount; i++) {
            inputNumbers[i] = sc.nextInt();
        }

        List<Long> fibonacciNumbers = new ArrayList<>(Arrays.asList(2L, 3L));
        List<Long> numberFactors;
        Long currentFibonacciNumber;
        boolean foundNumber = false;

        for (int i = 0; i < testCasesCount; i++) {
            numberFactors = getNumberFactors(inputNumbers[i]);
            for (int j = 0; !foundNumber; j++) {
                if (fibonacciNumbers.size() < j + 1) {
                    addFibonacciNumber(fibonacciNumbers);
                }
                currentFibonacciNumber = fibonacciNumbers.get(j);
                for (Long numberFactor : numberFactors) {
                    if ((currentFibonacciNumber % numberFactor) == 0) {
                        foundNumber = true;
                        System.out.println(String.join(" ", String.valueOf(currentFibonacciNumber),
                            String.valueOf(numberFactor)));
                        break;
                    }
                }
            }
            foundNumber = false;
        }
    }

    public static List<Long> getNumberFactors(int n) {
        List<Long> factors = new ArrayList<>();
        for (long i = 2; i <= n; i++) {
            if ((n % i) == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static void addFibonacciNumber(List<Long> fibonacciNumbers) {
        int size = fibonacciNumbers.size();
        Long newNumber = fibonacciNumbers.get(size - 1) + fibonacciNumbers.get(size - 2);
        fibonacciNumbers.add(newNumber);
    }
}
