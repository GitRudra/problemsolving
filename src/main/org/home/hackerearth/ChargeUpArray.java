package org.home.hackerearth;

import java.util.Arrays;

public class ChargeUpArray {

    public static final long BIGINT = (long) Math.pow(10, 9) + 7;

    static int solveChargeUpArray(long[] A, int N) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long numberOfSubset = (long) Math.pow(2, N - 1);
        long totalCharge = 0;
        long total = Arrays.stream(A).parallel().filter(e -> e >= numberOfSubset).sum();
        for (int i = 0; i < N; i++) {
            if (A[i] >= numberOfSubset) {
                totalCharge += A[i];
            }
        }
        return (int) (totalCharge % BIGINT);


    }
}
