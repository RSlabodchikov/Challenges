package com.slabodchikov.challenges.adventofcode.y2022.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day1\\input.txt");
        Scanner scanner = new Scanner(inputData);
        int maxCalories = 0;
        String currentLine;
        int currentValue = 0;
        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            if (currentLine.isEmpty()) {
                if (currentValue > maxCalories) {
                    maxCalories = currentValue;
                }
                currentValue = 0;
            } else {
                currentValue += Integer.parseInt(currentLine);
            }
        }
        System.out.println(maxCalories);
    }
}
