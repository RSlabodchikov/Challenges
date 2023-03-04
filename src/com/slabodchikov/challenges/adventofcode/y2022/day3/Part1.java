package com.slabodchikov.challenges.adventofcode.y2022.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Roman Slabodchikov on 12.12.2022
 */
public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day3\\input.txt");
        Scanner scanner = new Scanner(inputData);

        String currentLine;
        int totalSum = 0;

        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            totalSum += getSumOfRecurringSymbols(currentLine);
        }

        System.out.println("Total sum: " + totalSum);
    }

    public static int getSumOfRecurringSymbols(String inputLine) {
        int sum = 0;
        int term;
        Set<Character> recurringSymbols = new HashSet<>();
        String secondPart = inputLine.substring(inputLine.length() / 2);
        char currentChar;
        for (int i = 0; i < inputLine.length() / 2; i++) {
            currentChar = inputLine.charAt(i);
            if (!recurringSymbols.contains(currentChar) && secondPart.contains(Character.toString(currentChar))) {
                recurringSymbols.add(currentChar);
                term = currentChar >= 97 ? currentChar - 96 : currentChar - 38;
                sum += term;
            }
        }
        return sum;
    }
}
