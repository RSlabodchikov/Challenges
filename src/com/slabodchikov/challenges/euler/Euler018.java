package com.slabodchikov.challenges.euler;

import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 14.11.2022
 */
public class Euler018 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int[] results = new int[t];

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int[][] triangle = new int[n][];
            int[] row;

            for (int j = 0; j < n; j++) {
                row = new int[j + 1];
                for (int k = 0; k <= j; k++) {
                    row[k] = in.nextInt();
                }
                triangle[j] = row;
            }
            results[i] = getMaxTriangleSum(triangle, n);

        }

        for (int result : results) {
            System.out.println(result);
        }
    }

    public static int getMaxTriangleSum(int[][] triangle, int n) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < triangle[i].length - 1; j++) {
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
        }
        return triangle[0][0];
    }
}
