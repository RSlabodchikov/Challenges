package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/time-slot-task-pairing/problem">Problem</a>
 */
public class TimeSlotTaskPairing {

    /*
     * Complete the 'findTaskPairForSlot' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY taskDurations
     *  2. INTEGER slotLength
     */

    public static List<Integer> findTaskPairForSlot(List<Integer> taskDurations, int slotLength) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        int n = taskDurations.size();
        if (n <= 1) {
            return generateErrorResponse();
        }
        for (int i = 0; i < n; i++) {
            int currentValue = taskDurations.get(i);
            int dif = slotLength - currentValue;
            if (valueToIndex.get(dif) != null) {
                return Arrays.asList(valueToIndex.get(dif), i);
            } else {
                valueToIndex.put(currentValue, i);
            }
        }
        return generateErrorResponse();

    }

    public static List<Integer> generateErrorResponse() {
        return Arrays.asList(-1, -1);
    }

    public static void main(String[] args) {
        List<Integer> taskDurations = Arrays.asList(2, 7, 11, 15);
        int slotLength = 23;
        System.out.println(findTaskPairForSlot(taskDurations, slotLength));
    }
}
