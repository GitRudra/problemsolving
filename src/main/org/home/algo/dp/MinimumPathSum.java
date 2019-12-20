package org.home.algo.dp;

public class MinimumPathSum {

    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     * Example:
     *
     * Input: [[1,3,1], [1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid == null ){
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;
//        System.out.println("Row count = "+row+" Column = "+col);
        int[][] totalCost = new int[row][col];

        totalCost[0][0] = grid[0][0];
        for(int i=1;i<row;i++){
            totalCost[i][0] = totalCost[i-1][0]+grid[i][0];
        }
        for(int i=1;i<col;i++){
            totalCost[0][i] = totalCost[0][i-1]+grid[0][i];
        }

//        printArray(totalCost,row,col);

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                totalCost[i][j] = Math.min(totalCost[i-1][j],totalCost[i][j-1])+grid[i][j];
            }
//            printArray(totalCost,row,col);
        }

        return totalCost[row-1][col-1];
    }

    private void printArray(int[][] grid,int row, int col){
        System.out.println("\n-------------------------");
        for(int i = 0;i<row;i++){
            System.out.println("");
            for(int j=0;j<col;j++){
                System.out.print(grid[i][j]+" ");
            }
        }
    }

}
