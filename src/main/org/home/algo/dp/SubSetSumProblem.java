package org.home.algo.dp;

public class SubSetSumProblem {

    /**
     * We can solve the problem in Pseudo-polynomial time using Dynamic programming.
     * We create a boolean 2D table subset[][] and fill it in bottom up manner.
     * The value of subset[i][j] will be true if there is a subset of set[0..j-1] with sum equal to i.,
     * otherwise false. Finally, we return subset[sum][n]
     *
     * @param input
     * @param targetSum
     */
    public static void findSubSet(int[] input, int targetSum) {
        boolean[][] solMat = new boolean[targetSum + 1][input.length + 1];
        //If sum is zero then answer is true.
        for (int i = 0; i <= input.length; i++) {
            solMat[0][i] = true;
        }

        //If sum is non zero but set is empty then false
        for (int i = 0; i <= targetSum; i++) {
            solMat[i][0] = false;
        }
        for (int i = 1; i < targetSum + 1; i++) {
            for (int j = 1; j <= input.length; j++) {
                solMat[i][j] = solMat[i][j - 1];
                if (i >= input[j - 1])
                    solMat[i][j] = solMat[i][j] ||
                            solMat[i - input[j - 1]][j - 1];
            }
        }

        printMatrix(solMat, targetSum + 1,input.length+1 );
    }

    private static void printMatrix(boolean[][] input, int row, int col) {
        for (int i = 0; i < row; i++) {
            System.out.println("");
            for (int j = 0; j < col; j++) {
                System.out.print((input[i][j] ? 1 : 0) + "  ");
            }
        }
    }

    public static void getSumOfFourElements(int[] input, int sum,int level){

    }
}
