package org.home.algo.dp;

import java.util.Arrays;

/**
 * Partition problem is to determine whether a given set can be partitioned into
 * two subsets such that the sum of elements in both subsets is same.
 * <p>
 * Following are the two main steps to solve this problem:
 * 1) Calculate sum of the array. If sum is odd,
 * there can not be two subsets with equal sum, so return false.
 * 2) If sum of array elements is even, calculate sum/2 and
 * find a subset of array with sum equal to sum/2.
 */
public class PartitionProblem {

    private static boolean partitionWithEqualSumRecursiveUtil(int[] arr, int n, int targetSum) {
        //Base case : if targetSum zero then it is true
        if (targetSum == 0) {
            return true;
        }
        //
        if (targetSum != 0 && n == 0) {
            return false;
        }

        //If last sum is greater than target sum then ignore i
        if (targetSum < arr[n - 1]) {
            return partitionWithEqualSumRecursiveUtil(arr, n - 1, targetSum);
        }
        /**Else check that whether the value can be found by the following
         * operations.
         * 1. Include n-1 and search for targetSum-arr[n-1]
         * 2. Don't include n-1 and search for targetSum
         */
        return partitionWithEqualSumRecursiveUtil(arr, n - 1, targetSum) ||
                partitionWithEqualSumRecursiveUtil(arr, n - 1, targetSum - arr[n - 1]);
    }

    /**
     * Let isSubsetSum(arr, n, sum/2) be the function that returns true if
     * there is a subset of arr[0..n-1] with sum equal to sum/2
     * <p>
     * The isSubsetSum problem can be divided into two subproblems
     * a) isSubsetSum() without considering last element
     * (reducing n to n-1)
     * b) isSubsetSum considering the last element
     * (reducing sum/2 by arr[n-1] and n to n-1)
     * If any of the above the above subproblems return true, then return true.
     * isSubsetSum (arr, n, sum/2) = isSubsetSum (arr, n-1, sum/2) ||
     * isSubsetSum (arr, n-1, sum/2 - arr[n-1])
     *
     * @param arr
     * @return
     */
    public static boolean partitionWithEqualSumRecursive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int sum = Arrays.stream(arr).sum();
        //If the sum of the elements in the input array is odd,
        // then it cannot be partitioned in two sets
        if (sum % 2 != 0) {
            return false;
        }
        return partitionWithEqualSumRecursiveUtil(arr, arr.length, sum / 2);
    }

    /**
     * The problem can be solved using dynamic programming when the sum of the
     * elements is not too big.
     * We can create a 2D array part[][] of size (sum/2)*(n+1).
     * And we can construct the solution in bottom up manner such that
     * every filled entry has following property
     * <p>
     * part[i][j] = true if a subset of {arr[0], arr[1], ..arr[j-1]} has sum
     * equal to i, otherwise false
     *
     * @param arr
     * @param n
     * @param targetSum
     * @return
     */
    private static boolean partitionWithEqualSumIterativeUtil(int[] arr, int n, int targetSum) {
        boolean[][] dp = new boolean[targetSum + 1][n + 1];

        // initialize top row as true as targetsum zero
        //Can be composed by any element
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        //Initialize the first column except dp[0][0] as false.
        //As number zero can only produce sum zero. so dp[0][0] is true
        for (int i = 1; i <= targetSum; i++) {
            dp[i][0] = false;
        }

        // Fill the partition table in botton up manner
        for (int i = 1; i <= targetSum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= arr[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
                }

            }
        }
        return dp[targetSum][n];
    }

    public static boolean partitionWithEqualSumIterative(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int sum = Arrays.stream(arr).sum();
        //If the sum of the elements in the input array is odd,
        // then it cannot be partitioned in two sets
        if (sum % 2 != 0) {
            return false;
        }
        return partitionWithEqualSumIterativeUtil(arr, arr.length, sum / 2);
    }


    private static int partitionWithMinAbsDifferenceUtil(int[] arr,
                                                        int i,
                                                        int totalsum,
                                                        int calculated) {
        // If we have reached last element.
        // Sum of one subset is sumCalculated,
        // sum of other subset is sumTotal-
        // sumCalculated.  Return absolute
        // difference of two sums.
        if (i == 0) {
            return Math.abs((totalsum - calculated) - calculated);
        }
        // For every item arr[i], we have two choices
        // (1) We do not include it first set
        // (2) We include it in first set
        // We return minimum of two choices
        return Math.min(
                partitionWithMinAbsDifferenceUtil(arr,
                        i - 1,
                        totalsum,
                        calculated + arr[i]),
                partitionWithMinAbsDifferenceUtil(arr,
                        i - 1,
                        totalsum,
                        calculated)
                );

    }

    /**
     * Given a set of integers, the task is to divide it into two sets
     * S1 and S2 such that the absolute difference
     * between their sums is minimum.
     * If there is a set S with n elements,
     * then if we assume Subset1 has m elements,
     * Subset2 must have n-m elements and the value of
     * abs(sum(Subset1) – sum(Subset2)) should be minimum.
     * @param arr input array
     * @return minimum absolute difference
     */
    public static int partitionWithMinAbsDifference(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return partitionWithMinAbsDifferenceUtil(arr,
                arr.length - 1,
                Arrays.stream(arr).sum(),
                0);
    }

    /**
     * The problem can be solved using dynamic programming when
     * the sum of the elements is not too big.
     * We can create a 2D array dp[n+1][sum+1] where n is
     * number of elements in given set and sum is sum of all elements.
     * We can construct the solution in bottom up manner.
     *
     * The task is to divide the set into two parts.
     * We will consider the following factors for dividing it.
     * Let
     *   dp[n+1][sum+1] = {1 if some subset from 1st to i'th has a sum
     *                       equal to j
     *                    0 otherwise}
     *
     *     i ranges from {1..n}
     *     j ranges from {0..(sum of all elements)}
     *
     * So
     *     dp[n+1][sum+1]  will be 1 if
     *     1) The sum j is achieved including i'th item
     *     2) The sum j is achieved excluding i'th item.
     *
     * Let sum of all the elements be S.
     *
     * To find Minimum sum difference, w have to find j such
     * that Min{sum - j*2  : dp[n][j]  == 1 }
     *     where j varies from 0 to sum/2
     *
     * The idea is, sum of S1 is j and it should be closest
     * to sum/2, i.e., 2*j should be closest to sum.
     * @param arr
     * @return
     */
    public int partitionWithMinAbsDifferenceIterative(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int n = arr.length;
        // Calculate sum of all elements
        int sum = Arrays.stream(arr).sum();

        // Create an array to store
        // results of subproblems
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Initialize first column as true.
        // 0 sum is possible  with all elements.
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // Initialize top row, except dp[0][0],
        // as false. With 0 elements, no other
        // sum except 0 is possible
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        // Fill the partition table
        // in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If i'th element is excluded
                dp[i][j] = dp[i - 1][j];

                // If i'th element is included
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        }

        // Initialize difference of two sums.
        int diff = Integer.MAX_VALUE;

        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 t0 0
        for (int j = sum / 2; j >= 0; j--) {
            // Find the
            if (dp[n][j] == true) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;

    }

}
