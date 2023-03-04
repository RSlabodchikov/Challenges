package com.slabodchikov.challenges.adventofcode.y2022.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 16.12.2022
 */
public class Part2 {

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
        System.out.println(getHighestScenicScore(grid));
    }

    // grid must have rows of same size
    private static int getHighestScenicScore(List<List<Integer>> grid) {
        int maxScore = 0;

        for (int i = 1; i < grid.size() - 1; i++) {

            for (int j = 1; j < grid.get(i).size() - 1; j++) {
                int currentHeight = grid.get(i).get(j);
                // get left score
                int leftScore = 0;
                int k = j - 1;
                while (k >= 0) {
                    leftScore++;
                    if (currentHeight <= grid.get(i).get(k)) {
                        break;
                    }
                    k--;
                }
                if (leftScore == 0) {
                    leftScore = 1;
                }

                // get right score
                int rightScore = 0;
                k = j + 1;
                while (k < grid.get(i).size()) {
                    rightScore++;
                    if (currentHeight <= grid.get(i).get(k)) {
                        break;
                    }
                    k++;
                }
                if (rightScore == 0) {
                    rightScore = 1;
                }

                // get top score
                int topScore = 0;
                k = i - 1;
                while (k >= 0) {
                    topScore++;
                    if (currentHeight <= grid.get(k).get(j)) {
                        break;
                    }
                    k--;
                }
                if (topScore == 0) {
                    topScore = 1;
                }

                // get bottom score
                int bottomScore = 0;
                k = i + 1;
                while (k < grid.size()) {
                    bottomScore++;
                    if (currentHeight <= grid.get(k).get(j)) {
                        break;
                    }
                    k++;
                }
                if (bottomScore == 0) {
                    bottomScore = 1;
                }

                int currentScore = leftScore * rightScore * bottomScore * topScore;
                if (currentScore > maxScore) {
                    maxScore = currentScore;
                }
            }
        }

        return maxScore;
    }
}
