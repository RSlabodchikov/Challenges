package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/generate-valid-angle-bracket-sequences/problem">Problem</a>
 */
public class GenerateValidAngleBracketSequences {

    /*
     * Complete the 'generateAngleBracketSequences' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER n as parameter.
     */
    public static List<String> generateAngleBracketSequences(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        backtrack(result, n, 0, 0, "");
        return result;
    }

    public static void backtrack(List<String> result, int n, int openCount, int closeCount, String currentSequence) {
        if (currentSequence.length() == 2 * n) {
            result.add(currentSequence);
            return;
        }
        if (openCount < n) {
            backtrack(result, n, openCount + 1, closeCount, currentSequence + "<");
        }
        if (closeCount < openCount) {
            backtrack(result, n, openCount, closeCount + 1, currentSequence + ">");
        }
    }

    public static void main(String[] args) {
        System.out.println(generateAngleBracketSequences(2));
        System.out.println(generateAngleBracketSequences(3));
        System.out.println(generateAngleBracketSequences(4));
        System.out.println(generateAngleBracketSequences(5));
    }
}
