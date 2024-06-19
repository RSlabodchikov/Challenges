package com.slabodchikov.challenges.adventofcode.y2022.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Part2 {

    public static final char CLOSE_BRACKET = ']';
    public static final char OPEN_BRACKET = '[';
    public static final char SEPARATOR = ',';

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day13\\input.txt");
        Scanner scanner = new Scanner(inputData);

        List<List<Object>> packets = new ArrayList<>();
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                packets.add(parseInputLine(input));
            }
        }
        List<Object> marker1 = parseInputLine("[[2]]");
        packets.add(marker1);
        List<Object> marker2 = parseInputLine("[[6]]");
        packets.add(marker2);
        packets.sort(Part2::compareArrays);
        Collections.reverse(packets);
        System.out.println((packets.indexOf(marker1) + 1) * (packets.indexOf(marker2) + 1));
    }

    private static boolean parseAndValidateNextPair(Scanner scanner) {
        String leftLine = scanner.nextLine();
        String rightLine = scanner.nextLine();

        List<Object> left = parseInputLine(leftLine);
        List<Object> right = parseInputLine(rightLine);

        if (scanner.hasNext()) {
            scanner.nextLine();
        }
        return compareArrays(left, right) > 0;
    }

    private static List<Object> parseInputLine(String input) {
        List<Object> result = new ArrayList<>();
        LinkedList<List<Object>> arraysQueue = new LinkedList<>();

        List<Object> currentArray = result;

        char[] charArray = input.toCharArray();
        for (int i = 1; i < charArray.length - 1; i++) {
            char c = charArray[i];
            if (c == OPEN_BRACKET) {
                List<Object> newArray = new ArrayList<>();
                currentArray.add(newArray);
                arraysQueue.addLast(currentArray);

                currentArray = newArray;
            } else if (c == CLOSE_BRACKET) {
                currentArray = arraysQueue.removeLast();
            } else if (c != SEPARATOR) {
                int newNumber = 0;
                while (c >= '0' && c <= '9') {
                    newNumber = newNumber * 10 + (c - '0');
                    i++;
                    c = charArray[i];
                }
                i--;
                currentArray.add(newNumber);
            }
        }

        return result;
    }

    private static int compareArrays(List<Object> left, List<Object> right) {
        for (int i = 0; i < left.size(); i++) {
            if (right.size() - 1 < i) {
                return -1;
            }
            Object leftObject = left.get(i);
            Object rightObject = right.get(i);
            if (leftObject instanceof Integer && rightObject instanceof Integer) {
                if ((int) leftObject > (int) rightObject) {
                    return -1;
                } else if ((int) leftObject < (int) rightObject) {
                    return 1;
                }
                continue;
            } else if (leftObject instanceof Integer) {
                leftObject = List.of(leftObject);
            } else if (rightObject instanceof Integer) {
                rightObject = List.of(rightObject);
            }
            int res = compareArrays((List<Object>) leftObject, (List<Object>) rightObject);
            if (res != 0) {
                return res;
            }
        }
        return right.size() - left.size();
    }
}
