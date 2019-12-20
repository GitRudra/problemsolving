package org.home.ds.array;

public class MedianOfTwoSortedArray {

    /**
     *
     * @param X is the larger array
     * @param Y is the smaller array
     * @return
     */
    private static double calculateMedianUtil(int[] X, int[] Y) {

        int lenX = X.length;
        int lenY = Y.length;
        int start = 0;
        int end = Y.length;
        int partitionY = 0;
        int partitionX = 0;
        int maxYLeft = 0, minYRight = 0;
        int maxXLeft = 0, minXRight = 0;

        while (start <= end) {
            partitionY = (start + end) / 2;
            partitionX = (lenX + lenY +1)/2 - partitionY;

            maxYLeft = (partitionY == 0) ? Integer.MIN_VALUE : Y[partitionY-1];
            minYRight = (partitionY == lenY) ? Integer.MAX_VALUE : Y[partitionY];

            maxXLeft = (partitionX == 0) ? Integer.MIN_VALUE : X[partitionX-1];
            minXRight = (partitionX == lenX) ? Integer.MAX_VALUE : X[partitionX];

            if (maxYLeft <= minXRight && maxXLeft <= minYRight) {
                if ((lenX + lenY) % 2 == 0) {
                    return (double)(Math.max(maxYLeft, maxXLeft) +
                            Math.min(minXRight, minYRight)) / 2;
                } else {
                    return Math.max(maxYLeft, maxXLeft);

                }
            } else if (maxYLeft > minXRight) {
                end = partitionY - 1;
            } else {
                start = partitionY + 1;
            }
        }
        throw new IllegalArgumentException();

    }

    public static double calculateMedianOfSortedArray(int[] a, int[] b){
        if ((a == null || a.length == 0) &&
                (b == null || b.length == 0)) {
            return Integer.MIN_VALUE;
        }

        if(a.length >b.length){
            return calculateMedianUtil(a,b);
        }else {
            return calculateMedianUtil(b, a);
        }
    }


    private int getMedian(int[] arr) {
        return arr.length % 2 == 1 ? arr[arr.length / 2] :
                (arr[(arr.length - 1) / 2] + arr[arr.length / 2]) / 2;

    }

}
