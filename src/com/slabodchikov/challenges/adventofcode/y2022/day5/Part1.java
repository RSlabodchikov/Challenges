package com.slabodchikov.challenges.adventofcode.y2022.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 12.12.2022
 */
public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day5\\input.txt");
        Scanner scanner = new Scanner(inputData);

        Map<Integer, LinkedList<Character>> stacks = new HashMap<>();
        String currentLine;

        // parse initial stack structure
        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            if (currentLine.isEmpty()) {
                break;
            } else {
                parseConfigLine(currentLine, stacks);
            }
        }

        scanner.useDelimiter("[^\\d]+");
        // 
        while (scanner.hasNextInt()) {
            performRearrangement(stacks, scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        stacks.values().forEach(stack -> System.out.print(stack.peek()));
    }

    public static void performRearrangement(Map<Integer, LinkedList<Character>> stacks, int blocksCount, int stackNumber, int newStackNumber) {
        while (blocksCount > 0) {
            blocksCount--;
            stacks.get(newStackNumber).addFirst(stacks.get(stackNumber).removeFirst());
        }
    }

    public static void parseConfigLine(String line, Map<Integer, LinkedList<Character>> stacks) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                int stackNumber = i / 4 + 1;
                if (stacks.containsKey(stackNumber)) {
                    stacks.get(stackNumber).add(line.charAt(i));
                } else {
                    LinkedList<Character> newStack = new LinkedList<>();
                    newStack.add(line.charAt(i));
                    stacks.put(stackNumber, newStack);
                }
            }
        }
    }

}
