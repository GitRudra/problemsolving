package org.home.ds.array;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.*;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days){
        List<Integer> result = new ArrayList();
        if(states == null || states.length == 0){
            return result;
        }
        int left = 0;
        int right;
        int mem;
        int j;
        for(int i=0;i<days;i++){
            j=0;
            left= 0;
            for(;j<states.length-1;j++){
                mem = states[j] ;
                states[j] = left ^ states[j+1];
                left = mem;
            }
            states[j] = left ^ 0;
        }


        for(int x: states){
            result.add(x);
        }

        return result;

    }
    // METHOD SIGNATURE ENDS
}