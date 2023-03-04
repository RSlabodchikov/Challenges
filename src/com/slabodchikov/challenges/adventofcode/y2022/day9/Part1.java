package com.slabodchikov.challenges.adventofcode.y2022.day9;

import com.slabodchikov.challenges.adventofcode.y2022.utils.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Roman Slabodchikov on 19.12.2022
 */
public class Part1 {

    private static Pair<Integer, Integer> headPos;
    private static Pair<Integer, Integer> tailPos;

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day9\\input.txt");
        Scanner scanner = new Scanner(inputData);

        String inputString;

        headPos = new Pair<>(0, 0);
        tailPos = new Pair<>(0, 0);

        Set<Pair<Integer, Integer>> tailPositions = new HashSet<>();
        tailPositions.add(tailPos);

        while (scanner.hasNext()) {
            inputString = scanner.nextLine();
            makeMove(inputString, tailPositions);
        }
        System.out.println(tailPositions.size());
    }

    private static void makeMove(String input, Set<Pair<Integer, Integer>> tailPositions) {
        Pair<Integer, Integer> newTailPos;
        int movesCount = Integer.parseInt(input.replaceAll("[^0-9]", ""));
        while (movesCount > 0) {
            switch (input.charAt(0)) {
                case 'U' -> headPos = new Pair<>(headPos.left, headPos.right + 1);
                case 'D' -> headPos = new Pair<>(headPos.left, headPos.right - 1);
                case 'L' -> headPos = new Pair<>(headPos.left - 1, headPos.right);
                case 'R' -> headPos = new Pair<>(headPos.left + 1, headPos.right);
            }

            // should move tail
            if (Math.abs(tailPos.left - headPos.left) > 1 || Math.abs(tailPos.right - headPos.right) > 1) {

                if (tailPos.right.equals(headPos.right)) {
                    if (tailPos.left > headPos.left) {
                        newTailPos = new Pair<>(tailPos.left - 1, tailPos.right);
                    } else {
                        newTailPos = new Pair<>(tailPos.left + 1, tailPos.right);
                    }
                } else if (tailPos.left.equals(headPos.left)) {
                    if (tailPos.right > headPos.right) {
                        newTailPos = new Pair<>(tailPos.left, tailPos.right - 1);
                    } else {
                        newTailPos = new Pair<>(tailPos.left, tailPos.right + 1);
                    }
                } else {
                    if (Math.abs(tailPos.left - headPos.left) == 1) {
                        if (tailPos.right > headPos.right) {
                            newTailPos = new Pair<>(headPos.left, tailPos.right - 1);
                        } else {
                            newTailPos = new Pair<>(headPos.left, tailPos.right + 1);
                        }
                    } else {
                        if (tailPos.left > headPos.left) {
                            newTailPos = new Pair<>(tailPos.left - 1, headPos.right);
                        } else {
                            newTailPos = new Pair<>(tailPos.left + 1, headPos.right);
                        }
                    }
                }
                tailPositions.add(newTailPos);
                tailPos = newTailPos;
            }
            movesCount--;
        }

    }
}
