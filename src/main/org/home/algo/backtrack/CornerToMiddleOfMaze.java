package org.home.algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Given a square maze containing positive numbers,
 * find all paths from a corner cell (any of the extreme four corners)
 * to the middle cell. We can move exactly n steps from a cell in
 * 4 directions i.e. North, East, West and South where n is value of the cell,
 *
 * We can move to mat[i+n][j], mat[i-n][j], mat[i][j+n], and mat[i][j-n]
 * from a cell mat[i][j] where n is value of mat[i][j].
 */
public class CornerToMiddleOfMaze {

    /**
     * The class to represent cell in the array
     */
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x &&
                    y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + " , "+ y + ')';
        }
    }
    private int[][] maze;
    private int row;
    private int column;
    private boolean[][] visited;
    private int targetX;
    private int targetY;
    private LinkedList<Cell> path = null;

    /**
     * Constructor
     * @param maze
     * @param row
     * @param column
     */
    public CornerToMiddleOfMaze(int[][] maze, int row, int column) {
        this.maze = maze;
        this.row = row;
        this.column = column;
        visited = new boolean[row][column];
        for(int i=0;i<row;i++){
            Arrays.fill(visited[i], false);
        }
        this.targetX = row/2;
        this.targetY = column/2;
        path = new LinkedList<>();
    }

    /**
     * Validate the left move in maze row wise
     * @param r current row position
     * @param c current col position
     * @param num number of movement
     * @return false if cross the left boundary
     */
    private boolean validateLeftMove(int r, int c, int num){
        return c-num>=0;
    }

    /**
     * Validate the right move in maze row wise
     * @param r current row position
     * @param c current col position
     * @param num number of movement
     * @return false if cross the right boundary
     */
    private boolean validateRightMove(int r, int c, int num){
        return c+num<column;
    }

    /**
     * Validate the up ward move in maze column wise
     * @param r current row position
     * @param c current col position
     * @param num number of movement
     * @return false if cross the upper boundary
     */
    private boolean validateUpMove(int r, int c, int num){
        return r-num>=0;
    }

    /**
     * Validate the down ward move in maze column wise
     * @param r current row position
     * @param c current col position
     * @param num number of movement
     * @return false if cross the lower boundary
     */
    private boolean validateDownMove(int r, int c, int num){
        return r+num<row;
    }

    /**
     * Match the current position with target position
     * @param x current row position
     * @param y current col position
     * @return true if matched
     */
    private boolean isTargetMatched(int x, int y){
       return (x==targetX) && (y==targetY);
    }

    /**
     * Print the path
     */
    private void printPath(){
        if(!path.isEmpty()){
            path.stream().forEach(e-> System.out.print(e+" -> "));
        }

    }

    private boolean validateMove(int r, int c, int num){
        return validateLeftMove(r,c,num) &&
                validateRightMove(r,c,num) &&
                validateUpMove(r,c,num) &&
                validateDownMove(r,c,num);
    }

    /**
     * The main method to move in a maze.
     *
     * The idea is to use backtracking. We start with each corner cell of the maze and
     * recursively checks if it leads to the solution or not.
     * Following is the Backtracking algorithm –
     *
     * If destination is reached
     *     print the path
     * Else
     *    <ol>
     *        <li>Mark current cell as visited and add it to path array.</li>
     *        <li>Move forward in all 4 allowed directions and recursively check
     *        if any of them leads to a solution.</li>
     *        <li>If none of the above solutions work then mark this cell as not
     *        visited and remove it from path array.</li>
     *    </ol>
     *
     * @param startX start position x direction
     * @param startY start position y direction
     * @return if path exist
     */
    public boolean walkInMaze(int startX, int startY){
        if(visited[startX][startY]){
            return false;
        }

        //Visited matrix to keep the track of
        //already visited node
        visited[startX][startY] = true;

        //The number of steps can be moved from startX and startY
        //in all four direction
        int moveCount = maze[startX][startY];

        //Object to store the current position into the resultant path.
        Cell pos = new Cell(startX, startY);
        path.addLast(pos);

        //If target matched then return true
        if(isTargetMatched(startX,startY)){
            printPath();
            return true;
        }

        boolean success = false;

        //recursive method to explore right movement.
        //if target can be reached in right movement then set
        //the success flag as true else false
        if(validateRightMove(startX,startY,moveCount)){
            success = walkInMaze(startX,startY+moveCount);
        }

        //If target cannot be reached in previous step backtrack
        //and explore alternative ways
        if(!success && validateLeftMove(startX,startY,moveCount)){
            success = walkInMaze(startX,startY-moveCount);
        }
        if(!success && validateUpMove(startX,startY,moveCount)){
            success = walkInMaze(startX-moveCount,startY);
        }
        if(!success && validateDownMove(startX,startY,moveCount)){
            success = walkInMaze(startX+moveCount,startY);
        }

        //If target cannot be reached by any of the movement
        //backtrack to the previous execution and remove the cell
        //from visited path
        if(!success){
            path.remove(pos);
            visited[startX][startY] = false;
        }
        return success;

    }
}
