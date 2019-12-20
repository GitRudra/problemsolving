package org.home.ds.graph;

        import java.util.Arrays;

/**
 * Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island
 */
public class IslandProblem {
    private int ROW;
    private int COLUMN;
    private int[][] GRAPH;
    private boolean[][] VISITED;

    // These arrays are used to get row and column numbers
    // of 8 neighbors of a given cell
    private int ROW_NBR[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
    private int COL_NBR[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

    public IslandProblem(int ROW, int COLUMN, int[][] GRAPH) {
        this.ROW = ROW;
        this.COLUMN = COLUMN;
        this.GRAPH = GRAPH;
        VISITED = new boolean[ROW][COLUMN];
        for(int i=0;i<ROW;i++){
            Arrays.fill(VISITED[i],false);
        }

    }

    // A function to check if a given cell (row, col) can
    // be included in DFS
    private boolean isSafe(int row, int col){
        return (row>=0) && (row<ROW) &&
                (col>=0) && (col<COLUMN) &&
                !VISITED[row][col] && GRAPH[row][col] == 1;
    }

    /**
     * Utility function to do DFS on 2D boolean matrix {@code GRAPH}.
     * It only checks the eight connected neighbour.
     * @param row
     * @param column
     */
    private void DFS(int row, int column){
        //Mark the cell as visited
        VISITED[row][column] = true;
        //Recursively check for all the connected neighbour.
        for(int i=0;i<8;i++){
            if(isSafe(row+ ROW_NBR[i],column+ COL_NBR[i])){
                DFS(row+ ROW_NBR[i],column+ COL_NBR[i]);
            }
        }
    }

    public int countIsland(){
        int count = 0;
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COLUMN;j++){
                //IF the value is 1 then one Island has been found. Then check its
                //neighbour for area of the island and increase the island count.
                if(GRAPH[i][j] == 1 & !VISITED[i][j]){
                    DFS(i,j);
                    count++;
                }
            }
        }

        System.out.println(count);
        return count;
    }
}
