package org.home.leetcode;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sollution2 {
    class Cell implements Comparable {
        int row;
        int col;
        int dist;

        public Cell(int x, int col, int dist) {
            this.row = x;
            this.col = col;
            this.dist = dist;
        }

        @Override
        public int compareTo( Object o) {
            return 0;
        }
    }

    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        if(numRows == 0 || numColumns ==0 || lot == null || lot.size()==0){
            return -1;
        }
        boolean visited[][] = new boolean[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (lot.get(i).get(j) == 0) {
                    visited[i][j] = true;
                } else {
                    visited[i][j] = false;
                }
            }
        }
        Queue<Cell> q = new PriorityQueue<>();
        q.add(new Cell(0, 0, 0));
        while (!q.isEmpty()) {
            Cell p = q.peek();
            q.remove();
            if (lot.get(p.row).get(p.col) == 9) {
                return p.dist;
            }
            // moving up
            if (p.row - 1 >= 0 &&
                    visited[p.row - 1][p.col] == false) {
                q.add(new Cell(p.row - 1, p.col, p.dist + 1));
                visited[p.row - 1][p.col] = true;
            }

            // moving down
            if (p.row + 1 < numRows &&
                    visited[p.row + 1][p.col] == false) {
                q.add(new Cell(p.row + 1, p.col, p.dist + 1));
                visited[p.row + 1][p.col] = true;
            }

            // moving left
            if (p.col - 1 >= 0 &&
                    visited[p.row][p.col - 1] == false) {
                q.add(new Cell(p.row, p.col - 1, p.dist + 1));
                visited[p.row][p.col - 1] = true;
            }

            // moving right
            if (p.col + 1 < numColumns &&
                    visited[p.row][p.col + 1] == false) {
                q.add(new Cell(p.row, p.col + 1, p.dist + 1));
                visited[p.row][p.col + 1] = true;
            }

        }
        return -1;

    }
}
