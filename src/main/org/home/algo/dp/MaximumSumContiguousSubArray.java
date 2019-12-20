package org.home.algo.dp;

import java.util.Arrays;

public class MaximumSumContiguousSubArray {

    public static int getMSCSA(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] M = new int[A.length];
        Arrays.fill(M, 0);

        M[0] = A[0];

        int maxSum = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > M[i - 1] + A[i]) {
                M[i] = A[i];
            } else {
                M[i] = M[i - 1] + A[i];
            }

            if (M[i] > maxSum) {
                maxSum = M[i];
            }
        }

        return maxSum;
    }

    public static int getMSCSAKadane(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        //Kadane's algo return 0 if all the array elements are negative.
        //Need to validate this condition

        int maxSoFar = Integer.MIN_VALUE;
        boolean allNegative = true;
        for (int x : A) {
            if (x >= 0) {
                allNegative = false;
            } else {
                if (x > maxSoFar) {
                    maxSoFar = x;
                }
            }
        }
        if (allNegative) {
            return maxSoFar;
        }
        maxSoFar = 0;
        int maxFoundTillNow = 0;

        for (int x : A) {
            maxFoundTillNow += x;
            if (maxFoundTillNow < 0) {
                maxFoundTillNow = 0;
            }
            if (maxSoFar < maxFoundTillNow) {
                maxSoFar = maxFoundTillNow;
            }
        }
        return maxSoFar;
    }
}
