package org.home.leetcode;

public class SetMatrixZero {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean zeroFoundFlag = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    zeroFoundFlag = true;
                    changeRowValue(matrix, col, i);
                    changeColumnValue(matrix, row, j);
                }
            }
        }
        if(zeroFoundFlag){
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] < 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

    }

    private void changeRowValue(int[][] matrix, int col, int rowIndex) {
        for (int i = 0; i < col; i++) {
            if(matrix[rowIndex][i]>0){
                matrix[rowIndex][i] = -matrix[rowIndex][i];
            }

        }
    }

    private void changeColumnValue(int[][] matrix, int row, int colIndex) {
        for (int i = 0; i < row; i++) {
            if(matrix[i][colIndex] > 0){
                matrix[i][colIndex] = -matrix[i][colIndex];
            }

        }
    }
}
