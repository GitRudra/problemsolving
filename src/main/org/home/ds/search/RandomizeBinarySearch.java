package org.home.ds.search;

import java.util.Comparator;
import java.util.Random;

public class RandomizeBinarySearch<T> {

    public boolean search(T[] input, T key, Comparator comparator){
        boolean isfound = false;
        int counter = 0;
        if(input==null || input.length==0){
            return false;
        }else{
            int start = 0;
            int end = input.length-1;
            int mid;

            while(start<=end){
                mid = getRandomizePivot(start,end);
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

    public int getRandomizePivot(int start, int end){
        return new Random().nextInt((end-start)+1)+start;
    }
}
