package com.slabodchikov.challenges.euler;

import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 22.11.2022
 */
public class Euler036 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        
        long sum=0;

        for (int j = 1; j < n; j++) {
            if (isPalindrome(j, 10) && isPalindrome(j, k)) {
                sum+=j;
            }
        }

        System.out.println(sum);
    }

    public static boolean isPalindrome(int number, int base) {
        String stringNumber = Integer.toString(number, base);

        int length = stringNumber.length();

        for (int i = 0; i < length / 2; i++) {
            if (stringNumber.charAt(i) != stringNumber.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
