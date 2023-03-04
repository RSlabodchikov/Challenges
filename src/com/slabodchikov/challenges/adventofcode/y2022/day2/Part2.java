package com.slabodchikov.challenges.adventofcode.y2022.day2;

import com.slabodchikov.challenges.adventofcode.y2022.utils.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 02.12.2022
 */
public class Part2 {

    private static final Map<Pair<Character, Character>, Integer> gameResults = new HashMap<>();

    static {
        gameResults.put(new Pair<>('A', 'X'), 3);
        gameResults.put(new Pair<>('A', 'Y'), 4);
        gameResults.put(new Pair<>('A', 'Z'), 8);

        gameResults.put(new Pair<>('B', 'X'), 1);
        gameResults.put(new Pair<>('B', 'Y'), 5);
        gameResults.put(new Pair<>('B', 'Z'), 9);

        gameResults.put(new Pair<>('C', 'X'), 2);
        gameResults.put(new Pair<>('C', 'Y'), 6);
        gameResults.put(new Pair<>('C', 'Z'), 7);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day2\\input.txt");
        Scanner scanner = new Scanner(inputData);

        String currentLine;
        int totalResult = 0;

        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            totalResult += getRoundPoint(currentLine);
        }

        System.out.println("Total points: " + totalResult);
    }

    public static int getRoundPoint(String input) {
        char opponentSymbol = input.charAt(0);
        char yourSymbol = input.charAt(2);

        return gameResults.get(new Pair<>(opponentSymbol, yourSymbol));
    }
}
