package com.slabodchikov.challenges.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 29.11.2022
 */
public class Euler060 {

    private static final Map<Long, Boolean> primeNumbers = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> primeNumbersRemainder1 = new ArrayList<>();
        List<Integer> primeNumbersRemainder2 = new ArrayList<>();

        for (int i = 3; i < n; i += 2) {
            if (isPrimeNumber(i)) {
                if (i % 3 == 1) {
                    primeNumbersRemainder1.add(i);
                } else if (i % 3 == 2) {
                    primeNumbersRemainder2.add(i);
                } else {
                    primeNumbersRemainder1.add(i);
                    primeNumbersRemainder2.add(i);
                }
            }
        }
        getSumOfPrimeSets(primeNumbersRemainder1, k);
        getSumOfPrimeSets(primeNumbersRemainder2, k);

        System.out.println(primeNumbersRemainder1.size());
        System.out.println(primeNumbersRemainder2.size());
    }

    private static int getSumOfPrimeSets(List<Integer> primesGroup, int k) {
        int sum = 0;
        List<Pair<Integer, Integer>> primePairs = new ArrayList<>(primesGroup.size());
        for (int j = 0; j < primesGroup.size(); j++) {
            int left = primesGroup.get(j);
            for (int m = j + 1; m < primesGroup.size(); m++) {
                if (isPrimeSet(left, primesGroup.get(m))) {
                    primePairs.add(new Pair<>(left, primesGroup.get(m)));
                }
            }
        }

        // need to group pairs now

        return sum;
    }

    private static int getCombinationsCount(int n, int k) {
        int count = 1;
        for (int i = 0; i < k; i++) {
            count = count * (n - i) / (i + 1);
        }
        return count;
    }

    private static boolean canBeAddedToPrimeSet(List<Integer> primeSet, int newPrime) {
        return primeSet.stream().allMatch(prime -> isPrimeSet(prime, newPrime));
    }

    private static boolean isPrimeSet(int prime1, int prime2) {
        int digitsCount1 = (int) Math.log10(prime1) + 1;
        int digitsCount2 = (int) Math.log10(prime2) + 1;
        int combination1 = prime1 * (int) Math.pow(10, digitsCount2) + prime2;
        int combination2 = prime2 * (int) Math.pow(10, digitsCount1) + prime1;

        return isPrimeNumber(combination2) && isPrimeNumber(combination1);
    }

    private static boolean isPrimeNumber(long num) {

        if (primeNumbers.containsKey(num)) {
            return primeNumbers.get(num);
        }
        if (num <= 5) {
            primeNumbers.put(num, num == 3);
            return num == 3;
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

        public Pair<L, R> of(L left, R right) {
            return new Pair<>(left, right);
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
