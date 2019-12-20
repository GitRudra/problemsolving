package org.home.algo.misc;

import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

public class FloodFilling {
    private int[] rNeighbour = {-1, 1, 0, 0};
    private int[] cNeighbour = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newC) {
        int prevC = image[sr][sc];
        int R = image.length;
        int C = image[0].length;
        Stack<Cell> stack = new Stack();
        Cell cell = new Cell(sr, sc);
        stack.add(cell);
        HashSet<Cell> visited = new HashSet();

        while (stack.size() != 0) {
            Cell c = stack.pop();
            if (!visited.contains(c)) {
                for (int i = 0; i < 4; i++) {
                    if (isSafe(c.x + rNeighbour[i], c.y + cNeighbour[i], R, C) &&
                            image[c.x + rNeighbour[i]][c.y + cNeighbour[i]] == prevC) {
                        Cell ce = new Cell(c.x + rNeighbour[i], c.y + cNeighbour[i]);
                        if(!visited.contains(ce)){
                            stack.add(ce);
                        }

                    }
                   /* if(image[c.x+rNeighbour[i]][c.y+cNeighbour[i] == prevC &&
                            isSafe(c.x+rNeighbour[i],c.y+cNeighbour[i],R,C)
                            ){
                        stack.add(new Cell(c.x+rNeighbour[i],c.y+cNeighbour[i]));
                    }*/
                }
            }
            image[c.x][c.y] = newC;
        }

        return image;
    }

    private boolean isSafe(int rIndex, int cIndex, int row, int col) {
        return (rIndex >= 0 && rIndex < row && cIndex >= 0 && cIndex < col);
    }
}

class Cell {
    public int x;
    public int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Cell that = (Cell) o;
        return this.x == that.x && this.y == that.y;
    }
}