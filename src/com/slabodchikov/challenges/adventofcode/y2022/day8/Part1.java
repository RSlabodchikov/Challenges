package com.slabodchikov.challenges.adventofcode.y2022.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 16.12.2022
 */
public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day8\\input.txt");
        Scanner scanner = new Scanner(inputData);

        String inputLine;
        List<List<Integer>> grid = new ArrayList<>();

        // read input
        while (scanner.hasNext()) {
            inputLine = scanner.nextLine();

            List<Integer> row = new ArrayList<>();
            for (char ch : inputLine.toCharArray()) {
                row.add((ch - '0'));
            }
            grid.add(row);
        }
        System.out.println(getNumberOfVisibleTrees(grid));
    }

    // grid must have rows of same size
    private static int getNumberOfVisibleTrees(List<List<Integer>> grid) {
        int totalCount = grid.get(0).size() * 2;

        for (int i = 1; i < grid.size() - 1; i++) {
            int maxNumberInRowFromLeft = grid.get(i).get(0);
            List<Integer> row = grid.get(i);
            for (int j = 0; j < row.size(); j++) {
                // check if tree is on the edge
                if (j == 0 || j == row.size() - 1) {
                    totalCount++;
                    continue;
                }
                // check if tree is visible from the left side
                if (grid.get(i).get(j) > maxNumberInRowFromLeft) {
                    totalCount++;
                    maxNumberInRowFromLeft = row.get(j);
                    continue;
                }
                // check if tree is visible from the right side
                boolean isVisible = true;
                for (int k = row.size() - 1; k > j; k--) {
                    if (row.get(j) <= row.get(k)) {
                        isVisible = false;
                        break;
                    }
                }
                if (isVisible) {
                    totalCount++;
                    continue;
                }
                // check if tree is visible from the top
                isVisible = true;
                for (int k = 0; k < i; k++) {
                    if (grid.get(k).get(j) >= grid.get(i).get(j)) {
                        isVisible = false;
                        break;
                    }
                }
                if (isVisible) {
                    totalCount++;
                    continue;
                }
                // check if tree is visible from the bottom
                isVisible = true;
                for (int k = i + 1; k < grid.size(); k++) {
                    if (grid.get(k).get(j) >= grid.get(i).get(j)) {
                        isVisible = false;
                        break;
                    }
                }
                if (isVisible) {
                    totalCount++;
                }
            }
        }

        return totalCount;
    }
}
