package com.slabodchikov.challenges.leetcode;

public class Problem11 {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxSize = 0;
        while (left != right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int currentSize = Math.min(leftHeight, rightHeight) * (right - left);
            if (currentSize > maxSize) {
                maxSize = currentSize;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxSize;
    }
}
