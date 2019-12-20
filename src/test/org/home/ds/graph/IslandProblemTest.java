package org.home.ds.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class IslandProblemTest {

    @Test
    public void testCountIslandOne() {

        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}
        };

        int row = 5;
        int col = 5;
        IslandProblem solver = new IslandProblem(row,col,M);
        int expected = 5;
        int actual = solver.countIsland();
        assertEquals(expected,actual);
    }

    @Test
    public void testCountIslandTwo() {
        int M[][]=  new int[][] {{1, 1, 0, 1, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}
        };
        int row = 5;
        int col = 5;
        IslandProblem solver = new IslandProblem(row,col,M);
        int expected = 5;
        int actual = solver.countIsland();
        assertEquals(expected,actual);
    }
}