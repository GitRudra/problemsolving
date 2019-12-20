package org.home.algo.backtrack;

import java.util.Arrays;

public class NQueenProblemSolver {
    private int QUEEN_NUMBER;
    private int[][] QBOARD;
    private int REMAINING_QUEEN;
    private int solNumber = 1;

    public NQueenProblemSolver(int N) {
        this.QUEEN_NUMBER = N;
        QBOARD = new int[N][N];
        //REMAINING_QUEEN = N;
        resetBoard();
    }

    public void findNQueenSol(){
        for(int i=0;i<QUEEN_NUMBER;i++){
            QBOARD[0][i]= 1;
            if(placeQueen(1)){
                resetBoard();
            }else{
                QBOARD[0][i]= 0;
            }
        }
    }

    private boolean placeQueen(int rowNum){
        if(rowNum == QUEEN_NUMBER){
            System.out.println("\n\n Sol : " + solNumber);
            printBoard();
            solNumber++;
            return true;
        }
        boolean canPlaceQueen = false;
        for(int i=0;i<QUEEN_NUMBER;i++){
            if(isSafePosition(rowNum,i)){
                QBOARD[rowNum][i] = 1;
                canPlaceQueen = placeQueen(rowNum+1);
                if(!canPlaceQueen){
                    QBOARD[rowNum][i] = 0;
                }
            }
        }
        return canPlaceQueen;
    }

    private void printBoard(){
        for(int i=0;i<QUEEN_NUMBER;i++){
            System.out.println();
            for(int j=0;j<QUEEN_NUMBER;j++){
                System.out.print(QBOARD[i][j]+" ");
            }
        }
    }

    private void resetBoard(){
        for(int i=0;i<QUEEN_NUMBER;i++){
            Arrays.fill(QBOARD[i],0);
        }
    }

    private boolean isSafePosition(int rowPos,int colPos) {
        return rowWiseLeft(rowPos,colPos) &&
                columnWiseUpWard(rowPos,colPos) &&
                checkCrossDiagonallyUpward(rowPos, colPos) &&
                checkDiagonallyUpward(rowPos,colPos);
    }
    private boolean rowWiseLeft(int rowPos, int colPos){
        for (int i = colPos-1; i >= 0; i--) {
            if (QBOARD[rowPos][i] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean rowWiseRight(int rowPos, int colPos){
        for (int i = colPos+1; i <QUEEN_NUMBER; i++) {
            if (QBOARD[rowPos][i] == 1) {
                return false;
            }
        }
        return true;
    }


    private boolean columnWiseDownWard(int rowPos, int colPos){
        for (int i = rowPos + 1; i < QUEEN_NUMBER; i++) {
            if (QBOARD[i][colPos] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean columnWiseUpWard(int rowPos, int colPos){
        for (int i = rowPos - 1; i >= 0; i--) {
            if (QBOARD[i][colPos] == 1) {
                return false;
            }
        }
        return true;
    }
    private boolean checkCrossDiagonallyUpward(int rowPos, int colPos){
        for (int i = rowPos-1, j = colPos-1; i >= 0 && j >=0; i--, j--) {
            if (QBOARD[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonallyUpward(int rowPos,int colPos){
        for (int i = rowPos-1, j = colPos+1; i >= 0 && j < QUEEN_NUMBER; i--, j++) {
            if (QBOARD[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonallyDownward(int rowPos, int colPos){
        for (int i = rowPos + 1, j = colPos - 1; i < QUEEN_NUMBER && j >= 0; i++, j--){
            if (QBOARD[i][j] == 1) {
                return false;
            }
        }
        return true;
    }


    private boolean checkCrossDiagonallyDownward(int rowPos, int colPos){
        for (int i = rowPos + 1, j = colPos + 1; i < QUEEN_NUMBER && j <QUEEN_NUMBER; i++, j++){
            if (QBOARD[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
