package org.home.algo.dp;

import java.util.Arrays;

/**
 * Given a n*n matrix where all numbers are distinct,
 * find the maximum length path (starting from any cell)
 * such that all cells along the path are in increasing order with a difference of 1.
 * <p>
 * We can move in 4 directions from a given cell (i, j), i.e.,
 * we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1)
 * with the condition that the adjacent cells have a difference of 1.
 * <p>
 * Input:  mat[][] = {{1, 2, 9}
 *                    {5, 3, 8}
 *                    {4, 6, 7}}
 * Output: 4
 * The longest path is 6-7-8-9.
 */
public class LongestPathInASquareMatrix {

    private static int findLongestPathInSquareMatrixUtil(int i,
                                                         int j,
                                                         int mat[][],
                                                         int[][] dp,
                                                         int n) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i > 0 && mat[i][j] + 1 == mat[i - 1][j]) {
            return dp[i][j] = 1 + findLongestPathInSquareMatrixUtil(i-1, j, mat, dp,n);
        }else if(i<n-1 && mat[i][j] +1 == mat[i+1][j]){
            return dp[i][j] = 1 + findLongestPathInSquareMatrixUtil(i+1,j,mat,dp,n);
        }else if(j>0 && mat[i][j] +1 == mat[i][j-1]){
            return dp[i][j] = 1 + findLongestPathInSquareMatrixUtil(i,j-1,mat,dp,n);
        }else if(j<n-1 && mat[i][j] +1 == mat[i][j+1]){
            return dp[i][j] = 1 + findLongestPathInSquareMatrixUtil(i,j+1,mat,dp,n);
        }

        return dp[i][j]=1;
    }

    public static int findLongestPathInSquareMatrix(int[][] input,int n){
        if(input == null || input.length == 0 || n==0){
            return -1;
        }
        int maxLength = Integer.MIN_VALUE;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j] == -1){
                    dp[i][j] = findLongestPathInSquareMatrixUtil(i,j,input, dp, n);
                    maxLength = Math.max(dp[i][j],maxLength);
                }
               // printMatrix(dp,n,i,j);
            }
        }

        return maxLength;
    }


    private static void printMatrix(int[][] dp, int n, int i, int j){
        System.out.println(" Dp at iteration i = "+i+" j = "+j);
        for(int k=0;k<n;k++){
            System.out.println("");
            for(int l=0;l<n;l++){
                System.out.print(dp[i][j]+" ");
            }
        }
        System.out.println("\n");
    }
}
