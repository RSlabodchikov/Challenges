package com.slabodchikov.challenges.adventofcode.y2022.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day1\\input.txt");
        Scanner scanner = new Scanner(inputData);

        List<Integer> caloriesByElf = new ArrayList<>();

        String currentLine;
        int currentValue = 0;
        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            if (currentLine.isEmpty()) {
                caloriesByElf.add(currentValue);
                currentValue = 0;
            } else {
                currentValue += Integer.parseInt(currentLine);
            }
        }
        caloriesByElf.sort(Integer::compareTo);
        System.out.println("Sum of top 3 elfs: " + caloriesByElf.stream()
            .skip(caloriesByElf.size() - 3)
            .reduce(0, Integer::sum));
    }
}
