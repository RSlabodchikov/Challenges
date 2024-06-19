package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/divide-two-integers/description/"></a>
 */
public class Problem29 {

    public static void main(String[] args) {
        System.out.println(divide(-5, 2));
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(10, 3));
    }

    public static int divide(int dividend, int divisor) {
        long quotient;

        long lDividend = dividend;
        long lDivisor = divisor;

        int sign = 1;
        if (lDividend < 0) {
            sign = -sign;
            lDividend = -lDividend;
        }
        if (lDivisor < 0) {
            sign = -sign;
            lDivisor = -lDivisor;
        }

        quotient = positiveDivide(lDividend, lDivisor);
        quotient = sign > 0 ? quotient : -quotient;
        if (quotient >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (quotient <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) quotient;

    }

    public static long positiveDivide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long buf = divisor;
        long quotient = 1;
        while (dividend > buf + buf) {
            buf = buf + buf;
            quotient = quotient + quotient;
        }
        quotient += positiveDivide(dividend - buf, divisor);
        return quotient;
    }
}
