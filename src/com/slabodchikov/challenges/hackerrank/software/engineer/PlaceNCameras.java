package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/place-n-cameras-no-conflict-blocked-grid/problem">Problem</a>
 */
public class PlaceNCameras {

    /*
     * Complete the 'canPlaceSecurityCameras' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. 2D_INTEGER_ARRAY grid
     */

    public static boolean canPlaceSecurityCameras(int N, List<List<Integer>> grid) {
        boolean[] rowsOccupied = new boolean[N];
        boolean[] diagonalsOccupied = new boolean[2 * N];
        boolean[] antiDiagonalsOccupied = new boolean[2 * N];

        return canPlace(N, grid, rowsOccupied, diagonalsOccupied, antiDiagonalsOccupied, 0);
    }

    public static boolean canPlace(
        int N,
        List<List<Integer>> grid,
        boolean[] rowsOccupied,
        boolean[] diagonalOccupied,
        boolean[] antiDiagonalsOccupied,
        int column) {
        if (column == N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (grid.get(i).get(column) == 1) {
                continue;
            }
            int diagIndex = N + 1 + column - i;
            int antiDiagIndex = i + column;
            if (!rowsOccupied[i] && !diagonalOccupied[diagIndex] && !antiDiagonalsOccupied[antiDiagIndex]) {
                rowsOccupied[i] = true;
                diagonalOccupied[diagIndex] = true;
                antiDiagonalsOccupied[antiDiagIndex] = true;

                if (canPlace(N, grid, rowsOccupied, diagonalOccupied, antiDiagonalsOccupied, column + 1)) {
                    return true;
                }
                rowsOccupied[i] = false;
                diagonalOccupied[diagIndex] = false;
                antiDiagonalsOccupied[antiDiagIndex] = false;
            }
        }
        return false;
    }
}
