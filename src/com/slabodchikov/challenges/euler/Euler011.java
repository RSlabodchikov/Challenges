package com.slabodchikov.challenges.euler;

import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 04.11.2022
 */
public class Euler011 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for (int grid_i = 0; grid_i < 20; grid_i++) {
            for (int grid_j = 0; grid_j < 20; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        long maxProduct = calculateMaxProductInColumn(grid, 20);
        maxProduct = Math.max(maxProduct, calculateMaxProductInRow(grid, 20));
        maxProduct = Math.max(maxProduct, calculateMaxProductInLeftDiagonal(grid, 20));
        maxProduct = Math.max(maxProduct, calculateMaxProductInRightDiagonal(grid, 20));

        System.out.println(maxProduct);
    }

    public static long calculateMaxProductInRow(int[][] grid, int n) {
        long maxProduct = 0;
        long currentProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - 4; j += 1) {
                if (currentProduct == 0) {
                    currentProduct = (long) grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3];
                } else {
                    if (grid[i][j - 1] == 0) {
                        continue;
                    }
                    currentProduct = currentProduct / grid[i][j - 1] * grid[i][j + 3];
                }
                if (currentProduct > maxProduct) {
                    maxProduct = currentProduct;
                }
            }
            currentProduct = 0;
        }

        return maxProduct;
    }

    public static long calculateMaxProductInColumn(int[][] grid, int n) {
        long maxProduct = 0;
        long currentProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - 4; j += 1) {
                if (currentProduct == 0) {
                    currentProduct = (long) grid[j][i] * grid[j + 1][i] * grid[j + 2][i] * grid[j + 3][i];
                } else {
                    if (grid[j - 1][i] == 0) {
                        continue;
                    }
                    currentProduct = currentProduct / grid[j - 1][i] * grid[j + 3][i];
                }
                if (currentProduct > maxProduct) {
                    maxProduct = currentProduct;
                }
            }
            currentProduct = 0;
        }

        return maxProduct;
    }

    public static long calculateMaxProductInLeftDiagonal(int[][] grid, int n) {
        long maxProduct = 0;
        long currentProduct;
        for (int i = 0; i <= n - 4; i++) {
            for (int j = 0; j <= n - 4; j += 1) {
                currentProduct = (long) grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3];
                if (currentProduct > maxProduct) {
                    maxProduct = currentProduct;
                }
            }
        }

        return maxProduct;
    }

    public static long calculateMaxProductInRightDiagonal(int[][] grid, int n) {
        long maxProduct = 0;
        long currentProduct;
        for (int i = 3; i <= n - 1; i++) {
            for (int j = 0; j <= n - 4; j += 1) {
                currentProduct = (long) grid[i][j] * grid[i - 1][j + 1] * grid[i - 2][j + 2] * grid[i - 3][j + 3];
                if (currentProduct > maxProduct) {
                    maxProduct = currentProduct;
                }
            }
        }

        return maxProduct;
    }
}
