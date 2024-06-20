package com.slabodchikov.challenges.leetcode;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/">Problem 151</a>
 */
public class Problem151 {

    public static void main(String[] args) {

        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {

        LinkedList<String> words = new LinkedList<>();
        String pattern = "[a-zA-Z0-9]+";
        Matcher matcher = Pattern.compile(pattern).matcher(s);
        while (matcher.find()) {
            String currentWord = matcher.group();
            words.push(currentWord);
        }

        return String.join(" ", words);
    }
}
