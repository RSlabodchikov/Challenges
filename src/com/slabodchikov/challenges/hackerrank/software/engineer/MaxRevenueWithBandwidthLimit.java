package com.slabodchikov.challenges.hackerrank.software.engineer;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/maximize-stream-revenue-with-bandwidth-limit/problem">Problem</a>
 */
public class MaxRevenueWithBandwidthLimit {

    /*
     * Complete the 'allocateBandwidthMaxRevenue' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. INTEGER_ARRAY sizes
     *  3. INTEGER_ARRAY revenues
     *  4. LONG_INTEGER B
     */

    public static double allocateBandwidthMaxRevenue(int N, List<Integer> sizes, List<Integer> revenues, long B) {

        if (N == 0 || B == 0) {
            return 0.0;
        }
        List<Triplet> densityList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (sizes.get(i) > 0 && revenues.get(i) > 0) {
                densityList.add(new Triplet(sizes.get(i), (double) revenues.get(i) / sizes.get(i), revenues.get(i)));
            }
        }
        densityList.sort((d1, d2) -> (Double.compare(d2.density, d1.density)));
        BigDecimal result = new BigDecimal(0);

        double remainingSize = B;
        for (Triplet density : densityList) {
            double currentSize = density.size;
            if (currentSize > remainingSize) {
                result = result.add(BigDecimal.valueOf(remainingSize * density.density));
            } else {
                result = result.add(BigDecimal.valueOf(density.profit));
                remainingSize -= currentSize;
            }
            if (remainingSize <= 0) {
                break;
            }
        }
        result = result.setScale(1, RoundingMode.HALF_UP);
        return result.doubleValue();
    }

    static class Triplet {
        int size;
        double density;
        int profit;

        public Triplet(int size, double density, int profit) {
            this.density = density;
            this.size = size;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        System.out.println();
        int N = 5;
        List<Integer> sizes = Arrays.asList(5, 10, 15, 22, 25);
        List<Integer> revenues = Arrays.asList(30, 60, 90, 88, 100);
        long B = 70;
        System.out.println(allocateBandwidthMaxRevenue(N, sizes, revenues, B));
    }
}
