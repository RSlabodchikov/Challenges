package com.slabodchikov.challenges.adventofcode.y2022.day14;

import com.slabodchikov.challenges.adventofcode.y2022.utils.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 22.12.2022
 */
public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day14\\input.txt");
        Scanner scanner = new Scanner(inputData);

        Cave cave = new Cave();

        String currentInput;
        while (scanner.hasNext()) {
            currentInput = scanner.nextLine();
            String[] rocksPos = currentInput.split(" -> ");
            for (int i = 0; i < rocksPos.length - 1; i++) {
                String[] rockPos = rocksPos[i].split(",");
                String[] nextRockPos = rocksPos[i + 1].split(",");

                cave.addRocks(Pair.of(
                    Integer.parseInt(rockPos[0]), Integer.parseInt(rockPos[1])),
                    Pair.of(Integer.parseInt(nextRockPos[0]), Integer.parseInt(nextRockPos[1])));
            }
        }
        cave.addFloor();
        while (true) {
            if (!cave.addSandBlock()) break;
        }
        System.out.println(cave.getSandBlocksCount());
    }
}
