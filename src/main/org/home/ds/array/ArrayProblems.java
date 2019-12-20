package org.home.ds.array;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayProblems {

    /**
     * Search the celin of a given number into the array.
     * @param a input array
     * @param key search key
     * @return celin of {@code key}
     * @throws Exception if celin not found
     */
    public int celinSearch(int[] a, int key) throws Exception {
        if (a == null || a.length == 0) {
            return -2;
        }
        if (key < a[0]) {
            return 0;
        }
        int celIndex = celBinarySearch(a, key, 0, a.length - 1);
        if (celIndex == -1) {
            throw new Exception("Celling not found");
        }
        return a[celIndex];
    }

    /**
     * Method to search celing of an element in a sorted array
     * @param a array
     * @param key
     * @param l
     * @param h
     * @return
     */
    private int celBinarySearch(int[] a, int key, int l, int h) {
        if (l >= h) {
            return -1;
        }
        int mid = (l + h) / 2;
        //TODO if array[mid] = key then which will be the celing mid or mid+1.
        // TODO As it is contradicts first else if condition
        if (a[mid] == key) {
            return mid;
        } else if (mid - 1 >= l && a[mid - 1] <= key && a[mid] > key) {
            return mid;
        } else if (key < a[mid] && (mid - 1 >= l && key < a[mid - 1])) {
            celBinarySearch(a, key, l, mid - 1);
        } else if (mid + 1 <= h && a[mid + 1] >= key && a[mid] < key) {
            return mid + 1;
        } else if (mid + 1 <= h && a[mid + 1] < key && a[mid] < key) {
            return celBinarySearch(a, key, mid + 1, h);
        }
        return -1;
    }

    /**
     * Rotate array left by K bits
     * @param a input array
     * @param k number of bits to be rotated
     * @throws Exception if array is null or empty or k is zero
     */
    public static void rotateArrayLeft(int[] a, int k) throws Exception {
        int rotationLength = k;
        if (a == null || a.length == 0 || k == 0) {
            throw new Exception("Invalid input");
        } else {
            if (k > a.length) {
                rotationLength = k % a.length;
            }
            reverseArray(a, 0, rotationLength - 1);
            reverseArray(a, rotationLength, a.length - 1);
            reverseArray(a, 0, a.length - 1);
        }
    }

    /**
     * Utility function to reverse an array.
     * @param a
     * @param start
     * @param end
     */
    private static void reverseArray(int[] a, int start, int end) {
        if (start > end) {

        }
        while (start <= end) {
            swap(a, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void findMaximumSizeSubArrayOfOne(int[][] m, int row, int col) {
        int[][] s = new int[row][col];
        int max = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    s[i][j] = m[i][j];
                } else if (m[i][j] == 1) {
                    s[i][j] = Math.min(s[i - 1][j],
                                Math.min(s[i][j - 1],
                                      s[i - 1][j - 1])) + 1;
                    if (s[i][j] > max) {
                        max = s[i][j];
                        maxRow = i;
                        maxCol = j;
                    }
                } else {
                    s[i][j] = 0;
                }
            }
        }
        System.out.println("Max Size = " + (max == Integer.MIN_VALUE ? 0 : max));
    }

    /**
     * Given an array of distinct integers,
     * find if there are two pairs (a, b) and (c, d) such that a+b = c+d,
     * and a, b, c and d are distinct elements.
     * If there are multiple answers, then print any of them.
     * <p>
     * Example:
     * <p>
     * Input:   {3, 4, 7, 1, 2, 9, 8}
     * Output:  (3, 8) and (4, 7)
     * Explanation: 3+8 = 4+7
     * <p>
     * Input:   {3, 4, 7, 1, 12, 9};
     * Output:  (4, 12) and (7, 9)
     * Explanation: 4+12 = 7+9
     * <p>
     * Input:  {65, 30, 7, 90, 1, 9, 8};
     * Output:  No pairs found
     * Expected Time Complexity: O(n2)
     *
     * @param input
     */
    public static void findPairs(int[] input) {
        if(input == null || input.length ==0){
            return;
        }
        int sum = 0;
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                sum = input[i] + input[j];
                Pair currentPair = new Pair(input[i], input[j]);
                if (map.containsKey(sum)) {
                    System.out.println(map.get(sum) + "   " + currentPair);
//                    System.out.println(currentPair);
                } else {
                    map.put(sum, currentPair);
                }
            }
        }

    }

    /**
     * Given a set S (all distinct elements) of integers,
     * find the largest d such that a + b + c = d
     * where a, b, c, and d are distinct elements of S.
     *
     * Constraints:
     * 1 ≤ number of elements in the set ≤ 1000
     * INT_MIN ≤ each element in the set ≤ INT_MAX
     * @param input
     * @return
     */
    public static int findPairsTwo(int[] input) {
        if(input == null || input.length ==0){
            return -1;
        }
        int sum = 0;
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                sum = input[i] + input[j];
                Pair currentPair = new Pair(input[i], input[j]);
                map.put(sum, currentPair);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                sum = input[j] - input[i];
                if (map.containsKey(sum)) {
                    Pair found = map.get(sum);
                    if (found.getI() != input[i] && found.getI() != input[j]
                            && found.getJ() != input[i] && found.getJ() != input[j]) {
                        Pair currentPair = new Pair(input[i], input[j]);
                        max = Math.max(max, Math.max(input[i], input[j]));
                    }
                }
            }
        }
        return max;

    }

    class ReturnObject {
        private Pair firstPair;
        private Pair secondPair;

        public ReturnObject(Pair firstPair, Pair secondPair) {
            this.firstPair = firstPair;
            this.secondPair = secondPair;
        }

        public Pair getFirstPair() {
            return firstPair;
        }

        public Pair getSecondPair() {
            return secondPair;
        }
    }

    static class Pair {
        private int i;
        private int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        @Override
        public String toString() {
            return "Pair{" + i + "," + j + ")";
        }
    }
}
