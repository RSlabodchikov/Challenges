package com.slabodchikov.challenges.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Roman Slabodchikov
 */
public class Euler014 {

    private static final Map<Integer, Integer> distancesMap = new HashMap<>(5000000);

    static {
        distancesMap.put(1, 1);
        distancesMap.put(9, 20);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        List<Integer> inputs = new ArrayList<>();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            inputs.add(n);
        }

        Map<Integer, Integer> results = new HashMap<>(t + 1);
        results.put(1, 1);

        AtomicInteger longestChainNumber = new AtomicInteger(1);
        AtomicInteger maxLength = new AtomicInteger(1);
        AtomicInteger maxN = new AtomicInteger(1);

        inputs.stream()
            .sorted(Integer::compareTo)
            .forEach(n -> {
                int currentLength;

                for (int i = (maxN.get() >> 1 << 1) + 1; i <= n; i += 2) {
                    currentLength = getChainLength(i);
                    if (currentLength >= maxLength.get()) {
                        maxLength.set(currentLength);
                        longestChainNumber.set(i);
                    }
                }
                maxN.set(n);
                results.put(n, longestChainNumber.get());
            });

        inputs.forEach(n -> System.out.println(results.get(n)));

//        int maxInput = inputs.stream()
//            .max(Integer::compareTo).orElse(1);
//        List<Integer> requiredNumbers = IntStream.range(1, maxInput)
//            .boxed()
//            .collect(Collectors.toList());
//
//        calculateSequenceForN(2, 0, 2, requiredNumbers);
//        inputs.stream()
//            .sorted(Integer::compareTo)
//            .forEach(n -> {
//                int currentLength;
//
//                for (int i = (maxN.get() >> 1 << 1) + 1; i <= n; i += 2) {
//                    if (distancesMap.containsKey(i)) {
//                        currentLength = distancesMap.get(i);
//                        if (currentLength >= maxLength.get()) {
//                            maxLength.set(currentLength);
//                            longestChainNumber.set(i);
//                        }
//                    }
//                }
//                maxN.set(n);
//                results.put(n, longestChainNumber.get());
//            });
//        inputs.forEach(n -> System.out.println(results.get(n)));
    }

    public static Integer getChainLength(int n) {
        Queue<Integer> chain = new LinkedList<>();
        chain.add(n);

        int nextValue = n % 2 == 0
            ? (n / 2)
            : ((3 * n) + 1);
        int distance = 1;

        while (!distancesMap.containsKey(nextValue)) {
            chain.add(nextValue);
            distance++;
            nextValue = nextValue % 2 == 0
                ? (nextValue / 2)
                : ((3 * nextValue) + 1);
        }
        distance += distancesMap.get(nextValue);
        while (!chain.isEmpty()) {
            Integer element = chain.poll();
            distancesMap.put(element, distance--);
        }
        return distancesMap.get(n);
    }

    public static void calculateSequenceForN(Integer currentValue, int n, int distance, List<Integer> requiredNumbers) {
        requiredNumbers.remove(currentValue);
        if (distancesMap.containsKey(currentValue) || requiredNumbers.isEmpty()) {
            return;
        }
        distancesMap.put(currentValue, distance);
        if ((currentValue - 1) % 3 == 0 && distance < 700) {
            n = 0;
            calculateSequenceForN(((currentValue - 1) / 3), n, distance + 1, requiredNumbers);
        } else if (n < 5) {
            calculateSequenceForN(currentValue * 2, n + 1, distance + 1, requiredNumbers);
        }

    }
}
