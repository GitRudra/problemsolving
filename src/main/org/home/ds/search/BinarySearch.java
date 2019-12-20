package org.home.ds.search;

import java.util.Comparator;

public class BinarySearch<T> {

    public boolean regularBinarySearch(T[] input, T key, Comparator comparator){
        boolean isfound = false;
        int counter = 0;
        if(input==null || input.length==0){
            return false;
        }else{
            int start = 0;
            int end = input.length-1;
            int mid;

            while(start<=end){
                mid = (start+end)/2;
                int x = comparator.compare(input[mid],key);
                counter++;
                if(x==0){
                    isfound =   true;
                    break;
                }else if(x>0){
                    end = mid-1;

                }else{
                    start = mid+1;
                }
            }
        }
        System.out.println("Total number of comparison (optimal) : "+ counter);
        return isfound;
    }

    public boolean optimalBinarySearch(T[] input, T key, Comparator comparator){
        boolean isfound = false;
        int counter = 0;
        if(input==null || input.length==0){
            return false;
        }else{
            int start = 0;
            int end = input.length-1;
            int mid;

            while(end-start>1){
                mid = start+ (end-start)/2;
                int x = comparator.compare(input[mid],key);
                counter++;
                if(x<=0){
                    start =  mid;
//                    break;
                }else {
                    end = mid;

                }
            }
            if(input[start].equals(key)){
                isfound = true;
            }
        }
        System.out.println("Total number of comparison (optimal) : "+ counter);
        return isfound;
    }
}
