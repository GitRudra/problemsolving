package org.home.ds.tree.segmenttree;

public class XorQuery {
    private int[] input;
    private int[] segmentTree;

    public XorQuery(int[] input){
        this.input = input;
        segmentTree = new int[getSegmentTreeSize(input.length)];
        constructSegmentTree(0,input.length-1,0);
    }

    private void constructSegmentTree(int low, int high, int pos){
        if(low == high){
            segmentTree[pos] = input[low];
            return;
        }
        int mid = (low+high)/2;
        constructSegmentTree(low, mid, 2*pos+1);
        constructSegmentTree(mid+1, high, 2*pos+2);
        segmentTree[pos] = segmentTree[2*pos+1] ^ segmentTree[2*pos+2];
    }

    private int getSegmentTreeSize(int n){
        int x = (int) Math.ceil(Math.log(n)/Math.log(2));
        int maxSize = 2 * (int)Math.pow(2,x)-1;
        return maxSize;
    }

    public int getXorQuery(int start, int end){
        if(start <0 || end>=input.length){
            return -1;
        }
        return getXORUtil(start,end,0,input.length-1,0);
    }

    private int getXORUtil(int qLow, int qHigh, int low, int high, int pos){
        if(qLow <= low && qHigh >= high){
            return segmentTree[pos];
        }
        if(qLow > high || qHigh < low){
            return 0;
        }
        int mid = (low+high)/2;
        return getXORUtil(qLow, qHigh,low,mid, 2*pos+1)^
                getXORUtil(qLow, qHigh, mid+1, high, 2*pos+2);
    }

}
