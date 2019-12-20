package org.home.ds.tree;

/**
 * Given an array a[0 . . . n-1].
 * We should be able to efficiently find the GCD from
 * index qs (query start) to qe (query end) where
 * 0 <= qs <= qe <= n-1.
 *
 * Example :
 *
 * Input : a[] = {2, 3, 60, 90, 50};
 *         Index Ranges : {1, 3}, {2, 4}, {0, 2}
 * Output: GCDs of given ranges are 3, 10, 1
 */
public class GcdOfGivenIndexRange {

    private int[]segmentTree;
    private int[] inputArray;

    public GcdOfGivenIndexRange(int[] arr) {
        inputArray = arr;
        int height = (int)Math.ceil(Math.log(inputArray.length)/Math.log(2));
        int treeSize = 2*(int)Math.pow(height,2)-1;
        segmentTree = new int[treeSize];
        constructSegmentTree(0,inputArray.length-1,0);
    }

    public int findGcdInTheRange(int qs, int qe){
        if(qs<0 || qe>inputArray.length-1 || qs>qe){
            throw new IllegalArgumentException("Illegal argument exception !!!");
        }
        return findGcd(0,inputArray.length,qs,qe,0);
    }

    /*  A recursive function to get gcd of given
    range of array indexes. The following are parameters for
    this function.

    st    --> Pointer to segment tree
    si --> Index of current node in the segment tree. Initially
               0 is passed as root is always at index 0
    ss & se  --> Starting and ending indexes of the segment
                 represented by current node, i.e., st[index]
    qs & qe  --> Starting and ending indexes of query range */
    private int findGcd(int start, int end, int qs, int qe, int si){
        if(qe<start || qs>end){
            return 0;
        }
        if(qs<=start && qe>=end){
            return segmentTree[si];
        }
        int mid = (start+end)/2;
        return gcd(findGcd(start,mid,qs,qe,2*si+1), findGcd(mid+1,end,qs,qe,2*si+2));
    }

    private int constructSegmentTree(int start, int end, int pos){
        if(start == end){
            segmentTree[pos] = inputArray[start];
        }else{
            int mid = (start+end)/2;
            segmentTree[pos] = gcd(constructSegmentTree(start,mid,2*pos+1),
                    constructSegmentTree(mid+1,end,2*(pos+1)));
        }

        return segmentTree[pos];
    }

    private int gcd(int x, int y){
        if(y==0){
            return x;
        }
        if(x==0){
            return y;
        }

        int gcd = 0;
        while(y>0){
            gcd = x%y;
            x = y;
            y = gcd;
        }

        return x;
    }
}
