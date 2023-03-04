package com.slabodchikov.challenges.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 22.11.2022
 */
public class Euler050 {

    private static final Map<Long, Boolean> primeNumbers = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Pair<Long, Integer>> longestChains = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            longestChains.add(getLongestConsecutivePrime(scanner.nextLong()));
        }
        longestChains.forEach(chain -> System.out.println(chain.left + " " + chain.right));
    }

    public static Pair<Long, Integer> getLongestConsecutivePrime(long n) {
        List<Long> primes = new ArrayList<>();
        primes.add(2L);
        long maxLengthPrime = 0L;
        long prevSum = 0L;
        int prevStartIndex = 0;
        long sum;
        int chainLength;
        int maxChainLength = 0;
        for (long i = 3; i <= n; i += 2) {
            if (isPrimeNumber(i)) {
                primes.add(i);
            }
        }

        for (int i = 0; i < primes.size() - maxChainLength; i++) {
            int j = i;

            sum = prevSum;
            chainLength = maxChainLength;

            while (j > prevStartIndex) {
                j--;
                sum -= primes.get(j);
                sum += primes.get(j + maxChainLength);
            }
            prevSum = sum;
            prevStartIndex = i;

            for (j = maxChainLength + i; j < primes.size(); j++) {
                sum += primes.get(j);
                chainLength++;
                if (sum > n) {
                    break;
                }

                Boolean isPrime = primeNumbers.get(sum);
                if (isPrime != null && isPrime) {
                    prevSum = sum;
                    prevStartIndex = i;
                    maxChainLength = chainLength;
                    maxLengthPrime = sum;
                }
            }
        }
        return new Pair<>(maxLengthPrime, maxChainLength);
    }

    private static boolean isPrimeNumber(long num) {

        if (primeNumbers.containsKey(num)) {
            return primeNumbers.get(num);
        }
        if (num <= 5) {
            primeNumbers.put(num, num == 3 || num == 2 || num == 5);
            return num == 3 || num == 2 || num == 5;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            primeNumbers.put(num, false);
            return false;
        }
        for (long i = 5; i * i <= num; i += 6) {
            if ((num % i) == 0 || (num % (i + 2)) == 0) {
                primeNumbers.put(num, false);
                return false;
            }
        }
        primeNumbers.put(num, true);
        return true;
    }

    public static class Pair<L, R> {
        private final L left;
        private final R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<L, R> pair = (Pair<L, R>) o;
            return left == pair.left && right == pair.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
}
