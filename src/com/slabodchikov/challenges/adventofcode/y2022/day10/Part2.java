package com.slabodchikov.challenges.adventofcode.y2022.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 19.12.2022
 */
public class Part2 {

    private static final Integer SCREEN_WIDTH = 40;
    private static final Integer SCREEN_HEIGHT = 6;
    private static final Integer LAST_CYCLE = 240;

    private static Integer currentCycle = 1;
    private static Integer currentValue = 1;

    private static final String ADD_COMMAND = "addx .*";

    private static final List<List<Character>> screen = new ArrayList<>(6);

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day10\\input.txt");
        Scanner scanner = new Scanner(inputData);
        String currentLine;

        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            screen.add(new ArrayList<>());
        }

        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            executeCommand(currentLine);
        }
        screen.forEach(row -> {
            row.forEach(System.out::print);
            System.out.print("\n");
        });

    }

    private static void executeCommand(String command) {
        if (currentCycle > LAST_CYCLE) return;
        if (command.matches(ADD_COMMAND)) {
            for (int i = 0; i < 2; i++) {
                if (Math.abs(currentValue - (currentCycle % 40) + 1) <= 1) {
                    screen.get((currentCycle - 1) / SCREEN_WIDTH).add('#');
                } else {
                    screen.get((currentCycle - 1) / SCREEN_WIDTH).add('.');
                }
                currentCycle++;
            }
            currentValue += Integer.parseInt(command.replaceAll("[^\\d-]", ""));
        } else {
            if (Math.abs(currentValue - (currentCycle % 40) + 1) <= 1) {
                screen.get((currentCycle - 1) / SCREEN_WIDTH).add('#');
            } else {
                screen.get((currentCycle - 1) / SCREEN_WIDTH).add('.');
            }
            currentCycle++;
        }
    }
}
