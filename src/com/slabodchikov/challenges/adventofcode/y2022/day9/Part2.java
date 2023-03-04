package com.slabodchikov.challenges.adventofcode.y2022.day9;

import com.slabodchikov.challenges.adventofcode.y2022.utils.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Roman Slabodchikov on 19.12.2022
 */
public class Part2 {

    private static Set<Pair<Integer, Integer>> tailPositions;
    private static List<Pair<Integer, Integer>> rope;

    private static final Integer ROPE_LENGTH = 10;

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day9\\input.txt");
        Scanner scanner = new Scanner(inputData);

        String inputString;

        rope = new ArrayList<>(ROPE_LENGTH);

        for (int i = 0; i < ROPE_LENGTH; i++) {
            Pair<Integer, Integer> knot = new Pair<>(0, 0);
            rope.add(knot);
        }

        tailPositions = new HashSet<>();
        tailPositions.add(rope.get(ROPE_LENGTH - 1));

        while (scanner.hasNext()) {
            inputString = scanner.nextLine();
            move(inputString);
        }
        System.out.println(tailPositions.size());
    }

    private static void move(String input) {
        int movesCount = Integer.parseInt(input.replaceAll("[^0-9]", ""));
        char dir = input.charAt(0);

        while (movesCount > 0) {
            moveHead(dir);
            movesCount--;
        }
    }

    private static void moveHead(char direction) {
        Pair<Integer, Integer> headPos = rope.get(0);
        switch (direction) {
            case 'U':
                headPos = new Pair<>(headPos.left, headPos.right + 1);
                break;
            case 'D':
                headPos = new Pair<>(headPos.left, headPos.right - 1);
                break;
            case 'L':
                headPos = new Pair<>(headPos.left - 1, headPos.right);
                break;
            case 'R':
                headPos = new Pair<>(headPos.left + 1, headPos.right);
                break;
        }
        rope.set(0, headPos);
        moveRope(1);
    }

    private static void moveRope(int knotIndex) {
        // previous knot (index == knotIndex - 1) position
        Pair<Integer, Integer> prevKnotPos = rope.get(knotIndex - 1);
        // selected knot (index == knotIndex) current position
        Pair<Integer, Integer> knotCurrPos = rope.get(knotIndex);

        // new knot (index == knotIndex) position
        Pair<Integer, Integer> newKnotPos;

        // should move knot
        if (Math.abs(prevKnotPos.left - knotCurrPos.left) > 1 || Math.abs(prevKnotPos.right - knotCurrPos.right) > 1) {
            if (knotCurrPos.right.equals(prevKnotPos.right)) {
                if (knotCurrPos.left > prevKnotPos.left) {
                    newKnotPos = new Pair<>(knotCurrPos.left - 1, knotCurrPos.right);
                } else {
                    newKnotPos = new Pair<>(knotCurrPos.left + 1, knotCurrPos.right);
                }
            } else if (knotCurrPos.left.equals(prevKnotPos.left)) {
                if (knotCurrPos.right > prevKnotPos.right) {
                    newKnotPos = new Pair<>(knotCurrPos.left, knotCurrPos.right - 1);
                } else {
                    newKnotPos = new Pair<>(knotCurrPos.left, knotCurrPos.right + 1);
                }
            } else {
                if (knotCurrPos.left > prevKnotPos.left) {
                    if (knotCurrPos.right > prevKnotPos.right) {
                        newKnotPos = new Pair<>(knotCurrPos.left - 1, knotCurrPos.right - 1);
                    } else {
                        newKnotPos = new Pair<>(knotCurrPos.left - 1, knotCurrPos.right + 1);
                    }
                } else {
                    if (knotCurrPos.right > prevKnotPos.right) {
                        newKnotPos = new Pair<>(knotCurrPos.left + 1, knotCurrPos.right - 1);
                    } else {
                        newKnotPos = new Pair<>(knotCurrPos.left + 1, knotCurrPos.right + 1);
                    }
                }
            }
            rope.set(knotIndex, newKnotPos);
            if (knotIndex < rope.size() - 1) {
                moveRope(knotIndex + 1);
            } else if (knotIndex == rope.size() - 1) {
                tailPositions.add(newKnotPos);
            }
        }

    }
}
