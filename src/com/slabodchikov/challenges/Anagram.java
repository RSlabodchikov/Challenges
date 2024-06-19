package com.slabodchikov.challenges;

import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 */
public class Anagram {

    /**
     * Example input: [“are”,”rat”,” “fat”, “taf”]
     *
     * @param inputs
     * @return
     */
    public int getNumberOfAnagramGroups(List<String> inputs) {
        int count = 0;
        while (inputs.size() > 0) {
            String currentString = inputs.get(0);
            char[] chars = currentString.toCharArray();
            Arrays.sort(chars);
            for (int j = 1; j < inputs.size(); ) {
                char[] nextChars = inputs.get(j).toCharArray();
                if (nextChars.length == chars.length && Arrays.compare(nextChars, chars) == 0) {
                    inputs.remove(j);
                } else {
                    j++;
                }
            }
        }

        return count;
    }
}
