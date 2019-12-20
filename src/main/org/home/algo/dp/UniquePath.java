package org.home.algo.dp;


import java.util.Arrays;

public class UniquePath {

    /**
     * A robot is located at the top-left corner of a m x n grid
     * (marked 'Start' in the diagram below).
     * <p>
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid
     * (marked 'Finish' in the diagram below).
     * <p>
     * How many possible unique paths are there?
     */
    public int uniquePaths(int m, int n) throws Exception {
        if (m < 0 || n < 0) {
            throw new Exception("invalid Input exception");
        }
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return Math.max(m, n);
        }
        int[][] pathMatrix = new int[m][n];

        //To reach any cell by top row has only one option
        //right->right...right->right
        /*for(int i = 0;i<n;i++){
            pathMatrix[0][i] = 1;
        }*/

        //To reach any cell by first column has only one option
        //down->down .... down->down
       /* for(int i=0;i<m;i++){
            pathMatrix[i][0] = 1;
        }*/

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pathMatrix[i][j] = 1;
                } else {
                    pathMatrix[i][j] = pathMatrix[i - 1][j] + pathMatrix[i][j - 1];
                }

            }
        }
        return pathMatrix[m - 1][n - 1];
    }

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * <p>
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * <p>
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * <p>
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * <p>
     * Input:
     * [           obstaclePathMatrix
     * [0,0,0],   [1,1,1]
     * [0,1,0],   [1,0,1]
     * [0,0,0]    [1,1,2]
     * ]
     * Output: 2
     * Explanation:
     * There is one obstacle in the middle of the 3x3 grid above.
     * There are two ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down -> Down
     * 2. Down -> Down -> Right -> Right
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) throws Exception {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            throw new Exception("Invalid Input !!!");
        }
        //If the start is an obstacle then we cannot move any where.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] obstaclePathMatrix = new int[m][n];

        //Initialize the array with 0
        for(int i=0;i<m;i++){
            Arrays.fill(obstaclePathMatrix[i],0);
        }

        //Set the start position as 1 as from start to start we have only one way
        obstaclePathMatrix[0][0] = 1;

        //Initialize the top row. If any obstacle found then from that point all value will be zero
        for (int i = 1; i < n; i++) {
            if(obstacleGrid[0][i] == 0){
                obstaclePathMatrix[0][i] = obstaclePathMatrix[0][i-1];
            }
        }

        //Initialize the top column. If any obstacle found then from that point all value will be zero
        for (int i = 1; i < m; i++) {
            if(obstacleGrid[i][0] == 0){
                obstaclePathMatrix[i][0] = obstaclePathMatrix[i-1][0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstaclePathMatrix[i][j] = obstaclePathMatrix[i - 1][j] + obstaclePathMatrix[i][j - 1];
                }
            }
        }

        return obstaclePathMatrix[m - 1][n - 1];
    }

}
