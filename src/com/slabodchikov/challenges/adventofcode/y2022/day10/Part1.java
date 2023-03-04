package com.slabodchikov.challenges.adventofcode.y2022.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 19.12.2022
 */
public class Part1 {

    private static final Integer START_CYCLE = 20;
    private static final Integer STEP = 40;
    private static final Integer LAST_CYCLE = 220;

    private static Integer currentCycle = 1;
    private static Integer totalSignalStrength = 0;
    private static Integer currentValue = 1;

    private static final String ADD_COMMAND = "addx .*";

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day10\\input.txt");
        Scanner scanner = new Scanner(inputData);
        String currentLine;

        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            executeCommand(currentLine);
        }
        System.out.println(totalSignalStrength);

    }

    private static void executeCommand(String command) {
        if (currentCycle > LAST_CYCLE) return;
        if (command.matches(ADD_COMMAND)) {
            for (int i = 0; i < 2; i++) {
                if ((currentCycle - START_CYCLE) % STEP == 0) {
                    totalSignalStrength += currentCycle * currentValue;
                }
                currentCycle++;
            }
            currentValue += Integer.parseInt(command.replaceAll("[^\\d-]", ""));
        } else {
            if ((currentCycle - START_CYCLE) % STEP == 0) {
                totalSignalStrength += currentCycle * currentValue;
            }
            currentCycle++;
        }
    }
}
