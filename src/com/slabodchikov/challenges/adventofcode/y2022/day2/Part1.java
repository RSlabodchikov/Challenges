package com.slabodchikov.challenges.adventofcode.y2022.day2;

import com.slabodchikov.challenges.adventofcode.y2022.utils.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov
 */
public class Part1 {

    private static final Map<Character, Integer> symbolPoints = new HashMap<>();
    private static final Map<Pair<Character, Character>, Integer> gameResults = new HashMap<>();

    static {
        symbolPoints.put('X', 1);
        symbolPoints.put('Y', 2);
        symbolPoints.put('Z', 3);

        gameResults.put(new Pair<>('A', 'X'), 3);
        gameResults.put(new Pair<>('A', 'Y'), 6);
        gameResults.put(new Pair<>('A', 'Z'), 0);

        gameResults.put(new Pair<>('B', 'X'), 0);
        gameResults.put(new Pair<>('B', 'Y'), 3);
        gameResults.put(new Pair<>('B', 'Z'), 6);

        gameResults.put(new Pair<>('C', 'X'), 6);
        gameResults.put(new Pair<>('C', 'Y'), 0);
        gameResults.put(new Pair<>('C', 'Z'), 3);
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

    public static int getRoundPoint(String input) throws RuntimeException {
        int result = 0;
        char opponentSymbol = input.charAt(0);
        char yourSymbol = input.charAt(2);

        result += symbolPoints.get(yourSymbol);
        result += gameResults.get(new Pair<>(opponentSymbol, yourSymbol));

        return result;
    }
}
