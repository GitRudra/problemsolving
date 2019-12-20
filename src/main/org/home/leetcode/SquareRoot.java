package org.home.leetcode;

public class SquareRoot {

    public static long sqrt(int x) throws IllegalArgumentException{
        if(x<0){
            throw new IllegalArgumentException(" Input value cannot be negative");
        }
        if(x == 1){
            return 1;
        }
        long start = 1;
        long end = x;
        long ans = 0;
        long mid = 0;
        while(start <= end){
           // System.out.println("Start = " + start + " End = "+ end + " Mid  = "+ mid);
            mid = (start+end)/2;
            if(mid * mid == x){
                return mid;
            }
            if(mid * mid <x ){
                start = mid+1;
                ans = mid;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }

}
