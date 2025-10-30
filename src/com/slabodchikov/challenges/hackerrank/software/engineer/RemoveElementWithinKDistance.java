package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/remove-elements-within-k-distance/problem">Problem</a>
 */
public class RemoveElementWithinKDistance {

    /*
     * Complete the 'debounceTimestamps' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY timestamps
     *  2. INTEGER K
     */

    public static int debounceTimestamps(List<Integer> timestamps, int K) {

        if (timestamps.size() <= 1) {
            return timestamps.size();
        }
        int currentElement = timestamps.get(0);
        int newSize = 1;
        for (int i = 1; i < timestamps.size(); i++) {
            int newElement = timestamps.get(i);
            if (newElement - currentElement >= K) {
                currentElement = newElement;
                newSize++;
            }
        }
        return newSize;
    }

    public static void main(String[] args) {
        List<Integer> timestamps = Arrays.asList(1, 2, 3, 8, 10);
        int K = 3;
        System.out.println(debounceTimestamps(timestamps, K));
    }
}
