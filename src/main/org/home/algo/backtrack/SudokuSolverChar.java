package org.home.algo.backtrack;

public class SudokuSolverChar {

    public void solveSudoku(char[][] board) {
        solveSudokuUtil(board);
        printSolution(board, board[0].length);
    }

    private boolean solveSudokuUtil(char[][] board) {
        int n = board[0].length;
        Cell empty = getFirstEmptyCell(board, n);
        if (empty == null) {
            return true;
        }
        for (int i = 1; i <= n; i++) {
            board[empty.x][empty.y] = Character.forDigit(i, 10);
            if (isSafe(board, empty.x, empty.y, n) && solveSudokuUtil(board)) {
                return true;
            } else {
                board[empty.x][empty.y] = '.';
            }
        }
        return false;
    }

    private Cell getFirstEmptyCell(char[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        return isSafeRowWise(board, row, col, n) &&
                isSafeColumnWise(board, row, col, n) &&
                isSafeSquareSubMatrix(board, row, col, n);
    }

    private boolean isSafeRowWise(char[][] board, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (i != col && board[row][i] == board[row][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean isSafeColumnWise(char[][] board, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (i != row && board[i][col] == board[row][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean isSafeSquareSubMatrix(char[][] board, int row, int col, int n) {
        int r = row - (row % 3);
        int c = col - (col % 3);

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (row != i && col != j && board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printSolution(char[][] board, int boardSize) {
        for (int i = 0; i < boardSize; i++) {
            System.out.println("");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
    }
}


class Cell {
    public int x;
    public int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

}