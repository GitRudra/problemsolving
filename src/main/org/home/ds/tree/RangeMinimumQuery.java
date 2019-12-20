package org.home.ds.tree;

import java.util.Arrays;

public class RangeMinimumQuery {
    private int[] input;
    private int[] segmentTreeArray;

    public RangeMinimumQuery(int[] input) {
        this.input = input;
        segmentTreeArray = new int[getSegmentTreeSize(input.length)];
        Arrays.fill(segmentTreeArray,Integer.MAX_VALUE);
        createSegmentTree(0,0,input.length-1);
    }

    private int getSegmentTreeSize(int n){
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        return max_size;
    }

    private void createSegmentTree(int pos, int low, int high){
        if(low == high ){
            segmentTreeArray[pos] = input[low];
            return;
        }
        int mid = (low+high)/2;
        createSegmentTree(2*pos+1,low,mid);
        createSegmentTree(2*(pos+1),mid+1,high);
        segmentTreeArray[pos] = Math.min(segmentTreeArray[2*pos+1],segmentTreeArray[2*pos+2]);
    }

    public int[] getSegmentTree(){
        return segmentTreeArray;
    }

    public int rangeQuery(int qLow, int qHigh){
        return rangeQueryUtil(qLow,qHigh,0,input.length-1,0);
    }

    private int rangeQueryUtil(int qLow, int qHigh, int low, int high, int pos){
        if(qLow<=low && qHigh >=high){
            return segmentTreeArray[pos];
        }
        if(qLow>high || qHigh<low){
            return Integer.MAX_VALUE;
        }
        int mid = (low+high)/2;
        return Math.min(rangeQueryUtil(qLow,qHigh,low,mid,2*pos+1),
                        rangeQueryUtil(qLow,qHigh,mid+1,high,2*pos+2));
    }
}
