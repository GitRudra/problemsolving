package org.home.algo.backtrack;

public class SudokuSolver {
    private int subSquareMatrixSize;
    private int boardSize;
    private int[][] board;

    public SudokuSolver(int boardSize, int[][] board) {
        this.boardSize = boardSize;
        this.board = board;
        this.subSquareMatrixSize = (int)Math.sqrt(boardSize);
    }

    class Cell{
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private Cell foundCurrentEmptyPosition(){
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                if(board[i][j] == 0){
                    return new Cell(i,j);
                }
            }
        }
        return null;
    }

    private boolean isSafe(int rowPos, int colPos, int num){
        return isSafeRowWise(rowPos,num) &&
                isSafeColumnWise(colPos,num) &&
                isSafeSquareSubMatrix(rowPos,colPos,num);
    }

    private boolean isSafeRowWise(int rowNumber, int num){
        boolean safe = true;
        for(int i = 0;i<boardSize;i++){
            if(board[rowNumber][i] == num){
                safe = false;
                break;
            }
        }
        return safe;
    }

    private boolean isSafeColumnWise(int colNum, int num){
        boolean safe = true;
        for(int i = 0;i<boardSize;i++){
            if(board[i][colNum] == num){
                safe = false;
                break;
            }
        }
        return safe;
    }

    private boolean isSafeSquareSubMatrix(int rowNum, int colNum, int num){
        int rowIndexSubMatrix = rowNum - rowNum% subSquareMatrixSize;
        int columnIndexSubMatrix = colNum - colNum% subSquareMatrixSize;
        boolean safe = true;
        for(int i=rowIndexSubMatrix;i<rowIndexSubMatrix+subSquareMatrixSize;i++){
            for(int j=columnIndexSubMatrix;j<columnIndexSubMatrix+subSquareMatrixSize;j++){
                if(board[i][j] == num){
                    safe = false;
                    break;
                }
            }
            if(!safe){
                break;
            }
        }
        return safe;
    }



    public boolean solveSudoku(){
        Cell emptyCell = foundCurrentEmptyPosition();
        if(emptyCell == null){
            return true;
        }else{
            for(int num = 1;num<=boardSize;num++){
                if(isSafe(emptyCell.getX(),emptyCell.getY(),num)){
                    board[emptyCell.getX()][emptyCell.getY()] = num;
                    if(solveSudoku()){
                        return true;
                    }else{
                        board[emptyCell.getX()][emptyCell.getY()] = 0;
                    }
                }
            }
            return false;
        }

    }

    public void printSolution(){
        for(int i=0;i<boardSize;i++){
            System.out.println("");
            for(int j=0;j<boardSize;j++){
                System.out.print(board[i][j]+ " ");
            }
        }
    }

}
