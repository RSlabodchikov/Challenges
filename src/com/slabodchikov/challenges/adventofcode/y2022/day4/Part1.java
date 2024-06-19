package com.slabodchikov.challenges.adventofcode.y2022.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Roman Slabodchikov
 */
public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day4\\input.txt");
        Scanner scanner = new Scanner(inputData);

        String currentLine;
        int totalSum = 0;

        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            totalSum += isPairFullyOverlaps(currentLine);
        }

        System.out.println("Total sum: " + totalSum);
    }

    public static Integer isPairFullyOverlaps(String inputLine) {
        List<Integer> segments = Arrays.stream(inputLine.replace('-', ',').split(","))
            .map(Integer::valueOf)
            .toList();
        if (segments.get(0) <= segments.get(2) && segments.get(1) >= segments.get(3)
            || segments.get(0) >= segments.get(2) && segments.get(1) <= segments.get(3)) {
            return 1;
        }

        return 0;
    }
}
