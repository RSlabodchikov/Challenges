package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/can-place-flowers/description/">Problem 605</a>
 */
public class Problem605 {

    public static void main(String[] args) {

        int[] flowerBed = {0, 0, 1, 0, 1};
        int n = 1;

        System.out.println(canPlaceFlowers(flowerBed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int totalLength = flowerbed.length;
        if (n > (totalLength / 2 + 1)) {
            return false;
        }
        int flowerPlaces = 0;
        for (int i = 0; flowerPlaces < n && i < totalLength; i++) {
            if (flowerbed[i] == 0 && isValidPlace(i, flowerbed)) {
                flowerPlaces++;
                // flowerbed[i] = 1;
                i++;
            }
        }
        return flowerPlaces >= n;
    }

    public static boolean isValidPlace(int i, int[] flowerbed) {

        if (flowerbed.length == 1 && i == 0) {
            return true;
        }
        if (i == 0) {
            return flowerbed[1] == 0;
        } else if (i == flowerbed.length - 1) {
            return flowerbed[flowerbed.length - 2] == 0;
        } else {
            return flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0;
        }
    }
}
