package org.home.algo.misc;

/**
 * Given n non-negative integers representing an elevation
 * map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TappingRainWater {
    /**
     * An element of array can store water if there are higher bars
     * on left and right.
     * We can find amount of water to be stored in every element by finding
     * the heights of bars on left and right sides.
     * The idea is to compute amount of water that can be stored in
     * every element of array.
     * For example, consider the array {3, 0, 0, 2, 0, 4},
     * we can store three units of water at indexes 1 and 2,
     * and one unit of water at index 3, and three units of water at index 4.
     *
     * @param heights
     * @return
     */
    public int calculateWaterAmount(int[] heights){
        int result = 0;
        if(heights==null || heights.length<2){
            return result;
        }
        int[] left =  new int[heights.length];
        int[] right =  new int[heights.length];

        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int max = heights[0];
        left[0] = max;
        for (int i = 1; i < heights.length; i++) {
            if(heights[i]<max){
                left[i] = max;
            }else{
                left[i] = heights[i];
                max = heights[i];
            }
        }
        printArray("Left",left);

        //Scan from right
        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        max = heights[heights.length-1];
        right[heights.length-1] = max;
        for (int i = heights.length - 2; i >= 0; i--) {
            if(heights[i]<max){
                right[i] = max;
            }else{
                right[i] = heights[i];
                max = heights[i];
            }
        }

        printArray("Right",right);

        for (int i = 0; i < heights.length; i++) {
            result+= Math.min(left[i],right[i])-heights[i];
        }
        return result;

    }

    private void printArray(String msg, int[] input){
        System.out.println();
        System.out.print(msg+" : ");
        for(int i=0;i<input.length;i++){
            System.out.print(input[i]+" , ");
        }
    }
}
