package com.slabodchikov.challenges.adventofcode.y2022.day12;

import com.slabodchikov.challenges.adventofcode.y2022.utils.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 21.12.2022
 */
public class Part2 {

    private static final Character START_SYMBOL = 'a';
    private static final List<Character> START_SYMBOLS = List.of('a', 'S');
    private static final Character END_SYMBOL = 'E';

    private static final Map<Pair<Integer, Integer>, Integer> distancesCache = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day12\\input.txt");
        Scanner scanner = new Scanner(inputData);
        String currentLine;

        List<List<Character>> grid = new ArrayList<>();
        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            List<Character> row = new ArrayList<>();
            for (char c : currentLine.toCharArray()) {
                row.add(c);
            }
            grid.add(row);
        }
        System.out.println(findShortestPathReversed(grid));
    }

    public static int findShortestPathReversed(List<List<Character>> grid) {
        List<Pair<Integer, Integer>> startSymbols = new ArrayList<>();
        int endX = 0, endY = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if (grid.get(i).get(j).equals(START_SYMBOL)) {
                    startSymbols.add(new Pair<>(i, j));
                } else if (grid.get(i).get(j).equals(END_SYMBOL)) {
                    endX = i;
                    endY = j;
                }
            }
        }
        findShortestPathReversed(grid, new Pair<>(endX, endY), 0);
        return startSymbols.stream()
            .map(distancesCache::get)
            .filter(Objects::nonNull)
            .min(Integer::compareTo)
            .orElse(-1);
    }

    public static void findShortestPathReversed(List<List<Character>> grid, Pair<Integer, Integer> currentCoordinates, int pathLength) {
        if (distancesCache.containsKey(currentCoordinates) && distancesCache.get(currentCoordinates) <= pathLength) {
            return;
        } else {
            distancesCache.put(currentCoordinates, pathLength);
        }

        Character currentSymbol = grid.get(currentCoordinates.getLeft()).get(currentCoordinates.getRight());
        if (START_SYMBOLS.contains(currentSymbol)) {
            return;
        }

        List<Pair<Integer, Integer>> possibleMoves = getPossibleMoves(grid, currentCoordinates.getLeft(), currentCoordinates.getRight());

        for (Pair<Integer, Integer> possibleMove : possibleMoves) {
            Character nextSymbol = grid.get(possibleMove.getLeft()).get(possibleMove.getRight());
            if (START_SYMBOLS.contains(currentSymbol) && currentSymbol.equals('b')) {
                findShortestPathReversed(grid, possibleMove, pathLength + 1);
            } else if ((!currentSymbol.equals(END_SYMBOL) && currentSymbol - nextSymbol <= 1)
                || (currentSymbol.equals(END_SYMBOL) && nextSymbol.equals('z'))) {
                findShortestPathReversed(grid, possibleMove, pathLength + 1);
            }
        }
    }

    public static List<Pair<Integer, Integer>> getPossibleMoves(List<List<Character>> grid, int x, int y) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        if (x >= 1) {
            pairs.add(new Pair<>(x - 1, y));
        }
        if (x < grid.size() - 1) {
            pairs.add(new Pair<>(x + 1, y));
        }
        if (y >= 1) {
            pairs.add(new Pair<>(x, y - 1));
        }
        if (y < grid.get(x).size() - 1) {
            pairs.add(new Pair<>(x, y + 1));
        }

        return pairs;
    }
}
