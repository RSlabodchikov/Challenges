package com.slabodchikov.challenges.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Roman Slabodchikov
 */
public class ShortestSubSegment {

    private static final String SEGMENT_NOT_FOUND_MESSAGE = "NO SUBSEGMENT FOUND";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String originalInputString = sc.nextLine();

        int k = sc.nextInt();
        sc.nextLine();

        List<String> givenWords = new ArrayList<>();
        List<Integer> kNumbers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String inputWord = sc.nextLine();
            if (!givenWords.contains(inputWord)) {
                givenWords.add(inputWord);
            }
        }
        for (int i = 0; i < givenWords.size(); i++) {
            kNumbers.add(i);
        }

        String pattern = "[a-zA-Z]+";
        Matcher matcher = Pattern.compile(pattern).matcher(originalInputString);

        String currentWord;
        List<String> inputWords = new ArrayList<>();
        List<Integer> wordIndexes = new ArrayList<>();
        boolean wordMatch = false;
        while (matcher.find()) {
            currentWord = matcher.group();
            inputWords.add(currentWord);
            for (int i = 0; i < givenWords.size(); i++) {
                if (givenWords.get(i).equalsIgnoreCase(currentWord)) {
                    wordMatch = true;
                    wordIndexes.add(i);
                }
            }
            if (!wordMatch) {
                wordIndexes.add(-1);
            }
            wordMatch = false;
        }
        if (!wordIndexes.containsAll(kNumbers)) {
            System.out.println(SEGMENT_NOT_FOUND_MESSAGE);
            return;
        }
        int startIndex = 0;
        int endIndex;
        int currentLength;

        int minLength = inputWords.size();
        int maxStartIndex = 0;
        int minEndIndex = inputWords.size() - 1;

        Set<Integer> wordsFound;

        while (startIndex < inputWords.size() - givenWords.size() - 1) {
            endIndex = startIndex + 1;
            wordsFound = new HashSet<>();
            if (wordIndexes.get(startIndex) != -1) {
                wordsFound.add(wordIndexes.get(startIndex));
            }

            while (endIndex < (inputWords.size() - 1) && wordsFound.size() != givenWords.size()) {
                if (wordIndexes.get(endIndex) != -1) {
                    wordsFound.add(wordIndexes.get(endIndex));
                }
                endIndex++;
            }
            if (wordsFound.size() == givenWords.size()) {
                currentLength = endIndex - startIndex + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    maxStartIndex = startIndex;
                    minEndIndex = endIndex;
                }
            }
            startIndex++;
        }

        for (int i = maxStartIndex; i < minEndIndex; i++) {
            System.out.print(inputWords.get(i) + ' ');
        }
    }
}
