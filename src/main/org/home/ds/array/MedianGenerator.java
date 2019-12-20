package org.home.ds.array;

import java.util.Arrays;

public class MedianGenerator {

    public static double calculateMedianOfTwoSortedArrayWithSameSize(int[] a1, int[] a2) throws Exception {
        if ((a1 == null || a1.length == 0) && (a2 == null || a2.length == 0)) {
            throw new Exception(" Invalid input exception ");
        }
        if (a1 != null && a1.length == 0) {
            return getMedian(a2, 0, a2.length - 1);
        }
        if (a2.length == 0) {
            return getMedian(a1, 0, a1.length - 1);
        }
        return getMedianOfSortedArray(a1, a2, 0, a1.length - 1, 0, a2.length - 1);

    }


    public static double getMedianOfSortedArray(int[] a, int[] b, int aStart, int aEnd, int bStart, int bEnd) {
        if ((aEnd - aStart + 1) <= 2) {
            return (double) (Math.max(a[aStart], b[bStart]) + Math.min(a[aEnd], b[bEnd])) / 2;
        }

        double m1 = getMedian(a, aStart, aEnd);
        double m2 = getMedian(b, bStart, bEnd);

        if (m1 == m2) {
            return m1;
        } else if (m1 < m2) {
            if ((aEnd - aStart + 1) % 2 == 0) {
                return getMedianOfSortedArray(a, b, (aStart + aEnd + 1) / 2 - 1, aEnd, bStart, (bStart + bEnd + 1) / 2);
            } else {
                return getMedianOfSortedArray(a, b, (aStart + aEnd + 1) / 2, aEnd, bStart, (bStart + bEnd + 1) / 2);
            }
        } else {
            if ((aEnd - aStart + 1) % 2 == 0) {
                return getMedianOfSortedArray(a, b, aStart, (aStart + aEnd + 1) / 2, (bStart + bEnd + 1) / 2 - 1, bEnd);
            } else {
                return getMedianOfSortedArray(a, b, aStart, (aStart + aEnd + 1) / 2, (bStart + bEnd + 1) / 2, bEnd);
            }
        }
    }

    private static void printArray(int[] a, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(a[i] + " ");
        }
    }


    public static double getMedian(int[] a, int start, int end) {
        int len = (end - start) + 1;
        if (len % 2 == 0) {
            return (double) (a[start + (len / 2)] + a[start + ((len - 1) / 2)]) / 2;
        } else {
            return a[start + len / 2];
        }
    }

    public static double medianOfSortedArrayOfDifferentSize(int[] a, int[] b) throws Exception {

        //Case 1: len(a) == 0 len(b)==2
        if (a.length == 0 && b.length == 2) {
            return (double)(b[0] + b[1]) / 2;
        } else if (b.length == 0 && a.length == 2) {
            return (double) (a[0] + a[1]) / 2;
        }
        //Case 2: len(a) == 1 && len(b) == 1

        if (a.length == 1 && b.length == 1) {
            return (double)(a[0] + b[0]) / 2;
        }

        //Case 3 len(a) == 1 && len(b) is odd
        if (a.length == 1 && b.length % 2 == 1) {
            return handleCaseOfSingleElementAndOddLengthArray(b, a[0]);
        }
        if (b.length == 1 && a.length % 2 == 1) {
            return handleCaseOfSingleElementAndOddLengthArray(a, b[0]);
        }

        //Case 4 len(a) == 1 && len(b) is even

        if (a.length == 1 && b.length % 2 == 0) {
            return handleCaseOfSingleElementAndOddLengthArray(b, a[0]);
        }
        if (b.length == 1 && a.length % 2 == 0) {
            return handleCaseOfSingleElementAndOddLengthArray(a, b[0]);
        }

        //Case 5 len(a) = len(b) = 2
        if (a.length == 2 && b.length == 2) {
            return (double)(Math.max(a[0], b[0]) + Math.min(a[1], b[1])) / 2;
        }

        //Case 6 len(a) == 2 && len(b) is odd
        if (a.length == 2 && b.length % 2 == 1) {
            return handleCaseOf2LengthArrayAndEvenLengthArray(b, a);
        }
        if (b.length == 2 && a.length % 2 == 1) {
            return handleCaseOf2LengthArrayAndEvenLengthArray(a, b);
        }

        return -1;
    }

    private static double handleCaseOfSingleElementAndOddLengthArray(int[] a, int x) {
        int mid = a.length / 2;
        if (x <= a[mid - 1]) {
            return (double)(a[mid] + a[mid - 1]) / 2;
        } else if (x >= a[mid + 1]) {
            return (double)(a[mid] + a[mid + 1]) / 2;
        } else {
            return (double)(x + a[mid]) / 2;
        }
    }

    private static double handleCaseOfSingleElementAndEvenLengthArray(int[] a, int x) {
        int mid = a.length / 2;
        if (a[mid - 1] <= x && a[mid] >= x) {
            return x;
        } else if (x < a[mid - 1]) {
            return a[mid - 1];
        } else {
            return a[mid];
        }
    }


    private static double handleCaseOf2LengthArrayAndEvenLengthArray(int[] lenOddArray, int[] len2Array) {
        int[] tempArray = new int[3];
        tempArray[0] = lenOddArray[lenOddArray.length / 2];
        tempArray[1] = Math.max(len2Array[0], lenOddArray[lenOddArray.length / 2 - 1]);
        tempArray[2] = Math.min(len2Array[1], lenOddArray[lenOddArray.length / 2 + 1]);
        Arrays.sort(tempArray);
        return getMedian(tempArray, 0, tempArray.length - 1);

    }
}
