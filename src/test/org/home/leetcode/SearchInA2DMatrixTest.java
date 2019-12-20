package org.home.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInA2DMatrixTest {

    @Test
    public void searchMatrixOne() {
        SearchInA2DMatrix finder = new SearchInA2DMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target  = 3;
        boolean actual = finder.searchMatrix(matrix,target);
        assertTrue(actual);
    }

    @Test
    public void searchMatrixTwo() {
        SearchInA2DMatrix finder = new SearchInA2DMatrix();
        int[][] matrix = {{1,3,5,7}};
        int target  = 1;
        boolean actual = finder.searchMatrix(matrix,target);
        assertTrue(actual);
    }

    @Test
    public void searchMatrixThree() {
        SearchInA2DMatrix finder = new SearchInA2DMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target  = 13;
        boolean actual = finder.searchMatrix(matrix,target);
        assertFalse(actual);
    }
}