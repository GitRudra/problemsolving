package org.home.hackerrank;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class HourGlassSum2DArray {

    public static int calculateMaxSum(int[][] arr) throws Exception {
        if(arr == null){
            throw new Exception("Invalid input exception !!!");
        }
        int row = arr.length;
        int col = arr[0].length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<=row-3;i++){
            sum = 0;
            for(int j = 0; j<=col-3;j++){
                sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]
                        +arr[i+1][j+1]
                        +arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}
