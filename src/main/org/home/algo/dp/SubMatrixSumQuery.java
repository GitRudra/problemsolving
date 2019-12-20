package org.home.algo.dp;

public class SubMatrixSumQuery {

    private int row;
    private int column;
    private int[][] mat;
    private int[][] sumMatrix;

    public SubMatrixSumQuery(int[][] mat, int row, int column) {
        this.row = row;
        this.column = column;
        this.mat = mat;
        sumMatrix = new int[row+1][column+1];
        populateSumMatrix();
    }

    public int getRangeSumQuery(int sX,int sY, int tX,int tY){
        //incremented all index by 1 as we get the sum from sumMatrix and
        //sumMatrix is larger by actual matrix by 1 row and 1 column
        int sx = sX+1;
        int sy = sY+1;
        int tx = tX+1;
        int ty = tY+1;
        return sumMatrix[tx][ty]-sumMatrix[sx-1][ty]-sumMatrix[tx][sy-1]+sumMatrix[sx-1][sy-1];
    }

    private void populateSumMatrix(){
        for(int i=0;i<=row;i++){
            sumMatrix[i][0] = 0;
        }
        for(int j=0;j<=column;j++){
            sumMatrix[0][j] = 0;
        }

        for(int i=1;i<=row;i++){
            for(int j=1;j<=column;j++){
                sumMatrix[i][j] = sumMatrix[i-1][j]+sumMatrix[i][j-1]-sumMatrix[i-1][j-1] +mat[i-1][j-1];
            }
        }

//        printMatrix(sumMatrix,row+1,column+1);
    }

    private void printMatrix(int[][] mat,int row, int column){
        for(int i=0;i<row;i++){
            System.out.println("");
            for(int j=0;j<column;j++){
                System.out.print(mat[i][j]+"  ");
            }
        }
    }
}
