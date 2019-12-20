package org.home.ds.array;

import java.util.Arrays;
import java.util.HashMap;

public class PrefixSumArray {

    public static int longestBalancedPrefix(String exp) {

        int sum = 0;
        int left = 0;
        int pos = 0;
        int i = 0;
        for (i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                left++;
            }
            if (exp.charAt(i) == ')') {
                if (left > 0) {
                    left--;
                } else {
                    // VERY IMPORTANT PART:
                    //Signifies the string started with close
                    //parantheses
                    break;
                }
            }
            if (left == 0) {
                pos = i;
                pos++;
            }
        }
        if (i != exp.length() && left == 0) {
            pos = i;
        }
        return pos;
    }

    /**
     * Given an array of positive and negative numbers,
     * find if there is a subarray (of size at-least one) with 0 sum.
     *
     * Input: {4, 2, -3, 1, 6}
     * Output: true
     * There is a subarray with zero sum from index 1 to 3.
     *
     * Input: {4, 2, 0, 1, 6}
     * Output: true
     * There is a subarray with zero sum from index 2 to 2.
     *
     * Input: {-3, 2, 3, 1, 6}
     * Output: false
     * There is no subarray with zero sum.
     *
     * A simple solution is to consider all subarrays one by one
     * and check the sum of every subarray.
     * We can run two loops: the outer loop picks a starting point i
     * and the inner loop tries all subarrays starting from i
     * (See this for implementation).
     * Time complexity of this method is O(n2).
     *
     * We can also use hashing.
     * The idea is to iterate through the array and for every element arr[i],
     * calculate sum of elements form 0 to i
     * (this can simply be done as sum += arr[i]).
     * If the current sum has been seen before, then there is a zero sum array.
     * Hashing is used to store the sum values, so that we can quickly store sum
     * and find out whether the current sum is seen before or not.
     * @param arr
     * @return
     * @throws Exception
     */
    public static boolean findSubArrayWithSumZero(int[] arr) throws Exception {
        if(arr == null || arr.length == 0){
            throw new Exception("Invalid Input Exception !!!");
        }
       // int[] prefixSumArray = new int[arr.length];
        //Arrays.fill(prefixSumArray,0);
        HashMap<Integer,Integer> sumVsIndexMap = new HashMap<>();
        int prefixSum = 0;
        boolean isPresent = false;
        for(int i=0;i<arr.length;i++){
            prefixSum += arr[i];
            if(sumVsIndexMap.containsKey(prefixSum)){
                isPresent = true;
                System.out.println(" Present in [ " +
                        "Start = "+(sumVsIndexMap.get(prefixSum)+1)+
                        " End = " + (i));
                break;
            }else{
                sumVsIndexMap.put(prefixSum,i);
            }
        }
        return isPresent;

    }
}
