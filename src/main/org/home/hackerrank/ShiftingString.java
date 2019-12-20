package org.home.hackerrank;

public class ShiftingString {

    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        if(s== null || s.length() == 0){
            return s;
        }

        if(leftShifts <0 || rightShifts <0){
            return s;
        }
        if(leftShifts == rightShifts){
            return s;
        }
        char[] sArray = s.toCharArray();
        if(leftShifts>rightShifts){
            rotateStringLeft(sArray,(leftShifts-rightShifts));
        }else{
            rotateStringRight(sArray,(rightShifts-leftShifts));
        }

        return new String(sArray);

    }

    private static void rotateStringLeft(char[] a, int k) {
        int rotationLength = k;
        if (k > a.length) {
            rotationLength = k % a.length;
        }
        reverseArray(a, 0, rotationLength - 1);
        reverseArray(a, rotationLength, a.length - 1);
        reverseArray(a, 0, a.length - 1);
    }

    private static void rotateStringRight(char[] a, int k) {
        int rotationLength = k;
        if (k > a.length) {
            rotationLength = k % a.length;
        }
        reverseArray(a, 0, a.length - rotationLength - 1);
        reverseArray(a, a.length-rotationLength, a.length - 1);
        reverseArray(a, 0, a.length - 1);
    }

    private static void reverseArray(char[] a, int start, int end) {
        if (start > end) {

        }
        while (start <= end) {
            swap(a, start, end);
            start++;
            end--;
        }
    }

    private static void swap(char[] a, int x, int y) {
        char temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
