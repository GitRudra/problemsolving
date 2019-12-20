package org.home.leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m row n matrix. This matrix has the following properties:
 *
 *     Integers in each row are sorted from left to right.
 *     The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class SearchInA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null ||matrix.length ==0 ){
            return false;
        }
        boolean found = false;
        int rows = matrix.length;
        int column = matrix[0].length;

        int start = 0;
        int end = rows - 1;
        int mid = -1;
        boolean rowFound = false;

        //find target row using binary search over the rows of array
        while (start <= end) {
            mid = (start + end) / 2;
            if (matrix[mid][0] <= target && matrix[mid][column - 1] >= target) {
                rowFound = true;
                break;
            } else if (target < matrix[mid][0]) {
                end = mid - 1;

            } else if (target > matrix[mid][column - 1]) {
                start = mid + 1;
            }
        }

        if (!rowFound) {
            return false;
        }
        start = 0;
        end = column - 1;
        int colMid = 0;
        boolean targetFound = false;
        while (start <= end) {
            colMid = (start + end) / 2;
            if (matrix[mid][colMid] == target) {
                targetFound = true;
                break;
            } else if (matrix[mid][colMid] < target) {
                start = colMid + 1;
            } else {
                end = colMid - 1;
            }

        }

        return targetFound;

    }
}
