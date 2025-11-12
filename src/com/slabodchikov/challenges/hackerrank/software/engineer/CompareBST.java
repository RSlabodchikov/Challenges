package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/compare-bsts-equal-values-different-structure/problem">Problem</a>
 */
public class CompareBST {

    /*
     * Complete the 'verifySameMultisetDifferentStructure' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY root1
     *  2. INTEGER_ARRAY root2
     */
    public static boolean verifySameMultisetDifferentStructure(List<Integer> root1, List<Integer> root2) {
        boolean isSameStructure = true;

        for (int i = 0; i < root1.size() && i < root2.size(); i++) {
            if ((int) root1.get(i) != root2.get(i)) {
                isSameStructure = false;
                break;
            }
        }
        if (isSameStructure) {
            return false;
        }

        root1.removeIf(i -> i == 100001);
        root2.removeIf(i -> i == 100001);

        if (root1.size() != root2.size()) {
            return false;
        }

        root1.sort(Integer::compare);
        root2.sort(Integer::compare);
        for (int i = 0; i < root1.size(); i++) {
            if ((int) root1.get(i) != root2.get(i)) {
                return false;
            }
        }
        return true;
    }
}
