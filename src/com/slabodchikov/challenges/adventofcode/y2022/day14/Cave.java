package com.slabodchikov.challenges.adventofcode.y2022.day14;

import com.slabodchikov.challenges.adventofcode.y2022.utils.Pair;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov on 22.12.2022
 */
public class Cave {

    private static final Character EMPTY_BLOCK = '.';
    private static final Character SAND_BLOCK = 'O';
    private static final Character ROCK_BLOCK = '#';

    private static final Integer GRID_SIZE = 1000;

    private static final Pair<Integer, Integer> startPos = Pair.of(500, 0);

    protected char[][] blocks;

    private Integer sandBlocksCount = 0;

    public Cave() {
        this.blocks = new char[GRID_SIZE][GRID_SIZE];
        for (char[] blocksRow : blocks) {
            Arrays.fill(blocksRow, EMPTY_BLOCK);
        }
    }

    public void addRocks(Pair<Integer, Integer> startPos, Pair<Integer, Integer> endPos) {
        addBlocks(startPos, endPos, ROCK_BLOCK);
    }

    /**
     * Method to add new sand block in case (if possible)
     *
     * @return true if new sand block added to cave, otherwise - false
     */
    public boolean addSandBlock() {
        int i = startPos.left;
        int j = startPos.right;
        while (i > 1 && i < GRID_SIZE - 1 && j < GRID_SIZE - 1) {
            // check next down tile
            if (blocks[i][j + 1] == EMPTY_BLOCK) {
                j++;
                continue;
            }
            // check left diagonal
            if (blocks[i - 1][j + 1] == EMPTY_BLOCK) {
                j++;
                i--;
                continue;
            }
            // check right diagonal
            if (blocks[i + 1][j + 1] == EMPTY_BLOCK) {
                j++;
                i++;
                continue;
            }
            if (j <= GRID_SIZE - 2 && blocks[i][j] == EMPTY_BLOCK) {
                blocks[i][j] = SAND_BLOCK;
//                System.out.println(i + " " + j);
                sandBlocksCount++;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void addFloor() {
        int maxRockY = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (blocks[i][j] == ROCK_BLOCK && maxRockY < j) {
                    maxRockY = j;
                }
            }
        }
        addRocks(Pair.of(0, maxRockY + 2), Pair.of(GRID_SIZE - 1, maxRockY + 2));
    }

    public void addBlocks(Pair<Integer, Integer> startPos, Pair<Integer, Integer> endPos, char block) {
        if (startPos.left.equals(endPos.left)) {
            for (int i = Math.min(startPos.right, endPos.right); i <= Math.max(startPos.right, endPos.right); i++) {
                blocks[startPos.left][i] = block;
            }
        } else if (endPos.right.equals(startPos.right)) {
            for (int i = Math.min(startPos.left, endPos.left); i <= Math.max(startPos.left, endPos.left); i++) {
                blocks[i][startPos.right] = block;
            }
        }
    }

    public Integer getSandBlocksCount() {
        return sandBlocksCount;
    }
}
