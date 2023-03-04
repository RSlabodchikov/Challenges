package com.slabodchikov.challenges.amazon;

import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 02.11.2022
 */
public class ConnectedSets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCasesCount = sc.nextInt();

        int n;
        int[][][] matrixArray = new int[testCasesCount][][];

        for (int i = 0; i < testCasesCount; i++) {
            n = sc.nextInt();
            sc.nextLine();
            matrixArray[i] = readMatrix(n, sc);
        }
        for (int i = 0; i < testCasesCount; i++) {
            System.out.println(calculateSetsCount(matrixArray[i], matrixArray[i].length));
        }
    }

    public static int calculateSetsCount(int[][] matrix, int n) {
        int setsCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    markRelatedCells(n, matrix, i, j);
                    setsCount++;
                }
            }
        }

        return setsCount;
    }

    public static void markRelatedCells(int n, int[][] matrix, int i, int j) {
        matrix[i][j] = -1;

        if (i > 0) {
            if (matrix[i - 1][j] == 1) {
                markRelatedCells(n, matrix, i - 1, j);
            }
            if (j > 0) {
                if (matrix[i - 1][j - 1] == 1) {
                    markRelatedCells(n, matrix, i - 1, j - 1);
                }
            }
            if (j < n - 1) {
                if (matrix[i - 1][j + 1] == 1) {
                    markRelatedCells(n, matrix, i - 1, j + 1);
                }
            }

        }
        if (i < n - 1) {
            if (matrix[i + 1][j] == 1) {
                markRelatedCells(n, matrix, i + 1, j);
            }
            if (j > 0) {
                if (matrix[i + 1][j - 1] == 1) {
                    markRelatedCells(n, matrix, i + 1, j - 1);
                }
            }
            if (j < n - 1) {
                if (matrix[i + 1][j + 1] == 1) {
                    markRelatedCells(n, matrix, i + 1, j + 1);
                }
            }
        }
        if (j > 0) {
            if (matrix[i][j - 1] == 1) {
                markRelatedCells(n, matrix, i, j - 1);
            }
        }
        if (j < n - 1) {
            if (matrix[i][j + 1] == 1) {
                markRelatedCells(n, matrix, i, j + 1);
            }
        }
    }

    public static int[][] readMatrix(int n, Scanner sc) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
    
    
}
