package com.slabodchikov.challenges.leetcode.backtracking;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number">Problem 17</a>
 */
public class Problem17 {

    public static void main(String[] args) {
        Problem17 problem17 = new Problem17();
        System.out.println(problem17.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<StringBuilder> result = new ArrayList<>((int) Math.pow(4, digits.length()));
        Map<Character, List<Character>> map = Map.ofEntries(
            new AbstractMap.SimpleEntry<>('2', List.of('a', 'b', 'c')),
            new AbstractMap.SimpleEntry<>('3', List.of('d', 'e', 'f')),
            new AbstractMap.SimpleEntry<>('4', List.of('g', 'h', 'i')),
            new AbstractMap.SimpleEntry<>('5', List.of('j', 'k', 'l')),
            new AbstractMap.SimpleEntry<>('6', List.of('m', 'n', 'o')),
            new AbstractMap.SimpleEntry<>('7', List.of('p', 'q', 'r', 's')),
            new AbstractMap.SimpleEntry<>('8', List.of('t', 'u', 'v')),
            new AbstractMap.SimpleEntry<>('9', List.of('w', 'x', 'y', 'z'))
        );
        int i;
        for (char digit : digits.toCharArray()) {
            List<Character> code = map.get(digit);
            if (result.isEmpty()) {
                for (char symbol : code) {
                    result.add(new StringBuilder().append(symbol));
                }
            } else {
                i = result.size();
                for (int j = 0; j < i; j++) {
                    StringBuilder currentString = result.get(j);
                    for (int k = code.size() - 1; k >= 0; k--) {
                        if (k == 0) {
                            currentString.append(code.get(k));
                        } else {
                            result.add(new StringBuilder(currentString).append(code.get(k)));
                        }
                    }
                }
            }
        }
        return result.stream()
            .map(StringBuilder::toString)
            .collect(Collectors.toList());
    }
}
