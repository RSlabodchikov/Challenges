package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/lexicographical-letter-combinations-phone-digits/problem">Problem</a>
 */
public class LexicographicalLetterCombinations {

    /*
     * Complete the 'minTasksToCancelForNoConflict' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING digits as parameter.
     */

    public static List<String> minTasksToCancelForNoConflict(String digits) {
        Deque<char[]> result = new ArrayDeque<>();
        int n = digits.length();
        result.add(digits.toCharArray());
        for (int i = 0; i < n; i++) {
            int j = result.size();
            List<Character> letters = mapDigitToLetters(digits.charAt(i));
            for (int k = 0; k < j; k++) {
                char[] currentArray = result.removeFirst();
                for (Character letter : letters) {
                    char[] newArray = Arrays.copyOf(currentArray, n);
                    newArray[i] = letter;
                    result.addLast(newArray);
                }
            }
        }

        return result.stream().map(String::new).collect(Collectors.toList());
    }

    public static List<Character> mapDigitToLetters(char c) {
        return switch (c) {
            case '0' -> List.of('0');
            case '1' -> List.of('1');
            case '2' -> Arrays.asList('a', 'b', 'c');
            case '3' -> Arrays.asList('d', 'e', 'f');
            case '4' -> Arrays.asList('g', 'h', 'i');
            case '5' -> Arrays.asList('j', 'k', 'l');
            case '6' -> Arrays.asList('m', 'n', 'o');
            case '7' -> Arrays.asList('p', 'q', 'r', 's');
            case '8' -> Arrays.asList('t', 'u', 'v');
            case '9' -> Arrays.asList('w', 'x', 'y', 'z');
            default -> throw new RuntimeException();
        };
    }

    public static void main(String[] args) {
        System.out.println(minTasksToCancelForNoConflict("23"));
    }
}
