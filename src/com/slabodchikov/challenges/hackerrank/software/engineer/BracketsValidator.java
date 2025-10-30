package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/validate-properly-nested-brackets/problem">Problem</a>
 */
public class BracketsValidator {

    /*
     * Complete the 'areBracketsProperlyMatched' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts STRING code_snippet as parameter.
     */

    public static boolean areBracketsProperlyMatched(String code_snippet) {
        Deque<Character> openingBrackets = new ArrayDeque<>();
        for (char c : code_snippet.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                openingBrackets.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (openingBrackets.isEmpty()) {
                    return false;
                }
                char openBracket = openingBrackets.pop();
                if (openBracket == '[' && c != ']') {
                    return false;
                }
                if (openBracket == '(' && c != ')') {
                    return false;
                }
                if (openBracket == '{' && c != '}') {
                    return false;
                }
            }
        }
        return openingBrackets.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(areBracketsProperlyMatched("42"));
        System.out.println(areBracketsProperlyMatched("code_snippet = if (a[0] > b[1]) { doSomething(); }"));
    }
}
