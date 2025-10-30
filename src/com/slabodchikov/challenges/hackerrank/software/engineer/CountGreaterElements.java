package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/count-elements-greater-than-previous-average/problem">Problem</a>
 */
public class CountGreaterElements {

    /*
     * Complete the 'countResponseTimeRegressions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY responseTimes as parameter.
     */
    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        if (responseTimes == null || responseTimes.isEmpty() || responseTimes.size() == 1) {
            return 0;
        }

        long currentSum = responseTimes.get(0);
        int counter = 0;

        for (int i = 1; i < responseTimes.size(); i++) {
            int currentResponseTime = responseTimes.get(i);
            currentSum += currentResponseTime;
            if (currentResponseTime > (currentSum / (i + 1))) {
                counter++;
            }
        }

        return counter;
    }
}
