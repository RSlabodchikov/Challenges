package com.slabodchikov.challenges.leetcode;

import java.util.Arrays;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self/description/">Problem 238</a>
 */
public class Problem238 {

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        Arrays.fill(products, 1);
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            products[i] = products[i] * product;
            product *= nums[i];
        }
        product = 1;
        for (int j = nums.length - 1; j != -1; j--) {
            products[j] *= product;
            product *= nums[j];
        }

        return products;
    }
}
