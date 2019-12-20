package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathTest {

    @Test
    public void uniquePathsOne() throws Exception {
        int m = 3;
        int n = 3;
        int expected = 6;
        UniquePath path = new UniquePath();
        int actual = path.uniquePaths(m,n);
        assertEquals(expected,actual);
    }

    @Test
    public void uniquePathsTwo() throws Exception {
        int m = 3;
        int n = 2;
        int expected = 3;
        UniquePath path = new UniquePath();
        int actual = path.uniquePaths(m,n);
        assertEquals(expected,actual);
    }

    @Test
    public void uniquePathsThree() throws Exception {
        int m = 7;
        int n = 3;
        int expected = 28;
        UniquePath path = new UniquePath();
        int actual = path.uniquePaths(m,n);
        assertEquals(expected,actual);
    }

    @Test
    public void uniquePathsFour() throws Exception {
        int m = 1;
        int n = 1;
        int expected = 1;
        UniquePath path = new UniquePath();
        int actual = path.uniquePaths(m,n);
        assertEquals(expected,actual);
    }

    @Test
    public void uniquePathsFive() throws Exception {
        int m = 0;
        int n = 0;
        int expected = 0;
        UniquePath path = new UniquePath();
        int actual = path.uniquePaths(m,n);
        assertEquals(expected,actual);
    }

    @Test
    public void uniquePathsWithObstacles() throws Exception {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int expected = 2;
        UniquePath path = new UniquePath();
        int actual = path.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(expected,actual);
    }

    @Test
    public void uniquePathsWithObstaclesTwo() throws Exception {
        int[][] obstacleGrid = {{1,1,1},{1,1,1},{1,1,1}};
        int expected = 0;
        UniquePath path = new UniquePath();
        int actual = path.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(expected,actual);
    }

    @Test
    public void uniquePathsWithObstaclesThree() throws Exception {
        int[][] obstacleGrid = {{0,0,0},{0,0,0},{0,0,0}};
        int expected = 6;
        UniquePath path = new UniquePath();
        int actual = path.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(expected,actual);
    }

    @Test
    public void uniquePathsWithObstaclesFour() throws Exception {
        int[][] obstacleGrid = {{1,0}};
        int expected = 0;
        UniquePath path = new UniquePath();
        int actual = path.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(expected,actual);
    }


    @Test
    public void uniquePathsWithObstaclesFive() throws Exception {
        int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
        int expected = 0;
        UniquePath path = new UniquePath();
        int actual = path.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(expected,actual);
    }

    @Test
    public void uniquePathsWithObstaclesSix() throws Exception {
        int[][] obstacleGrid = {{0,1}};
        int expected = 0;
        UniquePath path = new UniquePath();
        int actual = path.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(expected,actual);
    }
}