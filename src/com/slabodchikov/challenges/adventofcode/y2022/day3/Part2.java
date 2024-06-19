package com.slabodchikov.challenges.adventofcode.y2022.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Part2 {

    private static final int groupSize = 3;

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day3\\input.txt");
        Scanner scanner = new Scanner(inputData);

        String currentLine;
        int totalSum = 0;
        List<String> currentGroup = new ArrayList<>();

        int size = 0;

        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            size++;
            currentGroup.add(currentLine);
            if (size == groupSize) {
                totalSum += getBadgeOfGroup(currentGroup);
                currentGroup = new ArrayList<>();
                size = 0;
            }
        }

        System.out.println("Total sum of badges: " + totalSum);
    }

    public static int getBadgeOfGroup(List<String> group) {
        String firstLine = group.get(0);
        char currentChar;
        boolean foundBadge = true;

        for (int i = 0; i < firstLine.length(); i++) {
            currentChar = firstLine.charAt(i);

            for (int j = 1; j < group.size(); j++) {
                if (!group.get(j).contains(Character.toString(currentChar))) {
                    foundBadge = false;
                    break;
                }
            }
            if (foundBadge) {
                return currentChar >= 97 ? currentChar - 96 : currentChar - 38;
            }

            foundBadge = true;
        }
        return 0;
    }
}
